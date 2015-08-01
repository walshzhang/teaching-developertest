package walsh.teaching.hamcrest.matchers;


import org.hamcrest.Matcher;
import walsh.teaching.junit.core.Money;

public class MoneyMatchers {
    public static Matcher<Money> itsAmount(Matcher<Number> first, Matcher<Money> second) {
        return ItsAmount.itsAmount(first, second);
    }

    public static Matcher<Money> itsAmount(Matcher<Number> matcher) {
        return ItsAmount.itsAmount(matcher);
    }

    public static Matcher<Money> itsCurrency(Matcher<String> matcher) {
        return ItsCurrency.itsCurrency(matcher);
    }

    public static Matcher<Money> and(Matcher<Money> first) {
        return And.and(first);
    }

    public static Matcher<Money> itsCurrency(Matcher<String> first, Matcher<Money> second) {
        return ItsCurrency.itsCurrency(first, second);
    }
}
