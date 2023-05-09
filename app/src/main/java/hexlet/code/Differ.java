package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> map1 = getData(filePath1);
        Map<String, Object> map2 = getData(filePath2);
        Map<String, String> mapDiff = genDiff(map1, map2);

        return Formatter.selectFormatter(map1, map2, mapDiff, format);
    }
    public static Map<String, Object> getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String data = Files.readString(path);
        if (FilenameUtils.getExtension(filePath).equals("json")) {
            return Parser.parseJson(data);
        } else {
            return Parser.parseYaml(data);
        }
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
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }

        return result;
    }
}
