package aoc.day13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day13Test {

    private final String input = "0: 3\n" +
        "1: 2\n" +
        "4: 4\n" +
        "6: 4";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day13(this.input).run(), Matchers.is(24L));
        // 480
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day13(this.input).run(), Matchers.is(10L));
        //3870382
    }

}
