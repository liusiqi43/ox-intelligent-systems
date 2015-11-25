package search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by siqi on 10/21/15.
 */
public class GraphSearch implements Search {
    private Frontier mFrontier;
    private Set<State> mVisited = new HashSet<>();
    private int mNodeCount;

    public GraphSearch(Frontier frontier) {
        mFrontier = frontier;
    }

    private void reset() {
        mFrontier.clear();
        mVisited.clear();
        mNodeCount = 0;
    }

    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
        reset();

        mFrontier.addNode(new Node(null, null, initialConfiguration));
        mNodeCount += 1;

        while (!mFrontier.isEmpty()) {
            Node n = mFrontier.popNode();

            if (goalTest.isGoal(n.state))
                return n;

            for (Action a : n.state.getApplicableActions()) {
                State next = n.state.getActionResult(a);
                if (mVisited.contains(next)) {
                    continue;
                }
                mVisited.add(next);
                mFrontier.addNode(new Node(n, a, next));
                mNodeCount += 1;
            }
        }
        return null;
    }

    @Override
    public int maxNodeCount() {
        return mNodeCount;
    }
}
