package aoc.day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day16Bitwise implements TwoPartChallenge<String, String> {

    private final int length;

    private final List<Day16Bitwise.Move> input;

    public Day16Bitwise() {
        this(16, new StdInput(16).read());
    }

    public Day16Bitwise(final int length, final String input) {
        this(
            length,
            Arrays.stream(input.split(","))
                .map(Day16Bitwise::parseMove)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String part1() {
        final ProgramSequence programs = new ProgramSequence.Default(this.length);
        this.dance(programs);
        return programs.toString();
    }

    @Override
    public String part2() {
        //log.info(printPrograms(programs));
        //log.info(Arrays.toString(this.permutation(programs)));
        //this.dance(programs);
        //log.info(printPrograms(programs));
        //log.info(Arrays.toString(this.permutation(programs)));
/*        final int block = 1000;
        for (int idx = 0; idx < block; ++idx) {
            this.dance(programs);
        }
        final int[] blockperm = this.permutation(programs);
        Day16.log.info("Block end pos: {}", Day16.printPrograms(programs));
        Day16.log.info("Block perm: {}", Arrays.toString(blockperm));
        final int[] test = this.buildLine();
        Day16.log.info("Test start pos: {}", Day16.printPrograms(test));
        for (int idx = 0; idx < block; ++idx) {
            this.dance(test);
        }
        Day16.log.info("Test interm. pos: {}", Day16.printPrograms(test));
        this.dance(test);
        Day16.log.info("Test end pos: {}", Day16.printPrograms(test));
        final int[] testperm = this.permutation(test);
        Day16.log.info("Test perm: {}", testperm);
        //this.compose(test, blockperm);
        Day16.log.info(Day16.printPrograms(this.positionFromPermutation(testperm)));
        Day16.log.info(Arrays.toString(testperm));*/
/*

        final int[] cum = new int[this.length];
        System.arraycopy(blockperm, 0, cum, 0, this.length);
        for (int idx = 0; idx < 1000000000 / block; ++idx) {
            //log.info("I = {}", idx);
            this.compose(cum, blockperm);
        }
        System.arraycopy(this.positionFromPermutation(cum), 0, programs, 0, this.length);
        log.info(printPrograms(programs));
        return Day16Bitwise.printPrograms(programs);
        */
        final int iterations = 1000000000;
        final ProgramSequence initial = new ProgramSequence.Default(this.length);
        final ProgramSequence programs = new ProgramSequence.Default(this.length);
        for (int idx = 1; idx <= iterations; ++idx) {
            this.dance(programs);
            if (programs.equals(initial)) {
                log.info("CYCLE at {} iterations!", idx);
                log.info("Modulus = {}", iterations % idx);
                final ProgramSequence reset = new ProgramSequence.Default(this.length);
                for (int jdx = 0; jdx < iterations % idx; ++jdx) {
                    this.dance(reset);
                }
                return reset.toString();
            }
        }
        return programs.toString();
    }

    private void dance(final ProgramSequence programs) {
        for (final Day16Bitwise.Move move : this.input) {
            //log.info(programs.toString());
            //log.info("Move: {}", move);
            move.execute(programs);
            //log.info(programs.toString());
        }
    }

    private static Day16Bitwise.Move parseMove(final String input) {
        final char first = input.charAt(0);
        if (first == 's') {
            return new Day16Bitwise.Move.Spin(Integer.parseInt(input.substring(1)));
        }
        if (first == 'x') {
            final String[] split = input.substring(1).split("/");
            return new Day16Bitwise.Move.Exchange(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        if (first == 'p') {
            final String[] split = input.substring(1).split("/");
            return new Day16Bitwise.Move.Partner(split[0].charAt(0), split[1].charAt(0));
        }
        Day16Bitwise.log.info("WTF");
        throw new IllegalArgumentException("Parsing error");
    }

    private interface Move {

        void execute(ProgramSequence programs);

        @ToString
        @RequiredArgsConstructor
        final class Spin implements Day16Bitwise.Move {

            private final int size;

            @Override
            public void execute(final ProgramSequence programs) {
                programs.spin(this.size);
            }

        }

        @ToString
        @RequiredArgsConstructor
        final class Exchange implements Day16Bitwise.Move {

            private final int left;

            private final int right;

            @Override
            public void execute(final ProgramSequence programs) {
                programs.exchange(this.left, this.right);
            }

        }

        @ToString
        @RequiredArgsConstructor
        final class Partner implements Day16Bitwise.Move {

            private final char left;

            private final char right;

            @Override
            public void execute(final ProgramSequence programs) {
                programs.partner(this.left, this.right);
            }

        }

    }

}

