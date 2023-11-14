package uk.jackbergus.communication_test;

import uk.jackbergus.ARGA.ARGAAPI;
import uk.jackbergus.ARGA.Database;

import java.util.function.BiConsumer;

public class ListDocuments  implements BiConsumer<ARGAAPI, Database> {
    @Override
    public void accept(ARGAAPI argaapi, Database database) {
        for (String x : argaapi.listCorpora()) {
            System.out.println(argaapi.listDocuments(x));
        }
    }
}
