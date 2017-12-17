package aoc.day16;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day16 implements TwoPartChallenge<String, String> {

    private static final Function<Integer, ProgramSequence> DEFAULT_FACTORY = ProgramSequenceBits::new;

    private final Function<Integer, ProgramSequence> factory;

    private final int length;

    private final List<Move> input;

    public Day16() {
        this(16, new StdInput(16).read());
    }

    public Day16(final Function<Integer, ProgramSequence> factory) {
        this(factory, 16, new StdInput(16).read());
    }

    public Day16(final int length, final String input) {
        this(
            Day16.DEFAULT_FACTORY,
            length,
            Arrays.stream(input.split(","))
                .map(Day16::parseMove)
                .collect(Collectors.toList())
        );
    }

    public Day16(final Function<Integer, ProgramSequence> factory, final int length, final String input) {
        this(
            factory,
            length,
            Arrays.stream(input.split(","))
                .map(Day16::parseMove)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String part1() {
        final ProgramSequence programs = this.factory.apply(this.length);
        this.dance(programs);
        return programs.toString();
    }

    @Override
    public String part2() {
        final ProgramSequence initial = this.factory.apply(this.length);
        final ProgramSequence programs = this.factory.apply(this.length);
        final int iterations = 1000000000;
        for (int idx = 1; idx <= iterations; ++idx) {
            this.dance(programs);
            if (programs.equals(initial)) {
                log.info("CYCLE at {} iterations!", idx);
                log.info("Modulus = {}", iterations % idx);
                final ProgramSequence reset = this.factory.apply(this.length);
                for (int jdx = 0; jdx < iterations % idx; ++jdx) {
                    this.dance(reset);
                }
                return reset.toString();
            }
        }
        return programs.toString();
    }

    private void dance(final ProgramSequence programs) {
        for (final Move move : this.input) {
            move.execute(programs);
        }
    }

    private static Move parseMove(final String input) {
        final char first = input.charAt(0);
        final String tail = input.substring(1);
        final Move move;
        switch (first) {
            case 's':
                move = new Move.Spin(tail);
                break;
            case 'x':
                move = new Move.Exchange(tail);
                break;
            case 'p':
                move = new Move.Partner(tail);
                break;
            default:
                throw new IllegalArgumentException("Parsing error");
        }
        return move;
    }

}

