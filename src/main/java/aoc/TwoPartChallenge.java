package aoc;

public interface TwoPartChallenge<R, S> {

    default String name() {
        return this.getClass().getSimpleName();
    }

    R part1();

    S part2();

}
