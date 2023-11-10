package uk.jackbergus.DundeeLogic;

import uk.jackbergus.ARGA.structure.locutors.Locutor;

public class Locutions {
    public String nodeID;
    public String personID;
    public String timestamp;
    public String start;
    public String end;
    public String source;

    public Locutor asLocutor() {
        var loc = new Locutor();
        loc.name = personID;
        loc.affiliation = source;
        loc.role = "annotation";
        return loc;
    }

    public Locutions() {
    }

    public Locutions(Locutor from) {
        nodeID = String.valueOf(System.identityHashCode(from));
        personID = from.name;
        source = from.affiliation;
    }
}
