package com.amazon.alexa.avs.alexaOnMirror;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MirrorConnectionService {

    private final String URL = "http://localhost:8080/refreshCard";

    public void refreshCard() {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(URL);
        try {
            HttpResponse response = client.execute(post);

            // Print out the response message
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
