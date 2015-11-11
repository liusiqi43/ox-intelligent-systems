// Intelligent Systems - Praticals 2
// Siqi Liu (MSc)

package tour;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.BreadthFirstTreeSearch;
import search.DepthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.Node;
import search.Search;
import search.TreeSearch;

public class Tour_Demo {
	
	public static void demo_bfts() {
	}
	
	public static void demo_bfts_default() {
	}
	
	public static void demo_bfgs() {
	}

	public static void demo_dfts() {
	}
	
	public static void demo_dfgs() {
	}
	
	public static void demo_idts() {
	}
	
	public static void demo_asgs() {
		System.out.println();
		System.out.println("Test ASGS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		TourState.allCities = romania.getAllCities();
		TourState.startCity = startCity;
		
		Frontier f = new BestFirstFrontier(new AStarFunction(new FurthestCityHeuristic()));
		Search s = new GraphSearch(f);
		Node solution = s.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		System.out.println("A Star Graph Search: " + s.maxNodeCount() + " nodes created.");
		System.out.println("BestFirstFrontier: maximum " + f.maxNodeCount() + " nodes stored.");
	}
	
	public static void demo_asts() {
		System.out.println();
		System.out.println("Test ASTS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		TourState.allCities = romania.getAllCities();
		TourState.startCity = startCity;
		
		Frontier f = new BestFirstFrontier(new AStarFunction(new FurthestCityHeuristic()));
		Search s = new TreeSearch(f);
		Node solution = s.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		System.out.println("A Star Tree Search: " + s.maxNodeCount() + " nodes created.");
		System.out.println("BestFirstFrontier: maximum " + f.maxNodeCount() + " nodes stored.");
	}

	/*
     * This is a demonstration of breadth-first tree search on Romania tour
     * Solution length: 13
     * 
     * Test ASGS: on Romania tour
     * Solution length: 13
     * A Star Graph Search: 145 nodes created.
     * BestFirstFrontier: maximum 74 nodes stored.
     * 
     * Test ASTS: on Romania tour
     * Solution length: 13
     * A Star Tree Search: 241 nodes created.
     * BestFirstFrontier: maximum 146 nodes stored.
     * 
     * Test BFGS: on Romania tour
     * Solution length: 13
     * GraphSearch: 947 nodes created.
     * BreadthFirstFrontier: maximum 186 nodes stored.
     * 
     * Test DFGS: on Romania tour
     * Solution length: 31
     * GraphSearch: 62 nodes created.
     * DepthFirstFrontier: maximum 19 nodes stored.
     * 
     * Test BFTS: on Romania tour
     * Solution length: 13
     * TreeSearch: 75973 nodes created.
     * BreadthFirstFrontier: maximum 44217 nodes stored.
     * 
     * Test IDTS: on Romania tour
     * Solution length: 13
     * IterativeDeepeningTreeSearch: 41637 nodes created.
     * DepthFirstFrontier: maximum 22 nodes stored.
     * 
     * Test DFTS: on Romania tour
     * N/A
     *
     * It is fairly straightforward that informed search strategy such as A*
     * allows us to search much more efficiently. Both in terms of memory and
     * in time. ASGS, as observed in praticals 1, is also more efficient 
     * as it does not repeatly visit certain nodes while it does need to keep
     * track of visited nodes hence requires more memory space.
     *
     * On large Romania map:
     * Test ASGS: on Romania tour
     * Solution length: 29
     * A Star Graph Search: 23510 nodes created.
     * BestFirstFrontier: maximum 7248 nodes stored.
     */
	public static void main(String[] args) {
		demo_bfts_default();
	
		demo_asgs();
		demo_asts();

		demo_bfgs();
		demo_dfgs();
		demo_bfts();
		demo_idts();

		demo_dfts();
	}
}



// Action.java
package search;

public interface Action {
    public int cost();
}

// AStarFunction.java
package search;

public class AStarFunction implements NodeFunction {
    private NodeFunction heuristic;

    public AStarFunction(NodeFunction heuristic) {
        assert(heuristic != null);
        this.heuristic = heuristic;
    }

    @Override
    public int compute(Node n) {
        assert(n != null && n.state != null);
        return n.cost + heuristic.compute(n);
    }
}

// BestFirstFrontier
package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
    private NodeFunction costMeasure;
    private PriorityQueue<Node> priorityQueue;
    private int maxNodeCount = 0;

    // Ascending order by Value.
    private class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getValue() - o2.getValue();
        }
    }

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
}

