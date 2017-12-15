package aoc.day15;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day15Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day15(65L, 8921L).part1(), Matchers.is(588L));
        MatcherAssert.assertThat(new Day15().part1(), Matchers.is(612L));
        MatcherAssert.assertThat(new Day15Fast(65L, 8921L).part1(), Matchers.is(588L));
        MatcherAssert.assertThat(new Day15Fast().part1(), Matchers.is(612L));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day15(65L, 8921L).part2(), Matchers.is(309L));
        MatcherAssert.assertThat(new Day15().part2(), Matchers.is(285L));
        MatcherAssert.assertThat(new Day15Fast(65L, 8921L).part2(), Matchers.is(309L));
        MatcherAssert.assertThat(new Day15Fast().part2(), Matchers.is(285L));
    }

}
