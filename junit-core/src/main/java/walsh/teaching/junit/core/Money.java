package walsh.teaching.junit.core;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Money {
    private final float amount;
    private final String currency;

    public Money(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount should be positive, but is " + amount);
        }
        this.amount = amount;
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money that = (Money) anObject;
            return Objects.equals(this.amount, that.amount)
                    && Objects.equals(this.currency, that.currency);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("amount", amount)
                .add("currency", currency).toString();
    }
}
