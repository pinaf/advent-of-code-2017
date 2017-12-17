package aoc.day16;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day16Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day16(ProgramSequenceInts::new, 5, "s1,x3/4,pe/b").part1(), Matchers.is("baedc"));
        MatcherAssert.assertThat(new Day16(ProgramSequenceInts::new).part1(), Matchers.is("kbednhopmfcjilag"));
        MatcherAssert.assertThat(new Day16(5, "s1,x3/4,pe/b").part1(), Matchers.is("baedc"));
        MatcherAssert.assertThat(new Day16().part1(), Matchers.is("kbednhopmfcjilag"));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day16(ProgramSequenceInts::new).part2(), Matchers.is("fbmcgdnjakpioelh"));
        MatcherAssert.assertThat(new Day16().part2(), Matchers.is("fbmcgdnjakpioelh"));
    }

}
