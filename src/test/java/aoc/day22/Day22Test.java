package aoc.day22;

import aoc.DailyChallengeTemplate;
import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day22Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day22("1").part1(), Matchers.is(0L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day22("1").part2(), Matchers.is(0L));
    }

}
