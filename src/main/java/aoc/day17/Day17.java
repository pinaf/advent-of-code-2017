package aoc.day17;

import java.util.ArrayList;
import java.util.List;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day17 implements TwoPartChallenge<Long, Long> {

    private final int step;

    public Day17() {
        this(new StdInput(17).read());
    }

    public Day17(final String input) {
        this(Integer.parseInt(input));
    }

    @Override
    public Long part1() {
        final List<Integer> buffer = new ArrayList<>(2018);
        buffer.add(0);
        int pos = 0;
        for (int idx = 1; idx <= 2017; ++idx) {
            pos = (pos + this.step + 1) % buffer.size();
            buffer.add(pos, idx);
        }
        return (long) buffer.get((pos + 1) % buffer.size());
    }

    @Override
    public Long part2() {
        int size = 1;
        int pos = 0;
        int zero = 0;
        int first = 0;
        int next = -1;
        for (int idx = 1; idx <= 50000000; ++idx) {
            pos = (pos + this.step + 1) % size;
            if (pos == zero + 1) {
                next = idx;
            } else if (pos <= zero) {
                zero++;
            }
            if (pos == 0) {
                first = idx;
            }
            size++;
        }
        if (zero == size - 1) {
            return (long) first;
        } else {
            return (long) next;
        }
    }

}
