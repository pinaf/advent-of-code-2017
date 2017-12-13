package aoc.day13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
public final class Day13 implements TwoPartChallenge {

    private final List<Day13.Layer> layers;

    public Day13() {
        this(new StdInput(13).read());
    }

    public Day13(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .map(Day13.Layer.Default::new)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String name() {
        return "Day 13";
    }

    @Override
    public long part1() {
        long severity = 0L;
        for (final Day13.Layer layer : this.layers) {
            if (layer.onTopAtTime((long) layer.depth())) {
                severity += layer.severity();
            }
        }
        return severity;
    }

    @Override
    public long part2() {
        boolean pass = false;
        long delay = 0L;
        while (!pass) {
            final long fdelay = delay;
            pass = this.layers.stream().noneMatch(layer -> layer.onTopAtTime(fdelay + (long) layer.depth()));
            if (!pass) {
                delay++;
            }
        }
        return delay;
    }

    private interface Layer {

        int depth();

        int range();

        long severity();

        boolean onTopAtTime(long time);

        @Data
        @ToString
        @Accessors(fluent = true)
        final class Default implements Day13.Layer {

            private final int depth;

            private final int range;

            public Default(final String input) {
                final String[] split = input.split(": ");
                this.depth = Integer.parseInt(split[0]);
                this.range = Integer.parseInt(split[1]);
            }

            @Override
            public long severity() {
                return (long) this.depth * (long) this.range;
            }

            @Override
            public boolean onTopAtTime(final long time) {
                return time % this.cycle() == 0L;
            }

            private long cycle() {
                return 2L * (long) (this.range - 1);
            }

        }

    }

}
