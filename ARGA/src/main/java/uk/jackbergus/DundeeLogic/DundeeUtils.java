package uk.jackbergus.DundeeLogic;

public class DundeeUtils {

    public static String getTextFromEdgeType(String type) {
        if (type.equals("MA")) {
            return "Restating";
        } else if (type.equals("RA")) {
            return "Arguing";
        } else if (type.equals("CA")) {
            return "Disagreeing";
        } else
            throw new RuntimeException("UNEXPECTED TYPE! "+ type);
    }

    public static String getSchemeFromEdgeType(String type) {
        if (type.equals("MA")) {
            return "Default Rephrase";
        } else if (type.equals("RA")) {
            return "Default Inference";
        } else if (type.equals("CA")) {
            return "Default Conflict";
        } else
            throw new RuntimeException("UNEXPECTED TYPE! "+ type);
    }

    public static String getSchemeIDFromEdgeType(String type) {
        if (type.equals("MA")) {
            return "144";
        } else if (type.equals("RA")) {
            return "72";
        } else if (type.equals("CA")) {
            return "71";
        } else
            throw new RuntimeException("UNEXPECTED TYPE! "+ type);
    }

}
