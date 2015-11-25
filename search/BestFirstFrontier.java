package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
    private NodeFunction costMeasure;
    private PriorityQueue<Node> priorityQueue;
    private int maxNodeCount = 0;

    public BestFirstFrontier(NodeFunction f) {
        costMeasure = f;
        priorityQueue = new PriorityQueue<Node>(32, new NodeComparator());
    }

    @Override
    public void addNode(Node node) {
        node.setValue(costMeasure.compute(node));
        priorityQueue.add(node);
        maxNodeCount = Math.max(priorityQueue.size(), maxNodeCount);
    }

    @Override
    public void clear() {
        priorityQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public Node popNode() throws IllegalStateException {
        if (priorityQueue.isEmpty())
            throw new IllegalStateException("Pop from empty BestFirstFrontier.");
        Node n = priorityQueue.poll();
        return n;
    }

    @Override
    public int maxNodeCount() {
        return maxNodeCount;
    }

    private class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getValue() - o2.getValue();
        }
    }
}
