package aoc.day03;

import java.util.function.Predicate;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day03 implements Challenge<Long> {

    private static final Move RIGHT = new Move.Right();

    private static final Move UP = new Move.Up();

    private static final Move LEFT = new Move.Left();

    private static final Move DOWN = new Move.Down();

    private final ValueFunction next;

    private final Predicate<State> halt;

    private final ValueFunction result;

    private State state = new State.Default();

    @Override
    public Long run() {
        long length = 1L;
        while (!this.halt.test(this.state)) {
            this.iterate(length, Day03.RIGHT);
            if (this.halt.test(this.state)) {
                break;
            }
            this.iterate(length, Day03.UP);
            length++;
            if (this.halt.test(this.state)) {
                break;
            }
            this.iterate(length, Day03.LEFT);
            if (this.halt.test(this.state)) {
                break;
            }
            this.iterate(length, Day03.DOWN);
            length++;
        }
        return this.result.apply(this.state);
    }

    private void iterate(final long length, final Move move) {
        for (long idx = 0L; idx < length; ++idx) {
            this.state = move.apply(this.state);
            this.updateValue();
            if (this.halt.test(this.state)) {
                break;
            }
        }
    }

    private void updateValue() {
        this.state = new State.Default(
            this.state.x(),
            this.state.y(),
            this.next.apply(this.state)
        );
    }

}
