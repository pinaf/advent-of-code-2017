package aoc.day20;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface ParticleState {

    int index();

    ParticleState index(int i);

    Vector3d pos();

    Vector3d vel();

    Vector3d acc();

    void tick();

    long distance();

    @Getter
    @Accessors(fluent = true)
    @ToString
    @RequiredArgsConstructor
    final class Default implements ParticleState {

        @Getter
        @Setter
        private int index;

        private final Vector3d pos;

        private final Vector3d vel;

        private final Vector3d acc;

        public Default(final String input) {
            final String[] split = input.split(", ");
            this.pos = new Vector3d.Default(split[0].substring(2));
            this.vel = new Vector3d.Default(split[1].substring(2));
            this.acc = new Vector3d.Default(split[2].substring(2));
        }

        @Override
        public void tick() {
            this.vel.add(this.acc);
            this.pos.add(this.vel);
        }

        @Override
        public long distance() {
            return Math.abs(this.pos.x()) + Math.abs(this.pos.y()) + Math.abs(this.pos.z());
        }

    }

}
