package aoc.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day09Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day09Part1("{}").run(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09Part1("{{{}}}").run(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day09Part1("{{},{}}").run(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day09Part1("{{{},{},{{}}}}").run(), Matchers.is(16L));
        MatcherAssert.assertThat(new Day09Part1("{<a>,<a>,<a>,<a>}").run(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09Part1("{{<ab>},{<ab>},{<ab>},{<ab>}}").run(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09Part1("{{<!!>},{<!!>},{<!!>},{<!!>}}").run(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09Part1("{{<a!>},{<a!>},{<a!>},{<ab>}}").run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day09Part1().run(), Matchers.is(13154L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day09Part2("<>").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09Part2("<random characters>").run(), Matchers.is(17L));
        MatcherAssert.assertThat(new Day09Part2("<<<<>").run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day09Part2("<{!>}>").run(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day09Part2("<!!>").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09Part2("<!!!>>").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09Part2("<{o\"i!a,<{i<a>").run(), Matchers.is(10L));
        MatcherAssert.assertThat(new Day09Part2().run(), Matchers.is(6369L));
    }

}
