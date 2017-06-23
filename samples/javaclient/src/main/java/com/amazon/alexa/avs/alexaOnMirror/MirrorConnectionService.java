package com.amazon.alexa.avs.alexaOnMirror;

import com.amazon.alexa.avs.message.response.templateruntime.RenderTemplate;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MirrorConnectionService {

    private final String URL = "http://localhost:8080/refreshCardWithPayload";
    private static final Logger log = LoggerFactory.getLogger(MirrorConnectionService.class);

    public void refreshCard(RenderTemplate payload) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);
        post.setHeader("X-GWT-Permutation", "3DE824138FE65400740EC1816A73CACC");
        post.setHeader("Content-Type", "text/x-gwt-rpc; charset=UTF-8");
        log.debug(payload.getTextField());
        try {
           // StringEntity se = new StringEntity( payload.getTextField());
            //post.setEntity(se);
            HttpResponse response = client.execute(post);

            // Print out the response message
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
