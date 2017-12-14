package aoc.day14;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day14Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day14("flqrgnkx").part1(), Matchers.is(8108L));
        MatcherAssert.assertThat(new Day14().part1(), Matchers.is(8204L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day14("flqrgnkx").part2(), Matchers.is(1242L));
        MatcherAssert.assertThat(new Day14().part2(), Matchers.is(1089L));
    }

}
