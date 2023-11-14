package jackbergus.communication_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class CommunicationUtils {
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static ObjectMapper mapper = new ObjectMapper();

    public static String getMultipartFile(String urlToRead, Map<String, String> fileToContent) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlToRead);
        httpPost.setHeader("Content-type", "application/json");
        InputStream response = null;
        try {
            StringEntity stringEntity = new StringEntity(mapper.writeValueAsString(fileToContent));
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost).getEntity().getContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

            String text = new BufferedReader(
                    new InputStreamReader(response, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            return text;
    }
}
