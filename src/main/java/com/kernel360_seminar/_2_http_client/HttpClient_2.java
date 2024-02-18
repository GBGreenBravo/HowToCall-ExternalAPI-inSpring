package com.kernel360_seminar._2_http_client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class HttpClient_2 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    public void httpClient() throws IOException {
        String text = URLEncoder.encode("Kernel360", StandardCharsets.UTF_8);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiURL);

        httpGet.setHeader("X-Naver-Client-Id", apiId);
        httpGet.setHeader("X-Naver-Client-Secret", apiSecret);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        String responseBody = EntityUtils.toString(entity);
        System.out.println(responseBody);
    }
}
