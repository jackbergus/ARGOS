package uk.jackbergus.communication_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;

import java.util.ArrayList;
import java.util.List;

public class Corpora {
    private final String server;
    private final int port;

    public Corpora(AlgorithmicInstance algo) {
        this.server = algo.url;
        this.port = algo.port;
    }

    public List<Corpus> listCorpora() {
        String x;
        try {
            x = CommunicationUtils.getHTML(server + ":" + port + "/corpora");
        } catch (Exception e) {
            return new ArrayList<>();
        }
        try {
            List<String> tmp = APINonDGDL.mapper.readValue(x, APINonDGDL.listOfStringType);
            List<Corpus> ls = new ArrayList<>(tmp.size());
            for (String y : tmp)
                ls.add(new Corpus(server, port, y));
            return ls;
        } catch (JsonProcessingException e) {
            return new ArrayList<>();
        }
    }

}
