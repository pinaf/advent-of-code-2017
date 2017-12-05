package aoc.day01;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day01Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day01Part1("1122").run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day01Part1("1111").run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01Part1("1234").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01Part1("91212129").run(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day01Part1().run(), Matchers.is(1136L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day01Part2("1212").run(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day01Part2("1221").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01Part2("123425").run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01Part2("123123").run(), Matchers.is(12L));
        MatcherAssert.assertThat(new Day01Part2("12131415").run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01Part2().run(), Matchers.is(1092L));
    }

}
