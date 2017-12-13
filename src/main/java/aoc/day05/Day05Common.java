package aoc.day05;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day05Common implements Challenge<Long> {

    private final Operation operation;

    private final int[] jumps;

    @Override
    public Long run() {
        long steps = 0L;
        int offset = 0;
        while (offset >= 0 && offset < this.jumps.length) {
            final int jump = this.jumps[offset];
            this.jumps[offset] = this.operation.apply(jump);
            offset += jump;
            steps++;
        }
        return steps;
    }

}
