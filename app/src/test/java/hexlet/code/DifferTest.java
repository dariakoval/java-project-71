package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }
    @Test
    void testGenerate1() throws Exception {
        String filePath1 = "src/test/resources/file10.json";
        String filePath2 = "src/test/resources/file20.json";
        String expected = resultStylish;
        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(expected);
    }
    @Test
    void testGenerate2() throws Exception {
        String filePath1 = "src/test/resources/file10.yml";
        String filePath2 = "src/test/resources/file20.yml";
        String expected = resultStylish;
        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(expected);
    }
    @Test
    void testGenerate3() throws Exception {
        String filePath1 = "src/test/resources/file10.json";
        String filePath2 = "src/test/resources/file20.json";
        String expected = resultPlain;
        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expected);
    }
    @Test
    void testGenerate4() throws Exception {
        String filePath1 = "src/test/resources/file10.yml";
        String filePath2 = "src/test/resources/file20.yml";
        String expected = resultPlain;
        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expected);
    }
    @Test
    void testGenerate5() throws Exception {
        String filePath1 = "src/test/resources/file10.json";
        String filePath2 = "src/test/resources/file20.json";
        String expected = resultJson;
        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expected);
    }
    @Test
    void testGenerate6() throws Exception {
        String filePath1 = "src/test/resources/file10.yml";
        String filePath2 = "src/test/resources/file20.yml";
        String expected = resultJson;
        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expected);
    }
    @Test
    void testGenerate7() throws Exception {
        String filePath1 = "src/test/resources/file10.json";
        String filePath2 = "src/test/resources/file20.json";
        String expected = resultStylish;
        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expected);
    }
    @Test
    void testGenerate8() throws Exception {
        String filePath1 = "src/test/resources/file10.yml";
        String filePath2 = "src/test/resources/file20.yml";
        String expected = resultStylish;
        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expected);
    }
}
