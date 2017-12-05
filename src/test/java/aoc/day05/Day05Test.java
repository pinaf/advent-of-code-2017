package aoc.day05;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day05Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(
            new Day05Part1(new int[] {0, 3, 0, 1, -3}).run(),
            Matchers.is(5L)
        );
        MatcherAssert.assertThat(
            new Day05Part1("0 3 0 1 -3").run(),
            Matchers.is(5L)
        );
        MatcherAssert.assertThat(
            new Day05Part1("0\n3\n0\n1\n-3").run(),
            Matchers.is(5L)
        );
        MatcherAssert.assertThat(new Day05Part1().run(), Matchers.is(387096L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(
            new Day05Part2("0 3 0 1 -3").run(),
            Matchers.is(10L)
        );
        MatcherAssert.assertThat(new Day05Part2().run(), Matchers.is(28040648L));
    }

}
