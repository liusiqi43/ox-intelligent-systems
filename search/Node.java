package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public final int depth;
	// cost since the root node.
    public final int cost;
    // value used in best-first frontier.
    private int value;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = -1;
        this.cost = parent == null ? 0 : parent.cost + action.cost();
	}
	
	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
		this.cost = parent == null ? 0 : parent.cost + action.cost();
	}
	
    public void setValue(int value) {this.value = value;}

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node cost: " + cost + " value: " + value;
    }
}
