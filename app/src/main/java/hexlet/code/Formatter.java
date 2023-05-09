package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String selectFormatter(Map<String, Object> map1, Map<String, Object> map2, Map<String,
            String> mapDiff, String format) {
        return switch (format) {
            case "plain" -> Plain.genPlain(map1, map2, mapDiff);
            default -> Stylish.genStylish(map1, map2, mapDiff);
        };
    }

}
