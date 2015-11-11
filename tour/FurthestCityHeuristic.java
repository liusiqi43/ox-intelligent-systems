package tour;

import search.Node;
import search.NodeFunction;

public class FurthestCityHeuristic implements NodeFunction {

    // Compute the heuristic as the maximum among the sums of the distance from current city to any unvisited city C
    // and the distance between C and startCity, which is the goal city.
    // The heuristic is admissible because we relax the conditions of visiting all cities to visiting any one city
    // and return to goal city.
    // The heuristic is also consistent as we have equality if the descendant node is on the path from current city to
    // the furthest city and strictly less if the descendant node is not.
    public int getMaxUnvisitedCityCost(TourState s) {
        int maxCost = 0;
        for (City c : TourState.allCities) {
            if (!s.visitedCities.contains(c)) {
                int cost = s.currentCity.getShortestDistanceTo(c) + c.getShortestDistanceTo(TourState.startCity);
                maxCost = Math.max(maxCost, cost);
            }
        }
        return maxCost;
    }

    // compute the heuristic.
    @Override
    public int compute(Node n) {
        TourState state = (TourState) n.state;
        return getMaxUnvisitedCityCost(state);
    }
}
