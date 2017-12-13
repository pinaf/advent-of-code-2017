package aoc.day13;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day13 implements Challenge<Long> {

    private final Map<Integer, Layer> layers;

    public Day13() {
        this(new StdInput(13).read());
    }

    public Day13(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .map(Layer.Default::new)
                .collect(Collectors.toMap(Layer::depth, layer -> layer))
        );
    }

    @Override
    public Long run() {
        final int max = this.lastDepth();
        log.info("max: {}", max);
        long delay = 0L;
        this.layers.values().forEach(Layer::reset);
        while (this.caught(max, delay) >= 0) {
            this.layers.values().forEach(Layer::reset);
            delay ++;
        }
        return delay;
    }

    private int caught(final int max, final long delay) {
        //long severity = 0L;
        //log.info("Delay {}", delay);
        this.layers.values().forEach(layer -> layer.tick(delay));
        for (int depth = 0; depth <= max; ++depth) {
            //log.info("Depth {}", depth);
            //Arrays.stream(this.input).forEach(l -> log.info("Layer {}", l));
            final Optional<Layer> match = this.findLayerByDepth(depth);
            if (match.isPresent()) {
                final Layer layer = match.get();
                if (layer.scanner() == 0) {
                    //severity += layer.depth() * layer.range();
                    log.info("Delay {} caught at {}", delay, depth);
                    return depth;
                }
            }
            this.tick();
        }
        return -1;
    }

    private void tick() {
        this.layers.values().forEach(Layer::tick);
    }

    private int lastDepth() {
        return this.layers.values().stream().mapToInt(Layer::depth).max().getAsInt();
    }

    private Optional<Layer> findLayerByDepth(final int depth) {
        return Optional.ofNullable(this.layers.get(depth));
    }

}
