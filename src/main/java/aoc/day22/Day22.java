package aoc.day22;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day22 implements TwoPartChallenge<Long, Long> {

    private final int[] input;

    public Day22() {
        this(new StdInput(22).read());
    }

    public Day22(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    @Override
    public Long part1() {
        return 0L;
    }

    @Override
    public Long part2() {
        return 0L;
    }

}
