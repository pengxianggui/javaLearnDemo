package com.pengxg.demo.http.request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {

    public static void main(String... args) {
        Main main = new Main();
//        main.requestGET();
        main.requestGet();
    }

    public void requestGET() {
        HttpRequest request = HttpRequest.get("https://app.ravenpack.com/downloads/getfile?id=8FC0C14871C9BEF0075D22EF3ACC5320")
                .header("api_key", "eJhGuBGhuIvXERBjpKBET4");
        request.connectTimeout(600000);
        File file = new File("response.out.csv");
        request.receive(file);
//        request.send()
    }

    public void requestGet() {
//        HttpClient httpClient = new DefaultHttpClient();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        File file = new File("response.out1.csv");

        final OutputStream output;
        try {
            output = new BufferedOutputStream(new FileOutputStream(file));
            HttpGet httpGetRequest = new HttpGet("https://app.ravenpack.com/downloads/getfile?id=EF9452387DDF4D4A92885B3071A209ED");
            httpGetRequest.addHeader("api_key", "eJhGuBGhuIvXERBjpKBET4");
//            httpGetRequest.setHeader("api_key", "eJhGuBGhuIvXERBjpKBET4");
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            System.out.println("----------------------------------------");

            HttpEntity entity = httpResponse.getEntity();

            byte[] buffer = new byte[1024];
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                try {
                    int bytesRead = 0;
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    while ((bytesRead = bis.read(buffer)) != -1) {
//                        String chunk = new String(buffer, 0, bytesRead);
//                        System.out.println(chunk);
                        output.write(buffer,0, bytesRead);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try { inputStream.close(); } catch (Exception ignore) {}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            httpClient.getConnectionManager().shutdown();
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
