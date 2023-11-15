package jackbergus.ARGA;

import DundeeLogic.ArgGraph;
import jackbergus.ARGA.javanatives.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ARGAAPI {

    private final Service miner, linker, querier;

    protected ARGAAPI(Service miner, Service linker, Service querier) {
        this.miner = miner;
        this.linker = linker;
        this.querier = querier;
    }

    public abstract List<String> listCorpora();
    public abstract List<String> listDocuments(String corpusId);
    public abstract String getDocument(String corpusId, String documentId);
    public abstract ArgGraph getArgumentationGraph(String corpusId, String documentId);
    public abstract boolean hasGoldenRetriever();
    public abstract boolean hasARGALinker();
    public abstract String southamptonQuery(ArgGraph g, Map<String, List<String>> args);
    public abstract String link(String src, String DST, HashMap<String, String> map);


    public String getRetrieverServer() {
        return miner.url;
    }

    public int getRetrieverPort() {
        return miner.port;
    }

    public String getRetrieverServiceName() {
        return miner.serviceName;
    }

    public String getProbServiceName() {
        return querier.serviceName;
    }

    public int getProbPort() {
        return querier.port;
    }

    public String getProbServer() {
        return querier.url;
    }

    public String getLinkerServiceName() {
        return linker.serviceName;
    }

    public int getLinkerPort() {
        return linker.port;
    }

    public String getLinkerServer() {
        return linker.url;
    }
}
