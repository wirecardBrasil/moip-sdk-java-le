package br.com.moip.util;

import br.com.moip.request.ApiDateRequest;
import br.com.moip.resource.ApiDate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GsonFactory {

    public static Gson gson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .registerTypeAdapter(Date.class, new BirthdateRequestSerializer())
                .registerTypeAdapter(ApiDateRequest.class, new ApiDateSerializer())
                .registerTypeAdapter(ApiDate.class, new ApiDateDeserializer())
                .create();
    }
}

class BirthdateRequestSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(sdf().format(src));
    }

    @Override
    public Date deserialize(JsonElement jsonElement, Type type,
                            JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        try {
            return sdf().parse(jsonElement.getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    private SimpleDateFormat sdf() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

}

class ApiDateSerializer implements JsonSerializer<ApiDateRequest> {

    @Override
    public JsonElement serialize(ApiDateRequest src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new JsonPrimitive(format.format(src.getDate()));
    }
}

class ApiDateDeserializer implements JsonDeserializer<ApiDate> {

    @Override
    public ApiDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ApiDate apiDate = new ApiDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            apiDate.setDate(simpleDateFormat.parse(json.getAsJsonPrimitive().getAsString()));
            return apiDate;
        } catch (ParseException e) {
            return null;
        }
    }
}
