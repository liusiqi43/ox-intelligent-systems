package search;

import java.util.Stack;

/**
 * Created by siqi on 10/21/15.
 */
public class DepthFirstFrontier implements Frontier {
    private Stack<Node> mStack = new Stack<>();
    private int mMaxNodeCount;

    @Override
    public void addNode(Node node) {
        mStack.push(node);
        mMaxNodeCount = Math.max(mMaxNodeCount, mStack.size());
    }

    @Override
    public void clear() {
        mStack.clear();
    }

    @Override
    public boolean isEmpty() {
        return mStack.isEmpty();
    }

    @Override
    public Node popNode() throws IllegalStateException {
        if (mStack.isEmpty())
            throw new IllegalStateException("Pop from empty DepthFirstFrontier.");
        return mStack.pop();
    }

    @Override
    public int maxNodeCount() {
        return mMaxNodeCount;
    }
}
