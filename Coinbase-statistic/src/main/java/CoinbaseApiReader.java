public class CoinbaseApiReader {

    private static final String coinbase  = "https://api.coinbase.com/v2/prices/%s-USD/spot";
    private static String urlBTC = String.format(coinbase, "BTC");
    private static String urlETH = String.format(coinbase, "ETH");
    private JsonReader jsonReader = JsonReader.getInstance();

    private static CoinbaseApiReader instance = new CoinbaseApiReader();

    private CoinbaseApiReader(){}

    public static CoinbaseApiReader getInstance(){
        return instance;
    }

    public double getPrice(CryptoCoin cryptoCoin) {
        String json = "";
        if(cryptoCoin.equals(CryptoCoin.BTC)) {
            json = jsonReader.readJsonFromUrl(urlBTC);
        }
        else if(cryptoCoin.equals(CryptoCoin.ETH)) {
            json = jsonReader.readJsonFromUrl(urlETH);
        } else {
            throw new IllegalArgumentException("The application doesn't support this type of coin");
        }
        return getPriceFromJson(json);
    }

    private double getPriceFromJson(String json) {
        int startIndex = json.indexOf("amount") + 9;
        int endIndex = json.lastIndexOf("currency") - 4;
        String price = json.substring(startIndex, endIndex + 1);
        return Double.parseDouble(price);
    }
}
