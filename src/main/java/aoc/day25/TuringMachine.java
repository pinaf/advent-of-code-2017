package aoc.day25;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

public interface TuringMachine {

    void runSingle();

    void run(int steps);

    int checksum();

    @RequiredArgsConstructor
    final class Default implements TuringMachine {

        private final Map<String, State> states;

        private final Tape tape = new Tape.Default(10000);

        private State state;

        public Default(final String input) {
            this(
                TuringMachine.Default.parseInitialState(input),
                TuringMachine.Default.parseStates(input)
            );
        }

        public Default(final String initial, final State... states) {
            this.states = TuringMachine.Default.buildStateMap(states);
            this.state = this.states.get(initial);
        }

        @Override
        public void runSingle() {
            final Instruction instr = this.state.instruction(this.tape.read());
            this.tape.write(instr.value());
            if (instr.move() < 0) {
                this.tape.moveLeft();
            } else {
                this.tape.moveRight();
            }
            this.state = this.states.get(instr.state());
        }

        @Override
        public void run(final int steps) {
            for (int idx = 0; idx < steps; ++idx) {
                this.runSingle();
            }
        }

        @Override
        public int checksum() {
            return this.tape.checksum();
        }

        private static Map<String, State> buildStateMap(final State... states) {
            return Arrays.stream(states).collect(Collectors.toMap(
                State::key,
                Function.identity()
            ));
        }

        private static String parseInitialState(final CharSequence input) {
            final Matcher matcher = Pattern.compile("Begin in state (?<state>(\\w)).").matcher(input);
            matcher.find();
            return matcher.group("state");
        }

        private static State[] parseStates(final String input) {
            return Arrays.stream(input.split("\n\n"))
                .skip(1L)
                .map(State.Default::parse)
                .toArray(State[]::new);
        }
    }

}
