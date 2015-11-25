package search;

/**
 * Created by siqi on 10/21/15.
 */
public class TreeSearch implements Search {
    private Frontier mFrontier;
    private int mNodeCount;

    public TreeSearch(Frontier frontier) {
        mFrontier = frontier;
    }

    private void reset() {
        mFrontier.clear();
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
                mFrontier.addNode(new Node(n, a, n.state.getActionResult(a), n.depth + 1));
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
