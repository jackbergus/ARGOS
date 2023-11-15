package DundeeLogic;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class ArgNode {
    public String nodeID;
    public String text;
    public String type;
    public String timestamp;
    public String scheme;
    public String schemeID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgNode argNode = (ArgNode) o;
        return Objects.equals(nodeID, argNode.nodeID) && Objects.equals(text, argNode.text) && Objects.equals(type, argNode.type) && Objects.equals(timestamp, argNode.timestamp) && Objects.equals(scheme, argNode.scheme) && Objects.equals(schemeID, argNode.schemeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeID, text, type, timestamp, scheme, schemeID);
    }
}
