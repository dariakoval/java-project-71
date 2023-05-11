package hexlet.code.formatters;

import java.util.Map;

public class Plain {
    public static String genPlain(Map<String, Object> map1, Map<String, Object> map2, Map<String, String> mapDiff) {
        StringBuilder result = new StringBuilder();
        for (String key: mapDiff.keySet()) {
            if (mapDiff.get(key).equals("added")) {
                result.append("\nProperty '").append(key).append("' was added with value: ").
                        append(toSpecialString(map2.get(key)));
            } else if (mapDiff.get(key).equals("deleted")) {
                result.append("\nProperty '").append(key).append("' was removed");
            } else if (mapDiff.get(key).equals("changed")) {
                result.append("\nProperty '").append(key).append("' was updated. From ").
                        append(toSpecialString(map1.get(key))).append(" to ").
                        append(toSpecialString(map2.get(key)));
            }
        }
        return result.delete(0, 1).toString();
    }
    public static String toSpecialString(Object obj) {
        String result;
        if (obj instanceof Map<?, ?>) {
            result = "[complex value]";
        } else if (obj instanceof String) {
            result = "'" + obj + "'";
        } else if (obj instanceof Integer) {
            result = obj.toString();
        } else if (obj == null) {
            result = null;
        } else if (obj instanceof Boolean) {
            result = obj.toString();
        } else {
            result = "[complex value]";
        }
        return result;
    }
}
