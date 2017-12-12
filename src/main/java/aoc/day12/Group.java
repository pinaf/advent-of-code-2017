package aoc.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Group {

    void add(long... programs);

    boolean containsAny(long... programs);

    long size();

    final class Default implements Group {

        private final Set<Long> progs = new HashSet<>(1000);

        @Override
        public void add(final long... programs) {
            Arrays.stream(programs).forEach(this.progs::add);
        }

        @Override
        public boolean containsAny(final long... programs) {
            return Arrays.stream(programs).anyMatch(this.progs::contains);
        }

        @Override
        public long size() {
            return (long) this.progs.size();
        }

    }

}
