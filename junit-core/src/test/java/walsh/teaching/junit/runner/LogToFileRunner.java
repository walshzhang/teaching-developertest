package walsh.teaching.junit.runner;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.*;

public class LogToFileRunner extends BlockJUnit4ClassRunner {

    private Writer writer = null;

    public LogToFileRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        StringBuilder builder = new StringBuilder("Starting Method: ").append(method.getName()).append("\n");
        try {
            super.runChild(method, notifier);
            builder.append("Suceeded Method: ").append(method.getName()).append("\n");
        } catch (java.lang.Throwable throwable) {
            System.out.println("failed here");
            builder.append("Failed Method: ").append(method.getName()).append("\n");
        }

        File logFile = new File(getTestClass().getAnnotation(LogFile.class).value());
        try (Writer writer = new FileWriter(logFile, true)) {
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Statement methodBlock(FrameworkMethod method) {
        return super.methodBlock(method);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface LogFile {
        String value() default "logger";
    }
}
