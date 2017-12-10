package aoc;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ChallengeTemplate implements Challenge<Long> {

    private final int[] input;

    public ChallengeTemplate() {
        this(new StdInput(1).read());
    }

    public ChallengeTemplate(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    @Override
    public Long run() {
        return 0L;
    }

}
