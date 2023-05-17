package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String selectFormatter(Map<String, Map<String, Object>> mapDiff, String format)
            throws JsonProcessingException {
        return switch (format) {
            case "plain" -> Plain.genPlain(mapDiff);
            case "json" -> Json.genJson(mapDiff);
            case  "stylish" -> Stylish.genStylish(mapDiff);
            default -> throw new RuntimeException("Invalid format: " + format);
        };
    }
}
