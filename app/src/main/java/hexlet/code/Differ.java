package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        String data1 = getData(filePath1);
        String data2 = getData(filePath2);

        Map<String, Object> map1 = getMap(data1);
        Map<String, Object> map2 = getMap(data2);
        Map<String, String> mapDiff = genDiff(map1, map2);

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
    public static String getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }
    public static Map<String, Object> getMap(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<>() {
        });
    }

    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key: keys) {

            if (!map1.containsKey(key)) {
                result.put(key, "added");
            } else if (!map2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (map1.get(key).equals(map2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }

        return result;
    }
}
