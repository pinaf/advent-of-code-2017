package aoc.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day06 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final ResultFunction result;

    private final int[] banks;

    private final List<int[]> seen = new ArrayList<>(1000);

    Day06(final ResultFunction result) {
        this(
            result,
            Arrays.stream(PATTERN.split(new StdInput(6).read()))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray()
        );
    }

    Day06(final ResultFunction result, final int head, final int... tail) {
        this(
            result,
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
        this.rememberCurrentConfiguration();
        long steps = 0L;
        Optional<Integer> match = Optional.empty();
        while (!match.isPresent()) {
            steps++;
            this.redistribute(this.selectBank());
            match = this.seenBefore();
            this.rememberCurrentConfiguration();
        }
        return this.result.apply(steps, match.get());
    }

    private void rememberCurrentConfiguration() {
        this.seen.add(Arrays.copyOf(this.banks, this.banks.length));
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

    private Optional<Integer> seenBefore() {
        for (int idx = 0; idx < this.seen.size(); ++idx) {
            final int[] configuration = this.seen.get(idx);
            if (Arrays.equals(this.banks, configuration)) {
                return Optional.of(idx);
            }
        }
        return Optional.empty();
    }

}
