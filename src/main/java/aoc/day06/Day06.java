package aoc.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day06 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final int[] banks;

    private final List<int[]> seen = new ArrayList<>(1000);

    public Day06() {
        this(
            Arrays.stream(PATTERN.split(new StdInput(6).read()))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray()
        );
    }

    public Day06(final int head, final int... tail) {
        this(
            IntStream.concat(
                IntStream.of(head),
                Arrays.stream(tail)
            ).toArray()
        );
    }

    @Override
    public Long run() {
        if (this.banks.length < 2) {
            return 0L;
        }
        long steps = 0L;
        boolean match = false;
        while (!match) {
            steps++;
            final int bank = this.selectBank();
            this.redistribute(bank);
            match = this.seenBefore();
            this.seen.add(Arrays.copyOf(this.banks, this.banks.length));
        }
        return steps;
    }

    private int selectBank() {
        final int max = Arrays.stream(this.banks).max().getAsInt();
        for (int idx = 0; idx < this.banks.length; ++idx) {
            if (this.banks[idx] == max) {
                return idx;
            }
        }
        throw new IllegalStateException("This should never be reached");
    }

    private void redistribute(final int bank) {
        final int length = this.banks.length;
        int left = this.banks[bank];
        this.banks[bank] = 0;
        int current = (bank + 1) % length;
        while (left > 0) {
            this.banks[current]++;
            left--;
            current = (current + 1) % length;
        }
    }

    private boolean seenBefore() {
        return this.seen.stream()
            .anyMatch(configuration -> Arrays.equals(this.banks, configuration));
    }

}
