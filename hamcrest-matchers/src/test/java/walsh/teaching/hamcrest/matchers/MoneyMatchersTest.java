package walsh.teaching.hamcrest.matchers;

import org.junit.Test;
import walsh.teaching.junit.core.Money;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static walsh.teaching.hamcrest.matchers.MoneyMatchers.*;

public class MoneyMatchersTest {
    @Test
    public void testAmountMatchers() {
        Money oneDollar = new Money(1, "USD");
        assertThat(oneDollar, itsAmount(is(1f), and(itsCurrency(is("USD")))));
        assertThat(oneDollar, itsAmount(is(1f)));
    }

    @Test
    public void testCurrencyMatchers() {
        Money oneDollar = new Money(1, "USD");
        assertThat(oneDollar, itsCurrency(is("USD")));
        assertThat(oneDollar, itsCurrency(is("USD"), and(itsAmount(is(1f)))));
    }
}
