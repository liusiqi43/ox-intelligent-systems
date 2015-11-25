package mars;

import search.*;

/**
 * Created by siqi on 11/25/15.
 */
public class MarsDemo {

    public static void demo_asgs() {
        System.out.println();
        System.out.println("This is a demonstration of A* graph search on Mars with 20 battery life");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 20);

        search.GoalTest goalTest = new EmptyBatteryGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new UnvisitedPositionHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
    }

    public static void demo_asgs_cover_map() {
        System.out.println();
        System.out.println("This is a demonstration of A-star graph search on Mars for full coverage");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 0);

        search.GoalTest goalTest = new MapCoveringGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new UnvisitedPositionHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
    }

    public static void main(String[] args) {
        demo_asgs();
        demo_asgs_cover_map();
    }
}
