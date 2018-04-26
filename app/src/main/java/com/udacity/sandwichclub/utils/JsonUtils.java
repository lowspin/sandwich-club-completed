package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject json_sandwich = new JSONObject(json.replace("\\",""));
            JSONObject json_name = json_sandwich.getJSONObject("name");

            return new Sandwich(
                    json_name.getString("mainName"),
                    getStringListFromJsonArray(json_name.getJSONArray("alsoKnownAs")),
                    json_sandwich.getString("placeOfOrigin"),
                    json_sandwich.getString("description"),
                    json_sandwich.getString("image"),
                    getStringListFromJsonArray(json_sandwich.getJSONArray("ingredients"))
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    private static List<String> getStringListFromJsonArray(JSONArray jArray) throws JSONException {
        List<String> returnList = new ArrayList<String>();
        for (int i = 0; i < jArray.length(); i++) {
            String val = jArray.getString(i);
            returnList.add(val);
        }
        return returnList;
    }

}
