package aoc.day06;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day06Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day06Part1(0, 2, 7, 0).run(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day06Part1().run(), Matchers.is(6681L));
    }

}
