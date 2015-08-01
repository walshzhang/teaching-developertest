package walsh.teaching.junit.rule;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FilesTest {
    @ClassRule
    public static Logger logger = new Logger(new File("logger"));
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testCopy() throws IOException {
        File from = folder.newFile();
        File to = folder.newFile();

        Files.write(from, "Hello World!");

        Files.copy(from, to);

        assertThat(Files.read(to), equalTo("Hello World!"));
    }

    @Ignore
    @Test
    public void testFailed() {
        throw new RuntimeException("Failed");
//        fail();
    }

}
