package aoc;

public interface Challenge<T> {

    default String name() {
        return this.getClass().getSimpleName();
    }

    T run();

}
