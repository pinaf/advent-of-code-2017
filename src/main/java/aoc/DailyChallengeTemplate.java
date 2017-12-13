package aoc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DailyChallengeTemplate implements TwoPartChallenge<Long, Long> {

    private final String input;

    public DailyChallengeTemplate() {
        this(new StdInput(1).read());
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
