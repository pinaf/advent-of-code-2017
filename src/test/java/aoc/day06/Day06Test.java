package aoc.day06;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day06Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day06(0, 2, 7, 0).run(), Matchers.is(5L));
    }

}
