package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DailyChallengeTemplateTest {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new DailyChallengeTemplate("1").part1(), Matchers.is(0L));
        //MatcherAssert.assertThat(new DailyChallengeTemplate().part1(), Matchers.is(0L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new DailyChallengeTemplate("1").part2(), Matchers.is(0L));
        //MatcherAssert.assertThat(new DailyChallengeTemplate().part2(), Matchers.is(0L));
    }

}
