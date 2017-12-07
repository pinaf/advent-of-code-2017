package aoc.day07;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public interface SolutionFunction<T> extends Function<StructureNode, T> {

    final class GrabName implements SolutionFunction<String> {
        @Override
        public String apply(final StructureNode node) {
            return node.program().name();
        }
    }

    final class FindImbalance implements SolutionFunction<Long> {

        @Override
        public Long apply(final StructureNode root) {
            final Optional<StructureNode> imbalance = this.findImbalance(root);
            return imbalance.map(this::calculateNeededWeight).orElse(0L);
        }

        private long calculateNeededWeight(final StructureNode node) {
            final long common = this.findCommonWeight(node);
            final StructureNode culprit = this.findChild(node, common);
            return common - culprit.weight() + culprit.program().weight();
        }

        private long findCommonWeight(final StructureNode node) {
            final Collection<Long> seen = new HashSet<>(3);
            return node.children().stream()
                .filter(child -> {
                    final long weight = child.weight();
                    final boolean match = seen.contains(weight);
                    seen.add(weight);
                    return match;
                }).map(StructureNode::weight)
                .findFirst().get();
        }

        private StructureNode findChild(final StructureNode node, final long common) {
            return node.children().stream().filter(child -> common != child.weight()).findFirst().get();
        }

        private Optional<StructureNode> findImbalance(final StructureNode node) {
            if (!node.balanced()) {
                return node.children().stream()
                    .map(this::findImbalance)
                    .filter(Optional::isPresent)
                    .findFirst().orElse(Optional.of(node));
            }
            return Optional.empty();
        }

    }

}
