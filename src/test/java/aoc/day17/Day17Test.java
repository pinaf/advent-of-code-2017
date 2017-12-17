package aoc.day17;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day17Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day17(3).part1(), Matchers.is(638L));
        MatcherAssert.assertThat(new Day17().part1(), Matchers.is(866L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day17().part2(), Matchers.is(11995607L));
    }

}
