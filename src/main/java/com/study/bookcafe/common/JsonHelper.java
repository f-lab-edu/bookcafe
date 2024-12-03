package com.study.bookcafe.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.time.LocalDate;

public class JsonHelper {
    private static Gson gson;

    public static Gson getGson() {
        if(gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .disableHtmlEscaping()
                    .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                    .create();
        }

        return gson;
    }
}
