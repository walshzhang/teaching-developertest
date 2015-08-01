package walsh.teaching.junit.theory;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class UsingTheoriesTest {

    @Theory
    public void testDivision(@BetweenSupplier.Between(first = -100, last = 100) int numerator,
                             @BetweenSupplier.Between(first = -100, last = 100) int denominator) {
        assumeThat(denominator, not(0));
        assertThat(multiple(divide(numerator, denominator), denominator), closeTo(numerator * 1.0, 0.00001));
    }

    private double divide(double numerator, double denominator) {
        //ignored guard clause to check whether denominator be zero or not.
        return numerator / denominator;
    }

    private double multiple(double multiplicand, double multiplier) {
        return multiplicand * multiplier;
    }
}
