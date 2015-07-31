package walsh.teaching.junit.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency() { //program also is documentation
        Money tenDollar = new Money(10, "USD");
        assertEquals(10, tenDollar.getAmount(), 0);
        assertEquals("USD", tenDollar.getCurrency());
    }

    @Test
    public void sameAmountAndCurrencyShouldBeEqual() {
        Money oneDollar = new Money(1, "USD");
        Money anotherOneDollar = new Money(1, "USD");
        assertEquals(oneDollar, anotherOneDollar);
    }

    @Test
    public void differentAmountShouldNotBeEqual() {
        Money oneDollar = new Money(1, "USD");
        Money tenDollar = new Money(10, "USD");
        Money oneRmb = new Money(1, "RMB");
        Money tenRmb = new Money(10, "RMB");

        assertThat(oneDollar, not(equalTo(tenDollar)));
        assertThat(oneDollar, not(equalTo(tenRmb)));
        assertNotEquals(oneRmb, tenDollar);
    }

    @Test
    public void differentCurrencyShouldNotBeEqual() {
        Money oneDollar = new Money(1, "USD");
        Money tenDollar = new Money(10, "USD");
        Money oneRmb = new Money(1, "RMB");
        Money tenRmb = new Money(10, "RMB");

        assertThat(oneDollar, not(equalTo(oneRmb)));
        assertNotEquals(tenDollar, tenRmb);
    }

    @Test(expected = IllegalArgumentException.class)
    public void amountCannotBeNegative() {
        Money invalidMoney = new Money(-1, "USD");
    }
}
