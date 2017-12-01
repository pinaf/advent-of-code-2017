package aoc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day01Test {

    @Test
    public void tests() {
        MatcherAssert.assertThat(new Day01("1122").run(), Matchers.is(3L));
        MatcherAssert.assertThat(new Day01("1111").run(), Matchers.is(4L));
        MatcherAssert.assertThat(new Day01("1234").run(), Matchers.is(0L));
        MatcherAssert.assertThat(new Day01("91212129").run(), Matchers.is(9L));
    }

}
