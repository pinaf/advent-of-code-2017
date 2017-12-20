package aoc.day20;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Vector3d {

    long x();

    long y();

    long z();

    Vector3d add(Vector3d vector);

    @Getter
    @ToString
    @Accessors(fluent = true)
    @EqualsAndHashCode(of = {"x", "y", "z"})
    final class Default implements Vector3d {

        private long x, y, z;

        public Default(final String value) {
            final String[] split = value.substring(1, value.length() - 1).trim().split(",");
            this.x = Long.parseLong(split[0]);
            this.y = Long.parseLong(split[1]);
            this.z = Long.parseLong(split[2]);
        }

        @Override
        public Vector3d add(final Vector3d vector) {
            this.x += vector.x();
            this.y += vector.y();
            this.z += vector.z();
            return this;
        }

    }

}
