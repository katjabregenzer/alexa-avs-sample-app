package com.amazon.alexa.avs.alexaOnMirror;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.util.Fields;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MirrorConnectionService {

    private final String URL = "http://localhost:8080/refreshCardWithPayload";
    private static final Logger log = LoggerFactory.getLogger(MirrorConnectionService.class);

    public void refreshCard(String payload) {
        log.debug(payload);
        try {
            final SslContextFactory sslContextFactory = new SslContextFactory();
            HttpClient httpClient = new HttpClient(sslContextFactory);
            httpClient.start();

            Fields fields = new Fields();

            fields.put("card", payload);
            final ContentResponse contentResponse = httpClient.FORM(URL, fields);
            log.debug(contentResponse.getContentAsString());

        } catch (Exception e) {
            e.printStackTrace();
        }

      /*  HttpClient client = HttpClientBuilder.create().build();
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
        }*/
    }
}
