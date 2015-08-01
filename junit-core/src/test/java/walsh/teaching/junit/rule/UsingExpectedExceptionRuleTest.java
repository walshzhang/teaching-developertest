package walsh.teaching.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

public class UsingExpectedExceptionRuleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() {
        List<Object> list = new ArrayList<>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        thrown.expectMessage(containsString("Size: 0")); //use hamcrest-style matcher to match exception message
        list.get(0);
    }
}
