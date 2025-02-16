package com.qa.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonReader {

    public static Object[][] getJsonData(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        JSONArray jsonArray = (JSONArray) parser.parse(reader);

        if (jsonArray == null || jsonArray.isEmpty()) {
            throw new NullPointerException("JSON Array is empty. Check your JSON file.");
        }

        Object[][] testData = new Object[jsonArray.size()][2];

        Iterator<JSONObject> iterator = jsonArray.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();

            // Check for null values to avoid NullPointerException
            String username = jsonObject.get("User") != null ? jsonObject.get("User").toString() : "";
            String password = jsonObject.get("Password") != null ? jsonObject.get("Password").toString() : "";

            testData[index][0] = username;
            testData[index][1] = password;
            index++;
        }
        return testData;
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginDataProvider() throws IOException, ParseException {
        return getJsonData("src\\main\\resources\\MOCK_DATA_Credentias.json");
    }
}
