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
        MatcherAssert.assertThat(new Day12Part1(Day12Test.INPUT).run(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day12Part1().run(), Matchers.is(152L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day12Part2(Day12Test.INPUT).run(), Matchers.is(2L));
        MatcherAssert.assertThat(new Day12Part2().run(), Matchers.is(186L));
    }

}
