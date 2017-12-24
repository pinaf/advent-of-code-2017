package aoc.day23;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day23Alt implements TwoPartChallenge<Long, Long> {

    private final InstructionMap alternate = new InstructionMap.Mutable(new Standard())
        .with("rsh", new InstrRsh())
        .with("jgz", new InstrJgz());

    private final String input;

    public Day23Alt() {
        this(new StdInput(23, "-alt").read());
    }

    @Override
    public Long part1() {
        final Program program = new Program.Default(this.alternate, this.input);
        program.run();
        return program.state().readRegister("h");
    }

    @Override
    public Long part2() {
        final Program program = new Program.Default(this.alternate, this.input);
        program.state().setRegister("a", 1L);
        program.run();
        return program.state().readRegister("h");
    }

}
