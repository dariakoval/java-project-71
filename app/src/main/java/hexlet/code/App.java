package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer>  {
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Option(names = { "-f", "--format" },
            defaultValue = "stylish",
            paramLabel = "format",
            description = "output format: stylish, plain, json [default: ${DEFAULT-VALUE}]")
    private String formatName;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public Integer call() {

        try {
            String formattedDiff = Differ.generate(filePath1, filePath2, formatName);
            System.out.println(formattedDiff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }

        return SUCCESS_EXIT_CODE;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
