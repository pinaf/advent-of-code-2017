package aoc.day04;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day04Part1Test {

    @Test
    public void tests() {
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
                "aa bb cc dd ee",
                "aa bb cc dd aa",
                "aa bb cc dd aaa"
            ).run(),
            Matchers.is(2L)
        );
    }

}
