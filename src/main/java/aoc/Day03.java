package aoc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day03 implements Challenge<Long>{

    private final long target;

    private long x = 0;

    private long y = 0;

    private long length = 1L;

    private long current = 1L;

    @Override
    public Long run() {
        long remaining = this.remaining();
        long big = this.nextBigStep();
        while (remaining >= big) {
            this.current += big;
            this.x -= 1L;
            this.y -= 1L;
            this.length += 2L;
            big = this.nextBigStep();
            remaining = this.remaining();
        }
        if (remaining > 0L) {
            this.stepRight();
            remaining = this.remaining();
            if (remaining > 0L) {
                this.stepUp();
                remaining = this.remaining();
                if (remaining > 0L) {
                    this.stepLeft();
                    remaining = this.remaining();
                    if (remaining > 0L) {
                        this.stepDown();
                        assert this.remaining() == 0L;
                    }
                }
            }
        }
        return this.distanceToOrigin();
    }

    private long nextBigStep() {
        return 2L * (2L * this.length + 1L);
    }

    private void stepRight() {
        final long size = Math.min(this.length, this.remaining());
        this.x += size;
        this.current += size;
    }

    private void stepUp() {
        final long size = Math.min(this.length, this.remaining());
        this.y += size;
        this.current += size;
        if (size == this.length) {
            this.length++;
        }
    }

    private void stepLeft() {
        final long size = Math.min(this.length, this.remaining());
        this.x -= size;
        this.current += size;
    }

    private void stepDown() {
        final long size = Math.min(this.length, this.remaining());
        this.y -= size;
        this.current += size;
        if (size == this.length) {
            this.length++;
        }
    }

    private long remaining() {
        return this.target - this.current;
    }

    private long distanceToOrigin() {
        return Math.abs(this.x) + Math.abs(this.y);
    }

}
