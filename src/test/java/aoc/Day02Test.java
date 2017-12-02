package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day02Test {

    @Test
    public void part1() {
        MatcherAssert.assertThat(
            new Day02(
                new Day02.Strategy.MinMax(),
                "5 1 9 5",
                "7 5 3",
                "2 4 6 8"
            ).run(),
            Matchers.is(18L)
        );
    }

}
