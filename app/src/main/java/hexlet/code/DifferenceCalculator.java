package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferenceCalculator {
    public static Map<String, Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Map<String, Object>> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key: keys) {
            Map<String, Object> element = new LinkedHashMap<>();
            if (!map1.containsKey(key)) {
                element.put("status", "added");
                element.put("value2", map2.get(key));
                result.put(key, element);
            } else if (!map2.containsKey(key)) {
                element.put("status", "deleted");
                element.put("value1", map1.get(key));
                result.put(key, element);
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                element.put("status", "unchanged");
                element.put("value1", map1.get(key));
                result.put(key, element);
            } else {
                element.put("status", "changed");
                element.put("value1", map1.get(key));
                element.put("value2", map2.get(key));
                result.put(key, element);
            }
        }
        return result;
    }
}
