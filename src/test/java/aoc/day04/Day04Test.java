package aoc.day04;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day04Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(
            new Day04Part1("aa bb cc dd ee").run(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04Part1("aa bb cc dd aa").run(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(
            new Day04Part1("aa bb cc dd aaa").run(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04Part1(
                "aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa\n"
            ).run(),
            Matchers.is(2L)
        );
        MatcherAssert.assertThat(new Day04Part1().run(), Matchers.is(455L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(
            new Day04Part2("abcde fghij").run(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04Part2("abcde xyz ecdab").run(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(
            new Day04Part2("a ab abc abd abf abj").run(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04Part2("iiii oiii ooii oooi oooo").run(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04Part2("oiii ioii iioi iiio").run(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(new Day04Part2().run(), Matchers.is(186L));
    }

}
