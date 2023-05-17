package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String genStylish(Map<String, Map<String, Object>> mapDiff) {
        StringBuilder result = new StringBuilder("{\n");

        for (String key: mapDiff.keySet()) {
            Map<String, Object> map = mapDiff.get(key);

            if (map.get("status").equals("added")) {
                result.append("  + ").append(key).append(": ").append(map.get("value2")).append("\n");
            } else if (map.get("status").equals("deleted")) {
                result.append("  - ").append(key).append(": ").append(map.get("value1")).append("\n");
            } else if (map.get("status").equals("unchanged")) {
                result.append("    ").append(key).append(": ").append(map.get("value1")).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(map.get("value1")).append("\n");
                result.append("  + ").append(key).append(": ").append(map.get("value2")).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}