// Node.java
package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public final int depth;
	// cost since the root node.
    public final int cost;
    // value used in best-first frontier.
    private int value;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = -1;
        this.cost = parent == null ? 0 : parent.cost + action.cost();
	}
	
	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
		this.cost = parent == null ? 0 : parent.cost + action.cost();
	}
	
    public void setValue(int value) {this.value = value;}

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node cost: " + cost + " value: " + value;
    }
}

// NodeFunction.java
package search;

public interface NodeFunction {
    public int compute(Node n);
}


// FurthestCityHeuristic.java
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



/**
 * N-Puzzle
 */

// NPuzzle_Demo.java
package npuzzle;

import search.*;

public class NPuzzle_Demo {
	public static void demo_bfts_default() {
	}

	public static void demo_bfts() {
	}

	public static void demo_dfts() {
	}

	public static void demo_dfgs() {
	}

	public static void demo_bfgs() {
	}
	

	public static void demo_idts() {
	}
	
	private static void demo_asgs() {
		System.out.println();
		System.out.println("Test: ASGS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		Frontier f = new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction()));
		Search s = new GraphSearch(f);
		Node solution = s.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("GraphSearch: " + s.maxNodeCount() + " nodes created.");
		System.out.println("BestFirstFrontier: maximum " + f.maxNodeCount() + " nodes stored.");
	}

	private static void demo_asts() {
		System.out.println();
		System.out.println("Test: ASTS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		Frontier f = new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction()));
		Search s = new TreeSearch(f);
		Node solution = s.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("TreeSearch: " + s.maxNodeCount() + " nodes created.");
		System.out.println("BestFirstFrontier: maximum " + f.maxNodeCount() + " nodes stored.");
	}

    /**
     *
     * This is a demonstration of breadth-first tree search on 8-puzzle
     * Solution length: 14
     * 
     * Test: ASGS on 8-puzzle
     * Solution length: 14
     * GraphSearch: 190 nodes created.
     * BestFirstFrontier: maximum 82 nodes stored.
     * 
     * Test: ASTS on 8-puzzle
     * Solution length: 14
     * TreeSearch: 964 nodes created.
     * BestFirstFrontier: maximum 613 nodes stored.
     * 
     * Test: BFTS on 8-puzzle
     * Solution length: 14
     * TreeSearch: 2298274 nodes created.
     * BreadthFirstFrontier: maximum 1473871 nodes stored.
     * 
     * Test: BFGS on 8-puzzle
     * Solution length: 14
     * GraphSearch: 4360 nodes created.
     * BreadthFirstFrontier: maximum 1592 nodes stored.
     * 
     * Test: IDTS on 8-puzzle
     * Solution length: 14
     * IterativeDeepeningTreeSearch: 1211855 nodes created.
     * DepthFirstFrontier: maximum 25 nodes stored.
     * 
     * Test: DFGS on 8-puzzle
     * Solution length: 18912
     * GraphSearch: 34267 nodes created.
     * DepthFirstFrontier: maximum 14480 nodes stored.
     * 
     * Test: DFTS on 8-puzzle
     * N/A
     *
     * It is obvious that informed search strategy such as A* greatly improved
     * the efficiency of the program, both in terms of memory and in time. 
     * ASGS is also more efficient in terms of the number of nodes explored and
     * stored by keeping track of visited nodes.
     */
	public static void main(String[] args) {
		demo_bfts_default();

		demo_asgs();
		demo_asts();
		
		demo_bfts();
		demo_bfgs();

		demo_idts();

		demo_dfgs();
		demo_dfts();

	}
}


// MisplacedTilesHeuristicFunction.java
package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    @Override
    public int compute(Node n) {
        int h = 0;
        Tiles tiles = (Tiles) n.state;
        
        int lastTileIndex = tiles.width * tiles.width - 1;
		for (int index = lastTileIndex - 1; index >=0; --index)
			if (tiles.tiles[index] != index + 1)
                ++h;
        return h;
    }
}

// Movement.java
package npuzzle;

import search.Action;

public enum Movement implements Action {
        ...
	@Override
	public int cost() {
		return 1;
	}
}
