package uk.jackbergus.ARGA;

import DundeeLogic.ArgEdge;
import DundeeLogic.ArgGraph;
import DundeeLogic.ArgNode;
import DundeeLogic.SouthamptonJSONInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONEdge;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONNode;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONTheory;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysis;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisReasoner;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisReasonerParameters;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisResult;
import scala.util.parsing.combinator.testing.Str;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static org.tweetyproject.arg.peaf.Runner.actualRunningForTheories;

@SpringBootApplication
@RestController
public class SouthamptonService implements Function<String, String> {



    public static void main(String... args) {
//        String log4jConfPath = "log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
        SpringApplication.run(SouthamptonService.class, args);
    }

    public static AIFJSONNode asSouthamptonNode(ArgNode node) {
        var result = new AIFJSONNode();
        result.nodeID = node.nodeID;
        result.text = node.text;
        result.type = node.type;
        return result;
    }

    public static AIFJSONEdge asSouthamptonEdge(ArgEdge edge) {
        var result = new AIFJSONEdge();
        result.edgeID = edge.edgeID;
        result.fromID = edge.fromID;
        result.toID = edge.toID;
        return result;
    }

    /**
     * A Southampton theory is a Dundee argumentation graph with some additional queries associated to them
     * @param ls    List of queries of interest
     * @return      Argumentation graph extended with some queries
     */
    public static AIFJSONTheory asSouthamptonQuery(ArgGraph g, AIFJSONAnalysis... ls) {
        var result = new AIFJSONTheory();
        if ((g.nodes != null) && (!g.nodes.isEmpty())) {
            result.nodes = new AIFJSONNode[g.nodes.size()];
            for (int i = 0; i<g.nodes.size(); i++) {
                result.nodes[i] = asSouthamptonNode(g.nodes.get(i));
            }
        } else {
            result.nodes = new AIFJSONNode[0];
        }
        if ((g.edges != null) && (!g.edges.isEmpty())) {
            result.edges = new AIFJSONEdge[g.edges.size()];
            for (int i = 0; i<g.edges.size(); i++) {
                result.edges[i] = asSouthamptonEdge(g.edges.get(i));
            }
        } else {
            result.edges = new AIFJSONEdge[0];
        }
        result.analyses = ls;
        // Ignore locutions
        return result;
    }

    @PostMapping("/request")
    public AIFJSONAnalysisResult[] world(@RequestBody ArgGraph dundeeGraph,
                                         @RequestParam MultiValueMap<String, String> args) {
        String[] query = args.getOrDefault("query", Collections.emptyList()).toArray(String[]::new);
        if (query.length == 0) {
            // If there is no query entry-point, then return immediately the dundeeGraph without any further ado
            return null;
        } else {
            String[] type = args.getOrDefault("type", Collections.singletonList("preferred")).toArray(String[]::new);
            String[] semantics = args.getOrDefault("semantics", Collections.singletonList("preferred")).toArray(String[]::new);
            String[] target = null;
            {
                var lsTarget = args.get("target");
                if ((lsTarget != null) && (!lsTarget.isEmpty())) {
                    target = lsTarget.toArray(String[]::new);
                }
            }
            String[] objective = null;
            {
                var lsObjective = args.get("objective");
                if ((lsObjective != null) && (!lsObjective.isEmpty())) {
                    objective = lsObjective.toArray(String[]::new);
                }
            }
            String[] noThreads = args.getOrDefault("threads", Collections.singletonList("1")).toArray(String[]::new);
            String[] errorLevel = args.getOrDefault("errorLevel", Collections.singletonList("0.1")).toArray(String[]::new);
            AIFJSONAnalysis[] results = new AIFJSONAnalysis[type.length * noThreads.length * errorLevel.length * semantics.length];
            int k = 0;
            for (String semantic : semantics) {
                for (String s : errorLevel) {
                    for (String noThread : noThreads) {
                        for (String value : type) {
                            results[k] = new AIFJSONAnalysis();
                            results[k].query = query;
                            results[k].reasoner = new AIFJSONAnalysisReasoner();
                            results[k].result = new AIFJSONAnalysisResult();
                            results[k].reasoner.type = value;
                            results[k].reasoner.parameters = new AIFJSONAnalysisReasonerParameters();
                            results[k].reasoner.parameters.noThreads = Integer.parseInt(noThread);
                            results[k].reasoner.parameters.errorLevel = Double.parseDouble(s);
                            results[k].reasoner.parameters.target = target;
                            results[k].reasoner.parameters.objective = objective;
                            results[k].reasoner.parameters.semantics = semantic;
                            k++;
                        }
                    }
                }
            }
            var input = asSouthamptonQuery(dundeeGraph, results);
            return  actualRunningForTheories(null, input);
        }

    }

    @Override
    public String apply(String s) {
        var mapper = new ObjectMapper();
        try {
            var q = new SouthamptonJSONInput(s);
            MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
            for (var x : q.query.entrySet())
                args.addAll(x.getKey(), x.getValue());
            q.query.clear();
            var result = world(q.graph, args);
            var res = mapper.writeValueAsString(result);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
