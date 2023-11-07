package uk.jackbergus.communication_test;

import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;
import uk.jackbergus.ARGA.structure.ArgaDocument;
import uk.jackbergus.DundeeLogic.MinedLinks;

import java.util.HashMap;
import java.util.List;

public class LinkExtractor {

    private final String server;
    private final int port;

    public LinkExtractor(AlgorithmicInstance x) {
        this.server = x.url;
        this.port = x.port;
    }

    public List<MinedLinks> linkDocuments(HashMap<String, String> resolver, ArgaDocument src, ArgaDocument dst) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("src", resolver.get(src.mnemonicName.replace("_argumentation", "")));
            map.put("dst", resolver.get(dst.mnemonicName.replace("_argumentation", "")));
            String x = CommunicationUtils.getMultipartFile(server + ":" + port + "/extract_links?src=" + src.mnemonicName.replace("_argumentation", "") + "&dst=" + dst.mnemonicName.replace("_argumentation", ""), map);
            return APINonDGDL.mapper.readValue(x, APINonDGDL.minedLinksType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
