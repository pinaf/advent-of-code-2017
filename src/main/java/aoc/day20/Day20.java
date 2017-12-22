package aoc.day20;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day20 implements TwoPartChallenge<Integer, Integer> {

    private final List<ParticleState> particles;

    public Day20() {
        this(new StdInput(20).read());
    }

    public Day20(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .map(ParticleState.Default::new)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Integer part1() {
        this.labelParticles();
        ParticleState closest = this.particles.get(0);
        for (int time = 0; time < 1000; ++time) {
            this.tick();
            closest = this.particles.stream()
                .sorted((x, y) -> Long.compareUnsigned(x.distance(), y.distance()))
                .findFirst().get();
        }
        return closest.index();
    }

    @Override
    public Integer part2() {
        this.labelParticles();
        long time = 0L;
        long count;
        do {
            this.tick();
            time++;
            count = this.resolveCollisions();
            //if (count > 0L) {
                //Day20.log.info("Removed {} particles at time {}", count, time);
            //}
            if (this.particles.size() <= 1) {
                break;
            }
        } while (time <= 1000L || count > 0L);
        return this.particles.size();
    }

    private void labelParticles() {
        int k = 0;
        for (final ParticleState particle : this.particles) {
            particle.index(k);
            k++;
        }
    }

    private void tick() {
        this.particles.forEach(ParticleState::tick);
    }

    private void printParticles() {
        this.particles
            .forEach(particle -> Day20.log.info("Particle: {}", particle));
    }

    private void printParticle(final int index) {
        this.particles.stream()
            .filter(p -> p.index() == index)
            .forEach(particle -> Day20.log.info("Particle: {}", particle));
    }

    private long resolveCollisions() {
        long count = 0L;
        Optional<ParticleState> match = this.findFirstCollision();
        while (match.isPresent()) {
            final ParticleState particle = match.get();
            final Set<ParticleState> collisions = this.collisions(particle);
            this.particles.removeAll(collisions);
            this.particles.remove(particle);
            /*Day20.log.info(
                "Collision: {}",
                Stream.concat(
                    Stream.of(particle.index()),
                    collisions.stream().map(ParticleState::index)
                ).collect(Collectors.toSet())
            );*/
            count += (long) collisions.size() + 1L;
            if (this.particles.size() <= 1) {
                break;
            }
            match = this.findFirstCollision();
        }
        return count;
    }

    private Optional<ParticleState> findFirstCollision() {
        return this.particles.stream()
            .filter(p -> !this.collisions(p).isEmpty())
            .findFirst();
    }

    private Set<ParticleState> collisions(final ParticleState particle) {
        return this.particles.stream()
            .filter(p -> p.index() != particle.index())
            .filter(p -> p.pos().equals(particle.pos()))
            .collect(Collectors.toSet());
    }

}
