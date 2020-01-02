import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert a currency (BTC/ETH):");
        String currency = reader.readLine();
        System.out.println("Enter the desired minimum amount:");
        double minimumPrice = Double.parseDouble(reader.readLine());
        System.out.println("Enter the desired maximum amount:");
        double maximumPrice = Double.parseDouble(reader.readLine());

        CryptoStatisticsCalculator instance = new CryptoStatisticsCalculator(minimumPrice, maximumPrice, CryptoCoin.valueOf(currency));
        instance.getStatisticsCollector().collectStatistic();
    }
}
