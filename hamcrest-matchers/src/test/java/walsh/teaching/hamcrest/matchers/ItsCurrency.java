package walsh.teaching.hamcrest.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import walsh.teaching.junit.core.Money;

public class ItsCurrency extends TypeSafeMatcher<Money> {
    private final Matcher<String> matcher;
    private final Matcher<Money> second;

    public ItsCurrency(Matcher<String> matcher) {
        this(matcher, null);
    }

    public ItsCurrency(Matcher<String> matcher, Matcher<Money> second) {
        this.matcher = matcher;
        this.second = second;
    }

    @Factory
    public static Matcher<Money> itsCurrency(Matcher<String> matcher) {
        return new ItsCurrency(matcher);
    }

    @Factory
    public static Matcher<Money> itsCurrency(Matcher<String> matcher, Matcher<Money> second) {
        return new ItsCurrency(matcher, second);
    }

    @Override
    protected boolean matchesSafely(Money money) {
        return matcher.matches(money.getCurrency());
    }

    @Override
    public void describeTo(Description description) {
        description.appendDescriptionOf(matcher);
    }

    @Override
    protected void describeMismatchSafely(Money money, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendText(money.getCurrency());
    }
}
