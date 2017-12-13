package aoc.day09;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day09Common implements Challenge<Long>  {

    private final Solution solution;

    private final char[] input;

    private final State state = new State.Default();

    Day09Common(final Solution solution, final String input) {
        this(solution, input.toCharArray());
    }

    @Override
    public Long run() {
        boolean garbage = false;
        boolean ignore = false;
        int depth = 0;
        for (final char current : this.input) {
            if (garbage) {
                if (ignore) {
                    ignore = false;
                } else {
                    if (current == '!') {
                        ignore = true;
                    } else if (current == '>') {
                        garbage = false;
                    } else {
                        this.state.garbageSeen();
                    }
                }
            } else {
                if (current == '<') {
                    garbage = true;
                }
                if (current == '{') {
                    depth += 1;
                    this.state.newGroupSeen(depth);
                } else if (current == '}') {
                    depth -= 1;
                }
            }
        }
        return this.solution.apply(this.state);
    }

}
