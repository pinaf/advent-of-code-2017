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
    }

    @Test
    public void part2() {
        /*
[main] INFO aoc.day23.Day23 - PC = 23, INSTR = jnz g -13
[main] INFO aoc.day23.Day23 - State.Default(registers={a=1, b=109300, c=126300, d=219, e=109300, f=0, g=-109081})
[main] INFO aoc.day23.Day23 - PC = 23, INSTR = jnz g -13
[main] INFO aoc.day23.Day23 - State.Default(registers={a=1, b=109300, c=126300, d=220, e=109300, f=0, g=-109080})
         */
        MatcherAssert.assertThat(new Day23().part2(), Matchers.is(911L));
    }

}
