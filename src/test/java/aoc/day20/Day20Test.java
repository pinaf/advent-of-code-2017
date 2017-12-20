package aoc.day20;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day20Test {

    private final String input1 =
        "p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n" +
        "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>";

    private final String input2 =
        "p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>\n" +
        "p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>\n" +
        "p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>\n" +
        "p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>";

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day20(this.input1).part1(), Matchers.is(0));
        MatcherAssert.assertThat(new Day20().part1(), Matchers.is(170));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day20(this.input2).part2(), Matchers.is(1));
        MatcherAssert.assertThat(new Day20().part2(), Matchers.is(571));
    }

}
