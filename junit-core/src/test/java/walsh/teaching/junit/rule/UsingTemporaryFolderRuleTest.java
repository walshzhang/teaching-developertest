package walsh.teaching.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UsingTemporaryFolderRuleTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File file;

    @Test
    public void testFileExist() throws IOException {
        System.out.println("...");
        File file = folder.newFile();
        assertTrue(file.exists());

        file = folder.newFile("hello");
        assertThat(file.getName(), equalTo("hello"));
    }


}
