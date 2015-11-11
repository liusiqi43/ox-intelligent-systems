package npuzzle;

import search.*;

public class NPuzzle_Demo {
	public static void demo_bfts_default() {
		System.out.println();
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		Node solution = BreadthFirstTreeSearch.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
	}

	public static void demo_bfts() {
		System.out.println();
		System.out.println("Test: BFTS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		
		Frontier bff = new BreadthFirstFrontier();
		TreeSearch ts = new TreeSearch(bff);
		Node solution = ts.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("TreeSearch: " + ts.maxNodeCount() + " nodes created.");
		System.out.println("BreadthFirstFrontier: maximum " + bff.maxNodeCount() + " nodes stored.");
	}

	public static void demo_dfts() {
		System.out.println();
		System.out.println("Test: DFTS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		
		Frontier dff = new DepthFirstFrontier();
		TreeSearch ts = new TreeSearch(dff);
		Node solution = ts.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("TreeSearch: " + ts.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + dff.maxNodeCount() + " nodes stored.");
	}

	public static void demo_dfgs() {
		System.out.println();
		System.out.println("Test: DFGS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		
		Frontier dff = new DepthFirstFrontier();
		GraphSearch gs = new GraphSearch(dff);
		Node solution = gs.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("GraphSearch: " + gs.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + dff.maxNodeCount() + " nodes stored.");
	}

	public static void demo_bfgs() {
		System.out.println();
		System.out.println("Test: BFGS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		
		Frontier bff = new BreadthFirstFrontier();
		GraphSearch gs = new GraphSearch(bff);
		Node solution = gs.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("GraphSearch: " + gs.maxNodeCount() + " nodes created.");
		System.out.println("BreadthFirstFrontier: maximum " + bff.maxNodeCount() + " nodes stored.");
	}
	

	public static void demo_idts() {
		System.out.println();
		System.out.println("Test: IDTS on 8-puzzle");

		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
		IterativeDeepeningTreeSearch idts = new IterativeDeepeningTreeSearch();
		Node solution = idts.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSize(solution);
		System.out.println("IterativeDeepeningTreeSearch: " + idts.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + idts.maxNodeStored() + " nodes stored.");
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
