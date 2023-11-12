package uk.jackbergus.communication_test;

import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import scala.util.parsing.combinator.testing.Str;
import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;
import uk.jackbergus.DundeeLogic.ArgGraph;

public class SouthamptonQuerier {
    private final String server;
    private final int port;

    static ObjectMapper mapper = new ObjectMapper();

    public SouthamptonQuerier(AlgorithmicInstance southamptonQuerier) {
        this.server = southamptonQuerier.url;
        this.port = southamptonQuerier.port;
    }

    public String query(ArgGraph g, MultiValueMap<String, String> args) {
        var x = UriComponentsBuilder.fromUriString(server).port(port).path("request");
//        var x = UriBuilder.fromUri(server).port(port).path("request");
        for (var key : args.keySet()) {
            x = x.queryParam(key, args.get(key).toArray());
        }
        var url = x.build();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url.toUri());
        httpPost.setHeader("Content-type", "application/json");
        try {
            String stirngA = mapper.writeValueAsString(g);
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
