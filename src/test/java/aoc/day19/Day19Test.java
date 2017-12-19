package aoc.day19;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day19Test {

    private final String input =
        "     |          \n" +
        "     |  +--+    \n" +
        "     A  |  C    \n" +
        " F---|----E|--+ \n" +
        "     |  |  |  D \n" +
        "     +B-+  +--+ \n";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day19(this.input).part1(), Matchers.is("ABCDEF"));
        MatcherAssert.assertThat(new Day19().part1(), Matchers.is("VEBTPXCHLI"));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day19(this.input).part2(), Matchers.is(38L));
        MatcherAssert.assertThat(new Day19().part2(), Matchers.is(18702L));
    }

}
