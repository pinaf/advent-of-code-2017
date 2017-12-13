package aoc.day12;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day12Test {

    private static final String INPUT =
        "0 <-> 2\n" +
        "1 <-> 1\n" +
        "2 <-> 0, 3, 4\n" +
        "3 <-> 2, 4\n" +
        "4 <-> 2, 3, 6\n" +
        "5 <-> 6\n" +
        "6 <-> 4, 5";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day12(Day12Test.INPUT).part1(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day12().part1(), Matchers.is(152L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day12(Day12Test.INPUT).part2(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day12().part2(), Matchers.is(186L));
    }

}
