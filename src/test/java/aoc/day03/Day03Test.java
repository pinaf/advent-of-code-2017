package aoc.day03;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day03Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day03(1L).part1(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day03(12L).part1(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day03(23L).part1(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day03(1024L).part1(), Matchers.is(31L));
        MatcherAssert.assertThat(new Day03().part1(), Matchers.is(419L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day03(1L).part2(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day03(2L).part2(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day03(4L).part2(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day03(5L).part2(), Matchers.is(10L));
        MatcherAssert.assertThat(new Day03(10L).part2(), Matchers.is(11L));
        MatcherAssert.assertThat(new Day03(11L).part2(), Matchers.is(23L));
        MatcherAssert.assertThat(new Day03(23L).part2(), Matchers.is(25L));
        MatcherAssert.assertThat(new Day03(25L).part2(), Matchers.is(26L));
        MatcherAssert.assertThat(new Day03(26L).part2(), Matchers.is(54L));
        MatcherAssert.assertThat(new Day03(54L).part2(), Matchers.is(57L));
        MatcherAssert.assertThat(new Day03(57L).part2(), Matchers.is(59L));
        MatcherAssert.assertThat(new Day03(59L).part2(), Matchers.is(122L));
        MatcherAssert.assertThat(new Day03(122L).part2(), Matchers.is(133L));
        MatcherAssert.assertThat(new Day03(133L).part2(), Matchers.is(142L));
        MatcherAssert.assertThat(new Day03(142L).part2(), Matchers.is(147L));
        MatcherAssert.assertThat(new Day03(147L).part2(), Matchers.is(304L));
        MatcherAssert.assertThat(new Day03(304L).part2(), Matchers.is(330L));
        MatcherAssert.assertThat(new Day03(330L).part2(), Matchers.is(351L));
        MatcherAssert.assertThat(new Day03(351L).part2(), Matchers.is(362L));
        MatcherAssert.assertThat(new Day03(362L).part2(), Matchers.is(747L));
        MatcherAssert.assertThat(new Day03(747L).part2(), Matchers.is(806L));
        MatcherAssert.assertThat(new Day03().part2(), Matchers.is(295229L));
    }

}
