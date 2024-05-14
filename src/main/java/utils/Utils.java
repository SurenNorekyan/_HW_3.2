package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static String[] readProductInfoFromJSON(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        JSONArray productArray = (JSONArray) jsonParser.parse(reader);

        String[] productInfo = new String[productArray.size() * 2];

        for (int i = 0; i < productArray.size(); i++) {
            JSONObject product = (JSONObject) productArray.get(i);
            String productName = (String) product.get("title");
            String productPrice = String.valueOf(product.get("price"));

            productInfo[i * 2] = productName;
            productInfo[i * 2 + 1] = productPrice;
        }

        return productInfo;
    }
}
