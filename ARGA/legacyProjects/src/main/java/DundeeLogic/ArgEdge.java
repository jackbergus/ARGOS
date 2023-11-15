package DundeeLogic;

import java.util.Objects;

public class ArgEdge {
    public String edgeID;
    public String fromID;
    public String toID;
    public String formEdgeID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgEdge argEdge = (ArgEdge) o;
        return Objects.equals(edgeID, argEdge.edgeID) && Objects.equals(fromID, argEdge.fromID) && Objects.equals(toID, argEdge.toID) && Objects.equals(formEdgeID, argEdge.formEdgeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeID, fromID, toID, formEdgeID);
    }
}
