package aoc.day08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day08 implements Challenge<Long> {

    private final State state = new State.Default();

    private final Solution solution;

    private final List<InstructionDef> instructions;

    Day08(final Solution solution) {
        this(solution, new StdInput(8).read());
    }

    Day08(final Solution solution, final String input) {
        this(
            solution,
            Arrays.stream(input.split("\n"))
                .map(InstructionDef.Default::parse)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Long run() {
        this.instructions.stream()
            .map(Instruction.Default::new)
            .forEach(instr -> {
                instr.run(this.state);
                this.solution.notifyState(this.state);
            });
        return this.solution.get();
    }

}
