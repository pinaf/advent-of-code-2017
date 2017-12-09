package aoc.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day09Test {

    private static final String INPUT =
        "b inc 5 if a > 1\n" +
        "a inc 1 if b < 5\n" +
        "c dec -10 if a >= 1\n" +
        "c inc -20 if c == 10";

    @Test
    public void test() {
        MatcherAssert.assertThat(new Day09("{}").run(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09("{{{}}}").run(), Matchers.is(6L));
        MatcherAssert.assertThat(new Day09("{{},{}}").run(), Matchers.is(5L));
        MatcherAssert.assertThat(new Day09("{{{},{},{{}}}}").run(), Matchers.is(16L));
        MatcherAssert.assertThat(new Day09("{<a>,<a>,<a>,<a>}").run(), Matchers.is(1L));
        MatcherAssert.assertThat(new Day09("{{<ab>},{<ab>},{<ab>},{<ab>}}").run(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09("{{<!!>},{<!!>},{<!!>},{<!!>}}").run(), Matchers.is(9L));
        MatcherAssert.assertThat(new Day09("{{<a!>},{<a!>},{<a!>},{<ab>}}").run(), Matchers.is(3L));
        //MatcherAssert.assertThat(new Day09().run(), Matchers.is(6611L));
    }

}
