package aoc.day03;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day03Part1FastTest {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day03Part1Fast(1L).run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day03Part1Fast(12L).run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day03Part1Fast(23L).run(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day03Part1Fast(1024L).run(), Matchers.is(31L));
    }

}
