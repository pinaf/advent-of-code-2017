package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day01Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day01("1122", new Day01.NeighborStrategy.Next()).run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day01("1111", new Day01.NeighborStrategy.Next()).run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01("1234", new Day01.NeighborStrategy.Next()).run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01("91212129", new Day01.NeighborStrategy.Next()).run(), Matchers.is(9L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day01("1212", new Day01.NeighborStrategy.HalfAround()).run(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day01("1221", new Day01.NeighborStrategy.HalfAround()).run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01("123425", new Day01.NeighborStrategy.HalfAround()).run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01("123123", new Day01.NeighborStrategy.HalfAround()).run(), Matchers.is(12L));
        MatcherAssert.assertThat(new Day01("12131415", new Day01.NeighborStrategy.HalfAround()).run(), Matchers.is(4L));
    }

}
