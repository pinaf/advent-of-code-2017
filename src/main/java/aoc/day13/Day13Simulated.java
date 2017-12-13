package aoc.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day13Simulated implements Challenge<List<Layer>> {

    private final boolean halt;

    private final Map<Integer, Layer> layers;

    Day13Simulated(final boolean halt) {
        this(halt, new StdInput(13).read());
    }

    Day13Simulated(final boolean halt, final String input) {
        this(
            halt,
            Arrays.stream(input.split("\n"))
                .map(Layer.Default::new)
                .collect(Collectors.toMap(Layer::depth, layer -> layer))
        );
    }

    public void resetAnddelay(final long delay) {
        this.layers.values().forEach(layer -> {
            layer.reset();
            layer.tick(delay);
        });
    }

    @Override
    public List<Layer> run() {
        return this.caughtLayers(this.lastDepth());
    }

    private List<Layer> caughtLayers(final int max) {
        final List<Layer> catches = new ArrayList<>(this.layers.size());
        for (int depth = 0; depth <= max; ++depth) {
            final Optional<Layer> match = this.layerAtDepth(depth);
            if (match.isPresent()) {
                final Layer layer = match.get();
                if (layer.scanner() == 0) {
                    catches.add(layer);
                    if (this.halt) {
                        return catches;
                    }
                }
            }
            this.tick();
        }
        return catches;
    }

    private void tick() {
        this.layers.values().forEach(Layer::tick);
    }

    private int lastDepth() {
        return this.layers.values().stream().mapToInt(Layer::depth).max().getAsInt();
    }

    private Optional<Layer> layerAtDepth(final int depth) {
        return Optional.ofNullable(this.layers.get(depth));
    }

}
