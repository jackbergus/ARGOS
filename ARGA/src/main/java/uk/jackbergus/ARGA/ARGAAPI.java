package uk.jackbergus.ARGA;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ARGAAPI {
    public List<String> listCorpora();
    public List<String> listDocuments(String corpusId) throws InterruptedException;
}
