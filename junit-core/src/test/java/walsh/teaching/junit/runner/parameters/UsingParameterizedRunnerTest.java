package walsh.teaching.junit.runner.parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UsingParameterizedRunnerTest {
    //    @Parameter
    private int input;
    //    @Parameter(1)
    private int expected;

    //    we can use following constructor instead of above Parameter annotation.
    public UsingParameterizedRunnerTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters(name = "{index}:fact({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}
        });
    }

    @Test
    public void testFibonacci() {
        assertThat(fibonacci(input), is(expected));
    }

    private int fibonacci(int number) {
        //ignored guard clause to check number le 0.
        if (number == 1) {
            return 1;
        }
        return number * fibonacci(number - 1);
    }

}
