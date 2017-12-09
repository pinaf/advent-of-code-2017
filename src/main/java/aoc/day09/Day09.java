package aoc.day09;

import java.util.Arrays;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day09 implements Challenge<Long>  {

    private final long[] input;

    public Day09() {
        this(new StdInput(9).read());
    }

    public Day09(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .mapToLong(Long::parseLong)
                .toArray()
        );
    }

    @Override
    public Long run() {
        return 0L;
    }

}
