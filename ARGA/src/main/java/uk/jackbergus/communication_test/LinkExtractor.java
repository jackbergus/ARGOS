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

    public boolean hasARGALinker() {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("src", "null");
            map.put("dst", "null");
            String x = CommunicationUtils.getMultipartFile(server + ":" + port + "/extract_links?src=SRC&dst=DST", map);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<MinedLinks> linkDocuments(HashMap<String, HashMap<String, String>> resolver,
                                          String ArgaCorpusSRC, ArgaDocument src,
                                          String ArgaCorpusDST, ArgaDocument dst) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("src", resolver.get(ArgaCorpusSRC).get(src.mnemonicName.replace("_argumentation", "")));
            map.put("dst", resolver.get(ArgaCorpusDST).get(dst.mnemonicName.replace("_argumentation", "")));
            String x = CommunicationUtils.getMultipartFile(server + ":" + port + "/extract_links?src=" + src.mnemonicName.replace("_argumentation", "") + "&dst=" + dst.mnemonicName.replace("_argumentation", ""), map);
            return ARGA_API.mapper.readValue(x, ARGA_API.minedLinksType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
