package com.example.authentication.config;

import org.apache.commons.codec.binary.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;

public class DecodedToken {

    public String sub;
    public String name;
    public Long userId;
    public Boolean admin;

    public static DecodedToken getDecoded(String encodedToken) throws UnsupportedEncodingException {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");

        return new Gson().fromJson(jsonString, DecodedToken.class);
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}