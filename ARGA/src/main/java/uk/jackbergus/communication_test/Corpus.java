package uk.jackbergus.communication_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import uk.jackbergus.DundeeLogic.ArgGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Corpus {
    private final String server;
    private final int port;
    private final String corpus;

    public Corpus(String server, int port, String corpus) {
        this.server = server;
        this.port = port;
        this.corpus = corpus;
    }

    public String getText(String documentId) {
        if (getDocumentIDs().contains(documentId)) {
            try {
                return CommunicationUtils.getHTML(server + ":" + port + "/get/" + corpus + "/" + documentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public ArgGraph getArga(String documentId) {
        if (getDocumentIDs().contains(documentId)) {
            try {
                var str = CommunicationUtils.getHTML(server + ":" + port + "/mine/" + corpus + "/" + documentId);
                ArgGraph itemWithOwner = APINonDGDL.mapper.readValue(str, ArgGraph.class);
                itemWithOwner.init();
                itemWithOwner.json = str;
                return itemWithOwner;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Set<String> getDocumentIDs() {
        Set<String> s = new HashSet<>();
        String x;
        try {
            x = CommunicationUtils.getHTML(server + ":" + port + "/corpora/" + corpus);
        } catch (Exception e) {
            return new HashSet<>();
        }
        try {
            List<String> tmp = APINonDGDL.mapper.readValue(x, APINonDGDL.listOfStringType);
            return new HashSet<>(tmp);
        } catch (JsonProcessingException e) {
            return new HashSet<>();
        }
    }
}
