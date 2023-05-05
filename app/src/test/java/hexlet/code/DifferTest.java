package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    @Test
    void testGenerate1() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expected);
    }
    @Test
    void testGenerate2() throws Exception {
        String filePath1 = "src/test/resources/file11.yml";
        String filePath2 = "src/test/resources/file12.yml";
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expected);
    }
}
