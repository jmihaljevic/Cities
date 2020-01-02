import java.util.*;

public class CryptoStatisticsCalculator {
    private double minimumPrice;
    private double maximumPrice;
    private boolean isLowerThanMin = false;
    private boolean isHigherThanMax = false;
    private static final int MAX_PRICES_SIZE = 60;
    private CryptoCoin cryptoCoin;
    private StatisticsCollector statisticsCollector;
    private static final CurrencyStatisticWriter currencyStatisticWriter = CurrencyStatisticWriter.getInstance();

    public CryptoStatisticsCalculator(double minimumPrice, double maximumPrice, CryptoCoin cryptoCoin) {
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
        this.cryptoCoin = cryptoCoin;
        this.statisticsCollector = new StatisticsCollector(this);
    }

    public StatisticsCollector getStatisticsCollector() {
        return statisticsCollector;
    }

    public CryptoCoin getCryptoCoin() {
        return cryptoCoin;
    }

    public void onPriceUpdate(double price) {
        checkPrice(price);
        if (statisticsCollector.getPrices().size() == MAX_PRICES_SIZE) {
            saveCryptoStatistic();
            statisticsCollector.clearPrices();
        }
    }

    private void checkPrice(double price) {
        if (price >= maximumPrice && !isHigherThanMax) {
            currencyStatisticWriter.saveRemark("The currency has reached its maximum value at: " + java.time.LocalTime.now() + "\n");
            isHigherThanMax = true;
        } else if (price < maximumPrice && isHigherThanMax) {
            currencyStatisticWriter.saveRemark("The currency fell below its maximum value at: " + java.time.LocalTime.now() + "\n");
            isHigherThanMax = false;
        } else if (price < minimumPrice && !isLowerThanMin) {
            currencyStatisticWriter.saveRemark("The currency fell below its minimum value at: " + java.time.LocalTime.now() + "\n");
            isLowerThanMin = true;
        } else if (price > minimumPrice && isLowerThanMin) {
            currencyStatisticWriter.saveRemark("The currency has reached its minimum value at: " + java.time.LocalTime.now() + "\n");
            isLowerThanMin = false;
        }
    }

    private void saveCryptoStatistic() {
        double firstPrice = statisticsCollector.getPrices().get(0);
        double lastPrice = statisticsCollector.getPrices().get(statisticsCollector.getPrices().size() - 1);
        double maxPrice = Collections.max(statisticsCollector.getPrices());
        double minPrice = Collections.min(statisticsCollector.getPrices());
        currencyStatisticWriter.writeToFile(firstPrice, lastPrice, maxPrice, minPrice);
    }
}