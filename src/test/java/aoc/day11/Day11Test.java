package aoc.day11;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day11Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day11("ne,ne,ne").part1(), Matchers.is(3));
        MatcherAssert.assertThat(new Day11("ne,ne,sw,sw").part1(), Matchers.is(0));
        MatcherAssert.assertThat(new Day11("ne,ne,s,s").part1(), Matchers.is(2));
        MatcherAssert.assertThat(new Day11("se,sw,se,sw,sw").part1(), Matchers.is(3));
        MatcherAssert.assertThat(new Day11("n,n,nw").part1(), Matchers.is(3));
        MatcherAssert.assertThat(new Day11().part1(), Matchers.is(675));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day11().part2(), Matchers.is(1424));
    }

}
