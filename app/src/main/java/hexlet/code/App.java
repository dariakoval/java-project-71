package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer>  {
    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    private String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file", defaultValue = "/etc/hosts")
    private File file1 = new File("/etc/hosts");
    @Parameters(paramLabel = "filepath2", description = "path to second file", defaultValue = "/etc/hosts")
    private File file2 = new File("/etc/hosts");

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() {
        return null;
    }
}
