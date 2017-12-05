package aoc;

public abstract class ChallengeWrap<T> implements Challenge<T> {

    private final Challenge<T> wrapped;

    protected ChallengeWrap(final Challenge<T> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public final T run() {
        return this.wrapped.run();
    }

}
