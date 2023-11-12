package uk.jackbergus.DundeeLogic;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysis;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisReasoner;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisReasonerParameters;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysisResult;

import java.util.Collections;

import static org.tweetyproject.arg.peaf.Runner.actualRunningForTheories;

@SpringBootApplication
@RestController
public class Service {

    public static void main(String... args) {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        SpringApplication.run(Service.class, args);
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
            var input = dundeeGraph.asSouthamptonQuery(results);
            return  actualRunningForTheories(null, input);
        }

    }

}
