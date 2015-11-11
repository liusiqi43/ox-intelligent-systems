package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by siqi on 10/21/15.
 */
public class BreadthFirstFrontier implements Frontier {
    private Queue<Node> mQueue = new LinkedList<>();
    private int mMaxNodeCount;

    @Override
    public void addNode(Node node) {
        mQueue.offer(node);
        mMaxNodeCount = Math.max(mMaxNodeCount, mQueue.size());
    }

    @Override
    public void clear() {
        mQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return mQueue.isEmpty();
    }

    @Override
    public Node popNode() throws IllegalStateException {
        if (mQueue.isEmpty())
            throw new IllegalStateException("Pop from empty BreadthFirstFrontier.");
        return mQueue.poll();
    }

    @Override
    public int maxNodeCount() {
        return mMaxNodeCount;
    }
}
