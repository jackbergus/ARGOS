package jackbergus.ARGA.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URI;
import java.net.URL;

public class HTTPRequests {

    public static String getRequest(String url) {
        HttpClient httpClient = new DefaultHttpClient();
        var httpPost = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            return new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String putRequest(String url, String stirngA, String type) {
        HttpClient httpClient = new DefaultHttpClient();
        var httpPost = new HttpPut(url);
        if (type != null)
            httpPost.setHeader("Content-type", type);
        try {
            StringEntity stringEntity = new StringEntity(stirngA, "UTF-8");
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            return new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String postRequest(String url, String stirngA, String type) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        if (type != null)
            httpPost.setHeader("Content-type", type);
        try {
            StringEntity stringEntity = new StringEntity(stirngA, "UTF-8");
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            return new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String postRequest(URI url, String stirngA, String type) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        if (type != null)
            httpPost.setHeader("Content-type", type);
        try {
            StringEntity stringEntity = new StringEntity(stirngA, "UTF-8");
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            return new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
