package aoc.day03;

import java.util.HashMap;
import java.util.Map;

public interface Memory2D {

    void write(long x, long y, long value);

    long read(long x, long y);

    final class Default implements Memory2D {

        private final Map<Long, Map<Long, Long>> map = new HashMap<>(1000);

        @Override
        public void write(final long x, final long y, final long value) {
            this.map.putIfAbsent(x, new HashMap<>(1000));
            this.map.get(x).put(y, value);
        }

        @Override
        public long read(final long x, final long y) {
            if (!this.map.containsKey(x)) {
                return 0L;
            }
            return this.map.get(x).getOrDefault(y, 0L);
        }

    }

}
