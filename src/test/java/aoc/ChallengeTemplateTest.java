package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class ChallengeTemplateTest {

    @Test
    public void test() {
        MatcherAssert.assertThat(new ChallengeTemplate("1").run(), Matchers.is(0L));
    }

}
