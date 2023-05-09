package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String genStylish(Map<String, Object> map1, Map<String, Object> map2, Map<String, String> mapDiff) {
        StringBuilder result = new StringBuilder("{\n");
        for (String key: mapDiff.keySet()) {
            if (mapDiff.get(key).equals("added")) {
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (mapDiff.get(key).equals("deleted")) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (mapDiff.get(key).equals("unchanged")) {
                result.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
