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
        MatcherAssert.assertThat(new Day03Part1(289326L).run(), Matchers.is(419L));
    }

}
