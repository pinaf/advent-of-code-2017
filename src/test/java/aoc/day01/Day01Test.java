package aoc.day01;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day01Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day01("1122").part1(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day01("1111").part1(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01("1234").part1(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01("91212129").part1(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day01().part1(), Matchers.is(1136L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day01("1212").part2(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day01("1221").part2(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01("123425").part2(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01("123123").part2(), Matchers.is(12L));
        MatcherAssert.assertThat(new Day01("12131415").part2(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01().part2(), Matchers.is(1092L));
    }

}
