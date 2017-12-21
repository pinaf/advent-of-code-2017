package aoc.day21;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day21Test {

    private final String input =
        "../.# => ##./#../...\n" +
        ".#./..#/### => #..#/..../..../#..#";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day21(2, this.input).part1(), Matchers.is(12L));
        MatcherAssert.assertThat(new Day21(5).part1(), Matchers.is(155L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day21(18).part2(), Matchers.is(2449665L));
    }

}
