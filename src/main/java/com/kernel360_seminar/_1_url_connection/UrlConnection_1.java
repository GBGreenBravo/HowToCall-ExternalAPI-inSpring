package com.kernel360_seminar._1_url_connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class UrlConnection_1 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    public void urlConnection() throws IOException {
        String text = URLEncoder.encode("Kernel360", StandardCharsets.UTF_8);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", apiId);
        requestHeaders.put("X-Naver-Client-Secret", apiSecret);

        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestMethod("GET");
        for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
            con.setRequestProperty(header.getKey(), header.getValue());
        }

        InputStreamReader streamReader = new InputStreamReader(con.getInputStream());

        BufferedReader lineReader = new BufferedReader(streamReader);
        StringBuilder responseBody = new StringBuilder();

        String line;
        while ((line = lineReader.readLine()) != null) {
            responseBody.append(line);
        }

        System.out.println(responseBody);
    }

//    public void urlConnection() throws IOException {
//        String text = URLEncoder.encode("그린팩토리", "UTF-8");
//
//        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // JSON 결과
//
//        Map<String, String> requestHeaders = new HashMap<>();
//        requestHeaders.put("X-Naver-Client-Id", apiId);
//        requestHeaders.put("X-Naver-Client-Secret", apiSecret);
//        String responseBody = get(apiURL,requestHeaders);
//
//        System.out.println(responseBody);
//    }
//
//    private static String get(String apiUrl, Map<String, String> requestHeaders) throws IOException {
//        HttpURLConnection con = connect(apiUrl);
//
//        con.setRequestMethod("GET");
//        for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
//            con.setRequestProperty(header.getKey(), header.getValue());
//        }
//
//        int responseCode = con.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
//            return readBody(con.getInputStream());
//        } else { // 오류 발생
//            return readBody(con.getErrorStream());
//        }
//    }
//
//    private static HttpURLConnection connect(String apiUrl) throws IOException {
//        URL url = new URL(apiUrl);
//        return (HttpURLConnection)url.openConnection();
//    }
//
//    private static String readBody(InputStream body) throws IOException {
//        InputStreamReader streamReader = new InputStreamReader(body);
//
//        BufferedReader lineReader = new BufferedReader(streamReader);
//        StringBuilder responseBody = new StringBuilder();
//
//        String line;
//        while ((line = lineReader.readLine()) != null) {
//            responseBody.append(line);
//        }
//
//        return responseBody.toString();
//    }
}
