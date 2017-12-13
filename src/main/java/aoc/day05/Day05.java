package aoc.day05;

import java.util.Arrays;
import java.util.regex.Pattern;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day05 implements TwoPartChallenge<Long, Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final int[] jumps;

    public Day05() {
        this(new StdInput(5).read());
    }

    public Day05(final CharSequence input) {
        this(
            Arrays.stream(Day05.PATTERN.split(input))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    @Override
    public Long part1() {
        return new Day05Common(new Operation.Increment(), this.jumps).run();
    }

    @Override
    public Long part2() {
        return new Day05Common(new Operation.Conditional(), this.jumps).run();
    }

}
