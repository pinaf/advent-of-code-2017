package aoc.day16;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.EqualsAndHashCode;

public interface ProgramSequence {

    void spin(int units);

    void exchange(int left, int right);

    void partner(int left, int right);

    @EqualsAndHashCode(of = "value")
    final class Default implements ProgramSequence {

        private static final int MASK = 0xf;

        private final int size;

        private long value;

        public Default(final int size) {
            this(
                size,
                IntStream.range(0, size)
                    .mapToLong(i -> (long) (i & ProgramSequence.Default.MASK) << ((size - 1 - i) << 2))
                    .sum()
            );
        }

        private Default(final int size, final long value) {
            this.size = size;
            this.value = value;
        }

        @Override
        public void spin(final int units) {
            if (this.size < 16) {
                for (int idx = 0; idx < units; ++idx) {
                    this.exchange(15 - idx, this.size - 1 - idx);
                }
            }
            this.value = Long.rotateRight(this.value, units << 2);
        }

        @Override
        public void exchange(final int left, final int right) {
            final int tmp = this.program(left);
            this.writeProgram(left, this.program(right));
            this.writeProgram(right, tmp);
        }

        @Override
        public void partner(final int left, final int right) {
            int l = -1;
            int r = -1;
            for (int idx = 0; idx < this.size; ++idx) {
                final int current = (int) 'a' + this.program(idx);
                if (current == left) {
                    l = idx;
                } else if (current == right) {
                    r = idx;
                }
                if (l >=0 && r >= 0) {
                    break;
                }
            }
            this.exchange(l, r);
        }

        @Override
        public String toString() {
            return IntStream.range(0, this.size)
                .map(prog -> (int) 'a' + this.program(prog))
                .mapToObj(i -> new String(new char[] { (char) i }))
                .collect(Collectors.joining(""));
        }

        private void writeProgram(final int prog, final int value) {
            final int shift = (this.size - 1 - prog) << 2;
            this.value &= ~((long) ProgramSequence.Default.MASK << shift);
            this.value |= (long) (value & ProgramSequence.Default.MASK) << shift;
        }

        private int program(final int prog) {
            final int shift = (this.size - 1 - prog) << 2;
            return (int) ((this.value & (long) ProgramSequence.Default.MASK << shift) >> shift & (long) ProgramSequence.Default.MASK);
        }

    }

}
