package walsh.teaching.hamcrest.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import walsh.teaching.junit.core.Money;

public class ItsAmount extends TypeSafeMatcher<Money> {
    private final Matcher<Number> matcher;
    private final Matcher<Money> second;

    public ItsAmount(Matcher<Number> matcher) {
        this(matcher, null);
    }

    public ItsAmount(Matcher<Number> matcher, Matcher<Money> second) {
        this.matcher = matcher;
        this.second = second;
    }

    @Factory
    public static Matcher<Money> itsAmount(Matcher<Number> isMatcher) {
        return new ItsAmount(isMatcher);
    }

    @Factory
    public static Matcher<Money> itsAmount(Matcher<Number> first, Matcher<Money> second) {
        return new ItsAmount(first, second);
    }

    @Override
    protected boolean matchesSafely(Money money) {
        return matcher.matches(money.getAmount());
    }

    @Override
    public void describeTo(Description description) {
        description.appendDescriptionOf(matcher);
    }

    @Override
    protected void describeMismatchSafely(Money money, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendValue(money.getAmount());
    }
}
