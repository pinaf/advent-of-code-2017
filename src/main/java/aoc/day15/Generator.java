package aoc.day15;

import lombok.RequiredArgsConstructor;

public interface Generator {

    long next();

    final class Simple implements Generator {

        private final long factor;

        private final long modulus;

        private long current;

        public Simple(final long seed, final long factor, final long modulus) {
            this.factor = factor;
            this.modulus = modulus;
            this.current = seed;
        }

        @Override
        public long next() {
            this.current = (this.current * factor) % this.modulus;
            return this.current;
        }

    }

    @RequiredArgsConstructor
    final class Selective implements Generator {

        private final Generator wrapped;

        private final long modulus;

        @Override
        public long next() {
            long value = this.wrapped.next();
            while (value % this.modulus != 0L) {
                value = this.wrapped.next();
            }
            return value;
        }

    }

}
