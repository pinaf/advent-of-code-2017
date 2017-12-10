package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class ChallengeTemplateTest {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new ChallengeTemplate("1").run(), Matchers.is(0L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new ChallengeTemplate("1").run(), Matchers.is(0L));
    }

}
