package aoc.day02;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day02Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(
            new Day02Part1(
                "5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8"
            ).run(),
            Matchers.is(18L)
        );
        MatcherAssert.assertThat(new Day02Part1().run(), Matchers.is(42299L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(
            new Day02Part2(
                "5 9 2 8\n" +
                "9 4 7 3\n" +
                "3 8 6 5\n"
            ).run(),
            Matchers.is(9L)
        );
        MatcherAssert.assertThat(new Day02Part2().run(), Matchers.is(277L));
    }

}
