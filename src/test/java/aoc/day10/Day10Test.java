package aoc.day10;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day10Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day10(5, new int[] {3, 4, 1, 5}).run(), Matchers.is(12L));
        MatcherAssert.assertThat(new Day10().run(), Matchers.is(3770L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day10Part2("").run(), Matchers.is("a2582a3a0e66e6e86e3812dcb672a272"));
        MatcherAssert.assertThat(new Day10Part2("AoC 2017").run(), Matchers.is("33efeb34ea91902bb2f59c9920caa6cd"));
        MatcherAssert.assertThat(new Day10Part2("1,2,3").run(), Matchers.is("3efbe78a8d82f29979031a4aa0b16a9d"));
        MatcherAssert.assertThat(new Day10Part2("1,2,4").run(), Matchers.is("63960835bcdc130f0b66d7ff4f6a5a8e"));
        MatcherAssert.assertThat(new Day10Part2().run(), Matchers.is("a9d0e68649d0174c8756a59ba21d4dc6"));
    }

}
