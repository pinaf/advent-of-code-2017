package aoc.day23;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day23Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day23().part1(), Matchers.is(8281L));
        MatcherAssert.assertThat(new Day23Alt().part1(), Matchers.is(1L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day23().part2(), Matchers.is(911L));
        MatcherAssert.assertThat(new Day23Alt().part2(), Matchers.is(911L));
    }

}
