package aoc.day16;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class ProgramSequenceInts implements ProgramSequence {

    private final int size;

    private final int[] programs;

    public ProgramSequenceInts(final int size) {
        this.size = size;
        this.programs = new int[size];
        for (int idx = 0; idx < this.programs.length; ++idx) {
            this.programs[idx] = idx + (int) 'a';
        }
    }

    @Override
    public void spin(final int units) {
        int left = units;
        while (left > 0) {
            this.singleSpin();
            left--;
        }
    }

    private void singleSpin() {
        final int tmp = this.programs[this.programs.length - 1];
        for (int idx = this.programs.length - 1; idx > 0; --idx) {
            this.programs[idx] = this.programs[idx - 1];
        }
        this.programs[0] = tmp;
    }

    @Override
    public void exchange(final int left, final int right) {
        final int tmp = this.programs[left];
        this.programs[left] = this.programs[right];
        this.programs[right] = tmp;
    }

    @Override
    public void partner(final int left, final int right) {
        int a = -1;
        int b = -1;
        for (int idx = 0; idx < this.programs.length; ++idx) {
            final char current = (char) this.programs[idx];
            if (current == left) {
                a = idx;
            } else if (current == right) {
                b = idx;
            }
            if (a >= 0 && b >= 0) {
                break;
            }
        }
        this.exchange(a, b);
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.size)
            .map(this::program)
            .mapToObj(i -> new String(new char[]{(char) i}))
            .collect(Collectors.joining(""));
    }

    private int program(final int prog) {
        return this.programs[prog];
    }

}
