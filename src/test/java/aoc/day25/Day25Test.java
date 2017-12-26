package aoc.day25;

import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@RequiredArgsConstructor
public final class Day25Test {

    private final String input =
        "Begin in state A.\n" +
        "Perform a diagnostic checksum after 6 steps.\n" +
        "\n" +
        "In state A:\n" +
        "  If the current value is 0:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the right.\n" +
        "    - Continue with state B.\n" +
        "  If the current value is 1:\n" +
        "    - Write the value 0.\n" +
        "    - Move one slot to the left.\n" +
        "    - Continue with state B.\n" +
        "\n" +
        "In state B:\n" +
        "  If the current value is 0:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the left.\n" +
        "    - Continue with state A.\n" +
        "  If the current value is 1:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the right.\n" +
        "    - Continue with state A.";

    private final TuringMachine machine = new TuringMachine.Default(
        "A",
        new State.Default(
            "A",
            new Instruction.Default(1, 1, "B"),
            new Instruction.Default(0, -1, "B")
        ),
        new State.Default(
            "B",
            new Instruction.Default(1, -1, "A"),
            new Instruction.Default(1, 1, "A")
        )
    );

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day25(this.input).part1(), Matchers.is(3));
        MatcherAssert.assertThat(new Day25(6, this.machine).part1(), Matchers.is(3));
        MatcherAssert.assertThat(new Day25().part1(), Matchers.is(2832));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day25().part2(), Matchers.is(0));
    }

}
