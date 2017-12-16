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
public final class Day16 implements TwoPartChallenge<String, String> {

    private final int length;

    private final List<Day16.Move> input;

    public Day16() {
        this(16, new StdInput(16).read());
    }

    public Day16(final int length, final String input) {
        this(
            length,
            Arrays.stream(input.split(","))
                .map(Day16::parseMove)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String part1() {
        final int[] programs = this.buildLine();
        this.dance(programs);
        return Day16.printPrograms(programs);
    }

    @Override
    public String part2() {
        final int[] programs = this.buildLine();
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
        log.info(Arrays.toString(this.permutation(programs)));*/
        for (int idx = 0; idx < 10000; ++idx) {
            this.dance(programs);
        }
        return Day16.printPrograms(programs);
    }

    private int[] positionFromPermutation(final int[] permutation) {
        final int[] pos = new int[this.length];
        for (int idx = 0; idx < this.length; ++idx) {
            pos[permutation[idx]] = idx + (int) 'a';
        }
        return pos;
    }

    private void compose(final int[] target, final int[] permutation) {
        for (int jdx = 0; jdx < this.length; ++jdx) {
            target[jdx] = permutation[target[jdx]];
        }
    }

    private int[] buildLine() {
        final int[] programs = new int[this.length];
        for (int jdx = 0; jdx < programs.length; ++jdx) {
            programs[jdx] = jdx + (int) 'a';
        }
        return programs;
    }

    private int[] permutation(final int[] programs) {
        final int[] perm = new int[programs.length];
        for (int jdx = 0; jdx < programs.length; ++jdx) {
            final int prog = jdx + (int) 'a';
            int pos = -1;
            for (int idx = 0; idx < programs.length; ++idx) {
                if (programs[idx] == prog) {
                    pos = idx;
                }
            }
            perm[jdx] = pos;
        }
        return perm;
    }

    private static String printPrograms(final int[] programs) {
        return Arrays
            .stream(programs).mapToObj(i -> new String(new char[] {(char) i}))
            .collect(Collectors.joining(""));
    }

    private void dance(final int[] programs) {
        for (final Day16.Move move : this.input) {
            //log.info("Move: {}", move);
            move.execute(programs);
            //log.info(printPrograms(programs));
        }
    }

    private static Day16.Move parseMove(final String input) {
        final char first = input.charAt(0);
        if (first == 's') {
            return new Day16.Move.Spin(Integer.parseInt(input.substring(1)));
        }
        if (first == 'x') {
            final String[] split = input.substring(1).split("/");
            return new Day16.Move.Exchange(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        if (first == 'p') {
            final String[] split = input.substring(1).split("/");
            return new Day16.Move.Partner(split[0].charAt(0), split[1].charAt(0));
        }
        Day16.log.info("WTF");
        throw new IllegalArgumentException("Parsing error");
    }

    private interface Move {

        void execute(int[] programs);

        @ToString
        @RequiredArgsConstructor
        final class Spin implements Day16.Move {

            private final int size;

            @Override
            public void execute(final int[] programs) {
                int left = this.size;
                while (left > 0) {
                    Day16.Move.Spin.single(programs);
                    left--;
                }
            }

            private static void single(final int[] programs) {
                final int tmp = programs[programs.length - 1];
                for (int idx = programs.length - 1; idx > 0; --idx) {
                    programs[idx] = programs[idx - 1];
                }
                programs[0] = tmp;
            }

        }

        @ToString
        @RequiredArgsConstructor
        final class Exchange implements Day16.Move {

            private final int left;

            private final int right;

            @Override
            public void execute(final int[] programs) {
                final int tmp = programs[this.left];
                programs[this.left] = programs[this.right];
                programs[this.right] = tmp;
            }

        }

        @ToString
        @RequiredArgsConstructor
        final class Partner implements Day16.Move {

            private final char left;

            private final char right;

            @Override
            public void execute(final int[] programs) {
                int a = -1;
                int b = -1;
                for (int idx = 0; idx < programs.length; ++idx) {
                    final char current = (char) programs[idx];
                    if (current == this.left) {
                        a = idx;
                    } else if (current == this.right) {
                        b = idx;
                    }
                    if (a >= 0 && b >= 0) {
                        break;
                    }
                }
                new Day16.Move.Exchange(a, b).execute(programs);
            }

        }

    }

}

