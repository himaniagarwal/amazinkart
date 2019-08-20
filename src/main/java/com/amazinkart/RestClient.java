package com.amazinkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class RestClient {

    String getDetails(String givenUrl) throws IOException {
        URL url = new URL(givenUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        StringBuilder response = new StringBuilder();
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            response.append(output);
        }
        conn.disconnect();
        return response.toString();
    }

}
