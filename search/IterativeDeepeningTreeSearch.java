package search;

public class IterativeDeepeningTreeSearch implements Search {
	private Frontier mFrontier = new DepthFirstFrontier();
	private int mNodeCount;
	private boolean mDone;
	
    private void reset() {
        mFrontier.clear();
        mDone = true;
    }

    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
    	int depthLimit = 0;
    	
    	while (!mDone) {
        	reset();
        	
    		mFrontier.addNode(new Node(null, null, initialConfiguration, 0));
            mNodeCount += 1;

            while (!mFrontier.isEmpty()) {
                Node n = mFrontier.popNode();

                if (goalTest.isGoal(n.state))
                    return n;

                for (Action a : n.state.getApplicableActions()) {
                	// Skip all nodes that have greater depth than depthLimit and mark the search to continue.
                	if (n.depth + 1 >= depthLimit) {
                		mDone = false;
                		continue;
                	};
                    
                    mFrontier.addNode(new Node(n, a, n.state.getActionResult(a), n.depth+1));
                    mNodeCount += 1;
                }
            }
            
            // Increase the depthLimit. 
            // If we are not done yet, search will restart with the new limit.
            depthLimit++;
    	}
        
        return null;
    }

    
	@Override
	public int maxNodeCount() {
		return mNodeCount;
	}
	
	public int maxNodeStored() {
		return mFrontier.maxNodeCount();
	}

}
