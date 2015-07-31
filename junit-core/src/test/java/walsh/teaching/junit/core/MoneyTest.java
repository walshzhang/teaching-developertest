package walsh.teaching.junit.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MoneyTest {
    private Money oneDollar = null;
    private Money tenDollar = null;
    private Money oneRmb = null;
    private Money tenRmb = null;

    @Before
    public void setUp() {
        oneDollar = new Money(1, "USD");
        tenDollar = new Money(10, "USD");
        oneRmb = new Money(1, "RMB");
        tenRmb = new Money(10, "RMB");
    }

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        assertEquals(10, tenDollar.getAmount(), 0);
        assertEquals("USD", tenDollar.getCurrency());
    }

    @Test
    public void sameAmountAndCurrencyShouldBeEqual() {
        Money anotherOneDollar = new Money(1, "USD");
        assertEquals(oneDollar, anotherOneDollar);
    }

    @Test
    public void differentAmountShouldNotBeEqual() {
        assertThat(oneDollar, not(equalTo(tenDollar)));
        assertThat(oneDollar, not(equalTo(tenRmb)));
        assertNotEquals(oneRmb, tenDollar);
    }

    @Test
    public void differentCurrencyShouldNotBeEqual() {
        assertThat(oneDollar, not(equalTo(oneRmb)));
        assertNotEquals(tenDollar, tenRmb);
        assertThat(oneDollar, not(equalTo(tenRmb)));
    }

    @Test
    public void amountCannotBeNegative() {
        try {
            Money invalidMoney = new Money(-1, "USD");
            fail();
        } catch (IllegalArgumentException e) {
            //expected exception. no need handle it.
        }
    }
}
