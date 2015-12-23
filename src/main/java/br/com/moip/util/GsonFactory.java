package br.com.moip.util;

import br.com.moip.request.BoletoRequest;
import br.com.moip.resource.Boleto;
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
                .registerTypeAdapter(BoletoRequest.ExpirationDateRequest.class, new ExpirationDateSerializer())
                .registerTypeAdapter(Boleto.ExpirationDate.class, new ExpirationDateDeserializer())
                .create();
    }
}

class BirthdateRequestSerializer implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new JsonPrimitive(format.format(src));
    }
}

class ExpirationDateSerializer implements JsonSerializer<BoletoRequest.ExpirationDateRequest> {

    @Override
    public JsonElement serialize(BoletoRequest.ExpirationDateRequest src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new JsonPrimitive(format.format(src.getDate()));
    }
}

class ExpirationDateDeserializer implements JsonDeserializer<Boleto.ExpirationDate> {

    @Override
    public Boleto.ExpirationDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Boleto.ExpirationDate expirationDate = new Boleto(). new ExpirationDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            expirationDate.setDate(simpleDateFormat.parse(json.getAsJsonPrimitive().getAsString()));
            return expirationDate;
        } catch (ParseException e) {
            return null;
        }
    }
}
