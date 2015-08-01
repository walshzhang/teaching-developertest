package walsh.teaching.junit.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Logger implements TestRule {
    private File logFile;

    public Logger(File file) {
        logFile = file;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    before(description);
                    base.evaluate();
                    succeeded(description);
                } catch (Throwable e) {
                    //currently, here is unreachable because the test method
                    //was executed in another thread, so we cannot catch any
                    //exception from that thread.
                    failed(description, e);
                }
            }
        };
    }

    private void before(Description description) {
        log("Starting Test: " + description.getDisplayName());
    }

    private void succeeded(Description description) {
        log("Succeeded Test: " + description.getDisplayName());
    }

    private void failed(Description description, Throwable e) {
        log("Failed Test: " + description.getDisplayName() + "\n\t Message: " + e.getMessage());
    }

    private void log(String message) {
        try (Writer writer = new FileWriter(logFile, true)) {
            writer.write(message);
            writer.write("\n");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
