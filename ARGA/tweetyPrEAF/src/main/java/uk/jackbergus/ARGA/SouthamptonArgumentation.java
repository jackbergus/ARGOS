package uk.jackbergus.ARGA;

import jackbergus.ARGA.javanatives.DGDLMicroservice;

import java.io.File;
import java.io.FileNotFoundException;

public class SouthamptonArgumentation {
    public static void main(String args[]) throws FileNotFoundException {
        DGDLMicroservice.setup_microservice(new File("service_querier_dialogue.yaml"), new SouthamptonService());
    }
}
