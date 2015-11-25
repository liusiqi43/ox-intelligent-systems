package search;

public class AStarFunction implements NodeFunction {
    private NodeFunction heuristic;

    public AStarFunction(NodeFunction heuristic) {
        assert (heuristic != null);
        this.heuristic = heuristic;
    }

    @Override
    public int compute(Node n) {
        assert (n != null && n.state != null);
        return n.cost + heuristic.compute(n);
    }
}
