import java.util.ArrayList;
import java.util.List;

public class StatisticsCollector {

    private static final CoinbaseApiReader priceReader = CoinbaseApiReader.getInstance();
    private static List<Double> prices = new ArrayList<>();
    private static final int COLLECTION_INTERVAL = 60000;
    private CryptoStatisticsCalculator cryptoStatisticsCalculator;

    public StatisticsCollector(CryptoStatisticsCalculator cryptoStatisticsCalculator) {
        this.cryptoStatisticsCalculator = cryptoStatisticsCalculator;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void clearPrices() {
        prices.clear();
    }

    public void collectStatistic() {
        while (true) {
            double currentPrice = priceReader.getPrice(cryptoStatisticsCalculator.getCryptoCoin());
            prices.add(currentPrice);
            try {
                Thread.sleep(COLLECTION_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cryptoStatisticsCalculator.onPriceUpdate(currentPrice);
        }
    }
}
