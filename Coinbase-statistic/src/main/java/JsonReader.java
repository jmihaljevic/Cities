import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

    private static JsonReader instance = new JsonReader();

    private JsonReader(){}

    public static JsonReader getInstance(){
        return instance;
    }

    public String readJsonFromUrl(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder jsonText = new StringBuilder();
            while (true)
            {
                String line = rd.readLine();
                if (line == null) break;
                jsonText.append(line);
            }
            JSONObject json = new JSONObject(jsonText.toString());
            return json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}