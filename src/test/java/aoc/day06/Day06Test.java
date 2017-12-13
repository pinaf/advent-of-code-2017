package aoc.day06;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day06Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day06(0, 2, 7, 0).part1(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day06().part1(), Matchers.is(6681L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day06(0, 2, 7, 0).part2(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day06().part2(), Matchers.is(2392L));
    }

}
