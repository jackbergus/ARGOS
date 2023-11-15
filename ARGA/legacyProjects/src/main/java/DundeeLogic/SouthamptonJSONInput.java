
package DundeeLogic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class SouthamptonJSONInput {
        public Map<String, List<String>> query;
        public ArgGraph                  graph;

        public SouthamptonJSONInput() {
            query = null;
            graph = null;
        }
        public SouthamptonJSONInput(String json) {
            this();
            SouthamptonJSONInput q = null;
            try {
                q = new ObjectMapper().readValue(json, SouthamptonJSONInput.class);
                query = q.query;
                graph = q.graph;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
    public String toString() {
            try {
                return new ObjectMapper().writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }

}