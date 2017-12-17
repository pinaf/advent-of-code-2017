package aoc.day16;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

interface Move {

    void execute(ProgramSequence programs);

    @ToString
    @RequiredArgsConstructor
    final class Spin implements Move {

        private final int size;

        public Spin(final String input) {
            this(Integer.parseInt(input));
        }

        @Override
        public void execute(final ProgramSequence programs) {
            programs.spin(this.size);
        }

    }

    @ToString
    @RequiredArgsConstructor
    final class Exchange implements Move {

        private final int left;

        private final int right;

        public Exchange(final String input) {
            this(input.split("/"));
        }

        private Exchange(final String[] input) {
            this(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        @Override
        public void execute(final ProgramSequence programs) {
            programs.exchange(this.left, this.right);
        }

    }

    @ToString
    @RequiredArgsConstructor
    final class Partner implements Move {

        private final char left;

        private final char right;

        public Partner(final String input) {
            this(input.split("/"));
        }

        private Partner(final String[] input) {
            this(input[0].charAt(0), input[1].charAt(0));
        }

        @Override
        public void execute(final ProgramSequence programs) {
            programs.partner(this.left, this.right);
        }

    }

}
