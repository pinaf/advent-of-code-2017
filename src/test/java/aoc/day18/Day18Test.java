package aoc.day18;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day18Test {

    private final String input =
        "set a 1\n" +
        "add a 2\n" +
        "mul a a\n" +
        "mod a 5\n" +
        "snd a\n" +
        "set a 0\n" +
        "rcv a\n" +
        "jgz a -1\n" +
        "set a 1\n" +
        "jgz a -2";

    private final String input2 =
        "snd 1\n" +
        "snd 2\n" +
        "snd p\n" +
        "rcv a\n" +
        "rcv b\n" +
        "rcv c\n" +
        "rcv d";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day18(this.input).part1(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day18().part1(), Matchers.is(3423L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day18(this.input2).part2(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day18().part2(), Matchers.is(7493L));
    }

}
