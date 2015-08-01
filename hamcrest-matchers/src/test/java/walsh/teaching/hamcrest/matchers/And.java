package walsh.teaching.hamcrest.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import walsh.teaching.junit.core.Money;

public class And extends TypeSafeMatcher<Money> {
    private final Matcher<Money> matcher;

    public And(Matcher<Money> matcher) {
        this.matcher = matcher;
    }

    @Factory
    public static Matcher<Money> and(Matcher<Money> matcher) {
        return new And(matcher);
    }

    @Override
    protected boolean matchesSafely(Money money) {
        return this.matcher.matches(money);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("and ").appendDescriptionOf(matcher);
    }
}
