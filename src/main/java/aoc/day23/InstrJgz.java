package aoc.day23;

public final class InstrJgz implements Instruction {

    @Override
    public void run(final InstructionEnv env) {
        final long value = env.eval(env.operand1());
        if (value > 0L) {
            env.state().jump((int) env.operand2());
        } else {
            env.state().incrementProgramCounter();
        }
    }

}
