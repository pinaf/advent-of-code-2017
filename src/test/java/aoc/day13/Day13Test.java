package aoc.day13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day13Test {

    private static final String INPUT =
        "0: 3\n" +
        "1: 2\n" +
        "4: 4\n" +
        "6: 4";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day13Part1(Day13Test.INPUT).run(), Matchers.is(24L));
        MatcherAssert.assertThat(new Day13Part1().run(), Matchers.is(1300L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day13Part2(Day13Test.INPUT).run(), Matchers.is(10L));
        MatcherAssert.assertThat(new Day13Part2().run(), Matchers.is(3870382L));
    }

}
