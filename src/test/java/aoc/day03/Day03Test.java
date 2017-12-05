package aoc.day03;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day03Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day03Part1(1L).run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day03Part1(12L).run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day03Part1(23L).run(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day03Part1(1024L).run(), Matchers.is(31L));
        MatcherAssert.assertThat(new Day03Part1().run(), Matchers.is(419L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day03Part2(1L).run(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day03Part2(2L).run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day03Part2(4L).run(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day03Part2(5L).run(), Matchers.is(10L));
        MatcherAssert.assertThat(new Day03Part2(10L).run(), Matchers.is(11L));
        MatcherAssert.assertThat(new Day03Part2(11L).run(), Matchers.is(23L));
        MatcherAssert.assertThat(new Day03Part2(23L).run(), Matchers.is(25L));
        MatcherAssert.assertThat(new Day03Part2(25L).run(), Matchers.is(26L));
        MatcherAssert.assertThat(new Day03Part2(26L).run(), Matchers.is(54L));
        MatcherAssert.assertThat(new Day03Part2(54L).run(), Matchers.is(57L));
        MatcherAssert.assertThat(new Day03Part2(57L).run(), Matchers.is(59L));
        MatcherAssert.assertThat(new Day03Part2(59L).run(), Matchers.is(122L));
        MatcherAssert.assertThat(new Day03Part2(122L).run(), Matchers.is(133L));
        MatcherAssert.assertThat(new Day03Part2(133L).run(), Matchers.is(142L));
        MatcherAssert.assertThat(new Day03Part2(142L).run(), Matchers.is(147L));
        MatcherAssert.assertThat(new Day03Part2(147L).run(), Matchers.is(304L));
        MatcherAssert.assertThat(new Day03Part2(304L).run(), Matchers.is(330L));
        MatcherAssert.assertThat(new Day03Part2(330L).run(), Matchers.is(351L));
        MatcherAssert.assertThat(new Day03Part2(351L).run(), Matchers.is(362L));
        MatcherAssert.assertThat(new Day03Part2(362L).run(), Matchers.is(747L));
        MatcherAssert.assertThat(new Day03Part2(747L).run(), Matchers.is(806L));
        MatcherAssert.assertThat(new Day03Part2().run(), Matchers.is(295229L));
    }

}
