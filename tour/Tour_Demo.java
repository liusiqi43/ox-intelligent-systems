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
		System.out.println();
		System.out.println("Test BFTS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Frontier bff = new BreadthFirstFrontier();
		TreeSearch ts = new TreeSearch(bff);
		Node solution = ts.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		
		System.out.println("TreeSearch: " + ts.maxNodeCount() + " nodes created.");
		System.out.println("BreadthFirstFrontier: maximum " + bff.maxNodeCount() + " nodes stored.");
	}
	
	public static void demo_bfts_default() {
		System.out.println();
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		Node solution = BreadthFirstTreeSearch.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
	}
	
	public static void demo_bfgs() {
		System.out.println();
		System.out.println("Test BFGS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Frontier bff = new BreadthFirstFrontier();
		GraphSearch gs = new GraphSearch(bff);
		Node solution = gs.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		
		System.out.println("GraphSearch: " + gs.maxNodeCount() + " nodes created.");
		System.out.println("BreadthFirstFrontier: maximum " + bff.maxNodeCount() + " nodes stored.");
	}

	public static void demo_dfts() {
		System.out.println();
		System.out.println("Test DFTS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Frontier dff = new DepthFirstFrontier();
		TreeSearch ts = new TreeSearch(dff);
		Node solution = ts.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		
		System.out.println("TreeSearch: " + ts.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + dff.maxNodeCount() + " nodes stored.");
	}
	
	public static void demo_dfgs() {
		System.out.println();
		System.out.println("Test DFGS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Frontier dff = new DepthFirstFrontier();
		GraphSearch gs = new GraphSearch(dff);
		Node solution = gs.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		
		System.out.println("GraphSearch: " + gs.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + dff.maxNodeCount() + " nodes stored.");
	}
	
	public static void demo_idts() {
		System.out.println();
		System.out.println("Test IDTS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		IterativeDeepeningTreeSearch idts = new IterativeDeepeningTreeSearch();
		Node solution = idts.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSize(solution);
		System.out.println("IterativeDeepeningTreeSearch: " + idts.maxNodeCount() + " nodes created.");
		System.out.println("DepthFirstFrontier: maximum " + idts.maxNodeStored() + " nodes stored.");
	}
	
	public static void demo_asgs() {
		System.out.println();
		System.out.println("Test ASGS: on Romania tour");
		
		Cities romania = SetUpRomania.getRomaniaMap();
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
		
		Cities romania = SetUpRomania.getRomaniaMap();
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
	
	public static void main(String[] args) {
		// demo_bfts_default();
	
		demo_asgs();
		demo_asts();

		demo_bfgs();
		demo_dfgs();
		demo_bfts();
		demo_idts();

		demo_dfts();
	}
}
