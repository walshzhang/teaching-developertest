package walsh.teaching.junit.runner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@LogToFileRunner.LogFile("logger")
@RunWith(LogToFileRunner.class)
public class UsingLogToFileRunnerTest {
    @Test
    public void test() {
        assertTrue(true);
    }

    //to ensure pass the test in the ci build, we ignored this test.
    //but you should uncomment @Ignore annotation to
    // test whether the runner really logged the fail test in the log file.
    @Ignore
    @Test
    public void failedTest() {
        fail("Failed Test");
    }
}
