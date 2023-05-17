package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();

        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(resultStylish);

        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(resultStylish);

        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(resultPlain);

        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(resultJson);
    }

    @Test
    public void testInvalidFormat() {
        String filePath1 = "src/test/resources/fixtures/file1.json";
        String filePath2 = "src/test/resources/fixtures/file2.json";
        var thrown = catchThrowable(() -> Differ.generate(filePath1, filePath2, "yaml"));
        assertThat(thrown).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void testParser() {
        String filePath1 = "src/test/resources/fixtures/file1.txt";
        String filePath2 = "src/test/resources/fixtures/file2.txt";
        var thrown = catchThrowable(() -> Differ.generate(filePath1, filePath2, "yaml"));
        assertThat(thrown).isInstanceOf(Exception.class);
    }

    @Test
    public void testIncorrectPath() {
        String filePath1 = "src/test/fixtures/file1.json";
        String filePath2 = "src/test/fixtures/file2.json";
        var thrown = catchThrowable(() -> Differ.generate(filePath1, filePath2, "json"));
        assertThat(thrown).isInstanceOf(Exception.class);
    }
}
