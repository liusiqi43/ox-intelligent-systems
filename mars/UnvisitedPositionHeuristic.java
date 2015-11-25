package mars;

import search.Node;
import search.NodeFunction;

import java.util.Set;

/**
 * Created by siqi on 11/18/15.
 */
public class UnvisitedPositionHeuristic implements NodeFunction {
    @Override
    public int compute(Node n) {
        Exploration state = (Exploration) n.state;
        Set<Position> explored = state.getVisitedPositions();

        return Planet.getAccessibleCount() - explored.size();
    }
}
