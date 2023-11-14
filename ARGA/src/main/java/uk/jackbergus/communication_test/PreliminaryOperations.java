package uk.jackbergus.communication_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.bcel.generic.DADD;
import uk.jackbergus.ARGA.ARGAAPI;
import uk.jackbergus.ARGA.Database;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class PreliminaryOperations implements BiConsumer<ARGAAPI, Database> {

    @Override
    public void accept(ARGAAPI api, Database db) {
        var mapper = new ObjectMapper();
        String corpus = "US2016";
        Set<String> someDocuments = Arrays.stream( new String[]{"nodeset10032","nodeset10042"/*,"nodeset10050","nodeset10056","nodeset10057","nodeset10058","nodeset10063","nodeset10229","nodeset10239","nodeset10240","nodeset10241","nodeset10243","nodeset10244","nodeset10247","nodeset10248","nodeset10250","nodeset10253","nodeset10273","nodeset10281","nodeset10285","nodeset10299","nodeset10300","nodeset10306","nodeset10310","nodeset10312","nodeset10314","nodeset10317","nodeset10320","nodeset10322","nodeset10324","nodeset10337","nodeset10363","nodeset10365","nodeset10367","nodeset10370","nodeset10371","nodeset10375","nodeset10376","nodeset10384","nodeset10385","nodeset10388","nodeset10389","nodeset10391","nodeset10393","nodeset10395","nodeset10400","nodeset10402","nodeset10405","nodeset10406","nodeset10407","nodeset10409","nodeset10410","nodeset10411","nodeset10412","nodeset10413","nodeset10414","nodeset10416","nodeset10419","nodeset10436","nodeset10443","nodeset10444","nodeset10445","nodeset10450","nodeset10453","nodeset10454","nodeset10457","nodeset10459","nodeset10462","nodeset10465","nodeset10474","nodeset10477","nodeset10482","nodeset10484","nodeset10488","nodeset10489","nodeset10492","nodeset10493","nodeset10494","nodeset10495","nodeset10498","nodeset10499","nodeset10506","nodeset10508","nodeset10510","nodeset10513","nodeset10514","nodeset10540","nodeset10546","nodeset10547","nodeset10549","nodeset10556","nodeset10557","nodeset10558","nodeset10559","nodeset10561","nodeset10562","nodeset10563","nodeset10566","nodeset10567","nodeset10569","nodeset10570","nodeset10573","nodeset10574","nodeset10576","nodeset10579","nodeset10581","nodeset10586","nodeset10588","nodeset10589","nodeset10590","nodeset10591","nodeset10593","nodeset10594","nodeset10595","nodeset10607","nodeset10608","nodeset10610","nodeset10621","nodeset10622","nodeset10627","nodeset10631","nodeset10632","nodeset10634","nodeset10660","nodeset10664","nodeset10665","nodeset10670","nodeset10700","nodeset10701","nodeset10810","nodeset10811","nodeset10814","nodeset10815","nodeset10820","nodeset10825","nodeset10827","nodeset10832","nodeset10834","nodeset10836","nodeset10837","nodeset10840","nodeset10842","nodeset10848","nodeset10849","nodeset10854","nodeset10857","nodeset10860","nodeset10862","nodeset10864","nodeset10867","nodeset11321","nodeset9675","nodeset9679","nodeset9706","nodeset9751","nodeset9801","nodeset9812","nodeset9839","nodeset9840","nodeset9842","nodeset9845","nodeset9846","nodeset9851","nodeset9854","nodeset9877"*/}).collect(Collectors.toUnmodifiableSet());
//        var client = new ARGA_API();

        var corpora = api.listCorpora();
        if (corpora.contains(corpus)) {
            db.corpusIdAsLocutor(corpus); // Optional initialisation
            var documents =  api.listDocuments(corpus);
            for (var id : documents) {
                if (someDocuments.contains(id)) {
                    db.storeDocumentIntoARGADocument(corpus, id);
                }
            }
            for (var src: someDocuments) {
                for (var dst: someDocuments) {
                    if (!Objects.equals(src, dst)) {
                        if (db.linkDocumentAcrossCorpora(corpus, src, corpus, dst)) {
                            System.out.println(src+"-->"+dst);
                        }
                    }
                }
            }
            try {
                String json = mapper.writeValueAsString(
                        db.representLoadedAsArgGraph());
                System.out.println(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("UNEXPECTED ERROR: expecting the dataset to contain the corpus");
        }
    }

}
