package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String genJson(Map<String, Object> map1, Map<String, Object> map2, Map<String, String> mapDiff)
            throws JsonProcessingException {
        Map<String, Object> result = new LinkedHashMap<>();
        for (String kye: mapDiff.keySet()) {
            Map<String, Object> element = new LinkedHashMap<>();
            if (mapDiff.get(kye).equals("added")) {
                element.put("status", "added");
                element.put("value2", map2.get(kye));
            } else if (mapDiff.get(kye).equals("deleted")) {
                element.put("status", "deleted");
                element.put("value1: ", map1.get(kye));
            } else if (mapDiff.get(kye).equals("unchanged")) {
                element.put("status", "unchanged");
                element.put("value1", map1.get(kye));
            } else {
                element.put("status", "changed");
                element.put("value1", map1.get(kye));
                element.put("value2", map2.get(kye));
            }
            result.put("key: " + kye, element);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}
