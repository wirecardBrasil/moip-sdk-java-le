package br.com.moip.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public abstract class DataHelper {

    public static String jsonToUrlEncodedString(JsonObject jsonObject) {
        return jsonToUrlEncodedString(jsonObject, "");
    }

    private static String jsonToUrlEncodedString(JsonObject jsonObject, String prefix) {
        StringBuilder url = new StringBuilder("");
        Boolean firstEntry = true;

        try {
            for (Map.Entry<String, JsonElement> item : jsonObject.entrySet()) {
                if (!firstEntry) {
                    url.append("&");
                }

                if (item.getValue() != null && item.getValue().isJsonObject()) {
                    url.append(jsonToUrlEncodedString(
                            item.getValue().getAsJsonObject(),
                            prefix.isEmpty() ? item.getKey() : prefix + "[" + item.getKey() + "]"
                            )
                    );
                } else {
                    url.append(prefix.isEmpty() ?
                            item.getKey() + "=" + URLEncoder.encode(item.getValue().getAsString(), "UTF-8") :
                            prefix + "[" + item.getKey() + "]=" + URLEncoder.encode(item.getValue().getAsString(), "UTF-8")
                    );
                }

                firstEntry = false;
            }

        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url.toString();
    }


}
