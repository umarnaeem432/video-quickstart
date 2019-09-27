package com.twilio.video.quickstart.activity;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

public class FcmNotifier {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void sendNotification(final String body, final String title, final String roomName) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    JSONObject json = new JSONObject();
                    JSONObject dataJson = new JSONObject();
                    dataJson.put("text", body);
                    dataJson.put("title", title);
                    dataJson.put("roomName", roomName);
                    dataJson.put("priority", "high");
                    json.put("data", dataJson);
                    // d9p_8IVfuBQ:APA91bGwfWWLikn0Ir4IdBhoGZGwfAS1pZ7HbqCEhsBoWzpipkX393F2jVGw4_TUQwZzA_5Dm8Cnrz0JeYcZ-T_XsOb5q5N7zwovgnhqdMYMrBCtGT-QjHcjaxzIKLfYgwKO2KvVsAL5
                    json.put("to", "fr4DI6KySF4:APA91bF8cyXC0i1HRNi5fx2MnNSxsfjOqivhCPi_VIWXSrCcGEouQYy6fHZt3ureaXh1jXOHUba6VDNZ2Va9RfY9otPRYVL2aCLQJCzmNsrmXyUY8JGrIlTgl3D_C66nO3d-wkzhHLAb");
                    RequestBody body = RequestBody.create(JSON, json.toString());
                    Request request = new Request.Builder()
                            .header("Authorization", "key=AIzaSyCFaHnGA_1FiC9sjBSWvPzOJpzIOoFEqDA")
                            .post(body)
                            .url("https://fcm.googleapis.com/fcm/send")
                            .build();
                    Response response = client.newCall(request).execute();
                    String finalResponse = response.body().string();
                    Log.i("FcmNotifier", finalResponse);
                } catch (Exception e) {
                    Log.i("FcmNotifier",e.getMessage());
                }
                return null;
            }
        }.execute();
    }
}