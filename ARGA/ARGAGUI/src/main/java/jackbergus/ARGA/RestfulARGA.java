package jackbergus.ARGA;

import DundeeLogic.ArgGraph;
import DundeeLogic.MinedLinks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jackbergus.ARGA.javanatives.Service;
import jackbergus.communication_test.CommunicationUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

/**
 * Running ARGA as an HTTP server
 */
public class RestfulARGA extends ARGAAPI {

    static ObjectMapper mapper = new ObjectMapper();
    static CollectionType listOfStringType = TypeFactory.defaultInstance().constructCollectionType(List.class, String.class);
    static CollectionType minedLinksType = TypeFactory.defaultInstance().constructCollectionType(List.class, MinedLinks.class);

    protected RestfulARGA(Service miner, Service linker, Service querier) {
        super(miner, linker, querier);
    }


    @Override
    public boolean hasGoldenRetriever() {
        try {
             CommunicationUtils.getHTML(getRetrieverServer() + ":" + getRetrieverPort() + "/corpora");
             return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean hasARGALinker() {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("src", "null");
            map.put("dst", "null");
            String x = CommunicationUtils.getMultipartFile(getLinkerServer() + ":" + getLinkerPort() + "/extract_links?src=SRC&dst=DST", map);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String southamptonQuery(ArgGraph g, Map<String, List<String>> args) {
        var x = UriComponentsBuilder.fromUriString(getProbServer()).port(getProbPort()).path("request");
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

    @Override
    public String link(String src, String dst, HashMap<String, String> map) {
        return CommunicationUtils.getMultipartFile(getLinkerServer() + ":" + getLinkerPort() + "/extract_links?src=" + src + "&dst=" + dst, map);
    }

    @Override
    public List<String> listCorpora() {
        String x;
        try {
            x = CommunicationUtils.getHTML(getRetrieverServer() + ":" + getRetrieverPort() + "/corpora");
        } catch (Exception e) {
            return new ArrayList<>();
        }
        try {
            return mapper.readValue(x, listOfStringType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> listDocuments(String corpusId) {
        return new ArrayList<>(setDocuments(corpusId));
    }

    private Set<String> setDocuments(String corpusId) {
        Set<String> s = new HashSet<>();
        String x;
        try {
            x = CommunicationUtils.getHTML(getRetrieverServer() + ":" + getRetrieverPort() + "/corpora/" + corpusId);
        } catch (Exception e) {
            return Collections.emptySet();
        }
        try {
            List<String> tmp = mapper.readValue(x, listOfStringType);
            s.addAll(tmp);
            return s;
        } catch (JsonProcessingException e) {
            return Collections.emptySet();
        }
    }

    @Override
    public String getDocument(String corpusId, String documentId) {
//            if (setDocuments(corpusId).contains(documentId))
            {
                try {
                    return CommunicationUtils.getHTML(getRetrieverServer() + ":" + getRetrieverPort() + "/get/" + corpusId + "/" + documentId);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
//                    throw new RuntimeException(e);
                }
            }
//            return null;
    }

    @Override
    public ArgGraph getArgumentationGraph(String corpusId, String documentId) {
//        if (setDocuments(corpusId).contains(documentId))
        {
            try {
                var str = CommunicationUtils.getHTML(getRetrieverServer() + ":" + getRetrieverPort() + "/mine/" + corpusId + "/" + documentId);
                ArgGraph itemWithOwner = mapper.readValue(str, ArgGraph.class);
                itemWithOwner.init(null);
                itemWithOwner.json = str;
                return itemWithOwner;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
//        return null;
    }


}
