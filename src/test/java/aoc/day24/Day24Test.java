package aoc.day24;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day24Test {

    private final String input =
        "0/2\n" +
        "2/2\n" +
        "2/3\n" +
        "3/4\n" +
        "3/5\n" +
        "0/1\n" +
        "10/1\n" +
        "9/10";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day24(this.input).part1(), Matchers.is(31L));
        MatcherAssert.assertThat(new Day24().part1(), Matchers.is(1940L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day24(this.input).part2(), Matchers.is(19L));
        MatcherAssert.assertThat(new Day24().part2(), Matchers.is(1928L));
    }

}
