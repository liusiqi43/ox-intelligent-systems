package search;

/**
 * Created by siqi on 10/21/15.
 */
public interface Frontier {
    // Add node to the frontier.
    void addNode(Node node);

    // Clear all the nodes stored in the frontier.
    void clear();

    // Return true if the frontier is empty, false otherwise.
    boolean isEmpty();

    // Return the next node to explore and throws IllegalStateException if the frontier is empty.
    Node popNode() throws IllegalStateException;

    int maxNodeCount();
}
