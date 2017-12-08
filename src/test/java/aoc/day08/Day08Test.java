package aoc.day08;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day08Test {

    @Test
    public void test() {
        MatcherAssert.assertThat(new Day08(
            "b inc 5 if a > 1\n" +
            "a inc 1 if b < 5\n" +
            "c dec -10 if a >= 1\n" +
            "c inc -20 if c == 10"
        ).run(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day08().run(), Matchers.is(66111L));
        // part 2 = 6619
    }

}
