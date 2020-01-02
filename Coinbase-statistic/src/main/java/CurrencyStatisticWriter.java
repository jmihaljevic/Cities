import java.io.*;
import java.text.DecimalFormat;

public class CurrencyStatisticWriter {
    private static final String filePathStatistic = "C:\\Users\\josip\\Desktop\\infinum\\Coinbase-statistic\\src\\main\\java\\statistic";
    private static final File fileStatistic;
    private static final String filePathRemarks = "C:\\Users\\josip\\Desktop\\infinum\\Coinbase-statistic\\src\\main\\java\\remarks";
    private static final File fileRemarks;

    private static CurrencyStatisticWriter instance = new CurrencyStatisticWriter();
    private CurrencyStatisticWriter(){}
    public static CurrencyStatisticWriter getInstance(){
        return instance;
    }

    static {
        fileStatistic = new File(filePathStatistic);
        fileRemarks = new File(filePathRemarks);
        if(!fileStatistic.exists()) {
            try {
                fileStatistic.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!fileRemarks.exists()) {
            try {
                fileRemarks.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(double firstPrice, double lastPrice, double maxPrice, double minPrice) {
        try (PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(fileStatistic, true)))) { //*
            pr.println("Statistic for time: " + java.time.LocalTime.now());
            pr.println("Price in first minute in this hour is: " + firstPrice + " USD");
            pr.println("Price in last minute in this hour is: " + lastPrice + " USD");
            pr.println("Maximum price in this hour is: " + maxPrice + " USD");
            pr.println("Minimum price in this hour is: " + minPrice + " USD");
            pr.println("Minimum price is " + new DecimalFormat("#.##").format((firstPrice - minPrice) / firstPrice * 100) + "% lower than first price");
            pr.println("Maximum price is " + new DecimalFormat("#.##").format((maxPrice - firstPrice) / maxPrice * 100) + "% higher than first price");
            if (firstPrice > lastPrice) {
                pr.println("Last price is " + new DecimalFormat("#.##").format((firstPrice - lastPrice) / firstPrice * 100) + "% lower than first price\n");
            } else if (firstPrice < lastPrice) {
                pr.println("First price is " + new DecimalFormat("#.##").format((lastPrice - firstPrice) / lastPrice * 100) + "% lower than last price\n");
            } else pr.println("First price is same as last price\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRemark(String remark) {
        try (PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(fileRemarks, true)))) {
            pr.println(remark);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
