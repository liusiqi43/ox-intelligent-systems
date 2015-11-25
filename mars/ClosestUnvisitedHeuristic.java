package mars;

import search.Node;
import search.NodeFunction;

import java.util.Set;

/**
 * Created by siqi on 11/18/15.
 */
public class ClosestUnvisitedHeuristic implements NodeFunction {
    @Override
    public int compute(Node n) {
        int count = new UnvisitedPositionHeuristic().compute(n);

        int distance = Integer.MAX_VALUE;

        Exploration ex = (Exploration) n.state;

        int[][] map = Planet.getAccessible();
        for (int i=0; i<map.length; ++i) {
            for (int j=0; j<map[i].length; ++j) {
                Position to = new Position(i,j);
                if (!ex.getCurrentPosition().equals(to) &&
                        Planet.isAccessible(i,j) && !ex.getVisitedPositions().contains(to)) {
                    distance = Math.min(distance, ex.getCurrentPosition().shortestDistance(to));
                }
            }
        }
        return count + distance;
    }
}
