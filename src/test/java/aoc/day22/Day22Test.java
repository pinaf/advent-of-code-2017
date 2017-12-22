package aoc.day22;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day22Test {

    private final String input =
        "..#\n" +
        "#..\n" +
        "...";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day22(this.input).part1(), Matchers.is(5587L));
        MatcherAssert.assertThat(new Day22().part1(), Matchers.is(5223L));
    }

    @Test
    public void part2() {
        //MatcherAssert.assertThat(new Day22(this.input).part2(), Matchers.is(26L));
        MatcherAssert.assertThat(new Day22().part2(), Matchers.is(2511456L));
    }

}
