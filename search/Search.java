package search;

/**
 * Created by siqi on 10/21/15.
 */
public interface Search {
    // Return a node containing solution if one is found, Null otherwise.
    Node findSolution(State initialConfiguration, GoalTest goalTest);

    int maxNodeCount();
}
