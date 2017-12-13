package aoc.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day09Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day09("{}").part1(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09("{{{}}}").part1(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day09("{{},{}}").part1(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day09("{{{},{},{{}}}}").part1(), Matchers.is(16L));
        MatcherAssert.assertThat(new Day09("{<a>,<a>,<a>,<a>}").part1(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09("{{<ab>},{<ab>},{<ab>},{<ab>}}").part1(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09("{{<!!>},{<!!>},{<!!>},{<!!>}}").part1(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09("{{<a!>},{<a!>},{<a!>},{<ab>}}").part1(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day09().part1(), Matchers.is(13154L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day09("<>").part2(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09("<random characters>").part2(), Matchers.is(17L));
        MatcherAssert.assertThat(new Day09("<<<<>").part2(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day09("<{!>}>").part2(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day09("<!!>").part2(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09("<!!!>>").part2(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day09("<{o\"i!a,<{i<a>").part2(), Matchers.is(10L));
        MatcherAssert.assertThat(new Day09().part2(), Matchers.is(6369L));
    }

}
