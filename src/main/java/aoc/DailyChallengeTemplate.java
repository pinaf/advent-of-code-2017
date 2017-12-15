package aoc;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DailyChallengeTemplate implements TwoPartChallenge<Long, Long> {

    private final int[] input;

    public DailyChallengeTemplate() {
        this(new StdInput(1).read());
    }

    public DailyChallengeTemplate(final String input) {
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
