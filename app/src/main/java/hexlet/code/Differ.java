package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> map1 = getData(filePath1);
        Map<String, Object> map2 = getData(filePath2);
        Map<String, Map<String, Object>> mapDiff = DifferenceCalculator.genDiff(map1, map2);

        return Formatter.selectFormatter(mapDiff, format);
    }

    public static Map<String, Object> getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String content = Files.readString(path).trim();
        String dataFormat = FilenameUtils.getExtension(filePath);

        return Parser.parse(content, dataFormat);
    }
}
