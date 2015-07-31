package walsh.teaching.junit.core;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class MoneyTest {
    @DataPoints({"USD", "MONEY"})
    public static Money[] dollars = new Money[]{new Money(1, "USD"), new Money(10, "USD")};

    @DataPoints({"RMB", "MONEY"})
    public static Money[] rmbs = new Money[]{new Money(1, "RMB"), new Money(10, "RMB")};

    @Theory
    public void constructorShouldSetAmountAndCurrency(@FromDataPoints("USD") Money money) {
        assumeThat(money.getAmount(), is(10f));
        assertEquals(10, money.getAmount(), 0);
        assertEquals("USD", money.getCurrency());
    }

    @Theory
    public void sameAmountAndCurrencyShouldBeEqual(@FromDataPoints("USD") Money adollar,
                                                   @FromDataPoints("USD") Money anotherDollar) {
        assumeThat(adollar.getAmount(), is(anotherDollar.getAmount()));
        assertEquals(adollar, anotherDollar);
    }

    @Theory
    public void differentAmountShouldNotBeEqual(@FromDataPoints("MONEY") Money money,
                                                @FromDataPoints("MONEY") Money anotherMoney) {
        assumeThat(money.getAmount(), is(not(anotherMoney.getAmount())));
        System.out.println("money : " + money + ", another: " + anotherMoney);
        assertThat(money, not(equalTo(anotherMoney)));
    }

    @Theory
    public void differentCurrencyShouldNotBeEqual(@FromDataPoints("USD") Money dollar,
                                                  @FromDataPoints("RMB") Money rmb) {
        assertThat(dollar, not(equalTo(rmb)));
    }

    @Test
    public void amountCannotBeNegative() {
        try {
            new Money(-1, "USD");
            fail();
        } catch (IllegalArgumentException e) {
            //expected exception. no need handle it.
        }
    }
}
