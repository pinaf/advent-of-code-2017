package aoc.day04;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day04Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(
            new Day04("aa bb cc dd ee").part1(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04("aa bb cc dd aa").part1(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(
            new Day04("aa bb cc dd aaa").part1(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04(
                "aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa\n"
            ).part1(),
            Matchers.is(2L)
        );
        MatcherAssert.assertThat(new Day04().part1(), Matchers.is(455L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(
            new Day04("abcde fghij").part2(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04("abcde xyz ecdab").part2(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(
            new Day04("a ab abc abd abf abj").part2(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04("iiii oiii ooii oooi oooo").part2(),
            Matchers.is(1L)
        );
        MatcherAssert.assertThat(
            new Day04("oiii ioii iioi iiio").part2(),
            Matchers.is(0L)
        );
        MatcherAssert.assertThat(new Day04().part2(), Matchers.is(186L));
    }

}
