package com.beehome;

import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SwitchPlug {
    MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    String url = "http://192.168.3.158:8123/api/services/switch/";
    String entity = "{\"entity_id\": \"switch.smartvplug\"}";

    public void TurnOn() throws IOException {
        String response = post(url + "turn_on", entity);
        System.out.println(response);
    }

    public void TurnOff() throws IOException {
        String response = post(url + "turn_off", entity);
        System.out.println(response);
    }

    String post(String url, String json) throws IOException {
        System.out.println(url);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url).header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiI3YmRhMGYyNDQzM2I0Y2QyYmU1YmY3MTZmOWIxMjFlZCIsImlhdCI6MTYyODU3MjYzMiwiZXhwIjoxOTQzOTMyNjMyfQ.KYHoMWzgR49EURqp5UdrQ8ua-477BynOg3KkXl09w4o")
                .post(body)
                .build();
        System.out.println(request.toString());
        System.out.println(request.body());
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}