package com.amazon.alexa.avs.alexaOnMirror;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MirrorConnectionService {

    private static final Logger log = LoggerFactory.getLogger(MirrorConnectionService.class);
    private final        String URL = "http://localhost:8080/refreshCardWithPayload";

    public void refreshCard(String payload) {
        log.debug(payload);
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(URL);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("card", payload));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            log.debug(response.toString());
            //System.err.println("Resonse: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
