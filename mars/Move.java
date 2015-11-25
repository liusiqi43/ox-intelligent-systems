package mars;

import search.Action;

/**
 * Created by siqi on 11/18/15.
 */
public class Move implements Action {
	public final int deltaY;
	public final int deltaX;

	Move(int deltaX, int deltaY) {
		this.deltaY = deltaY;
		this.deltaX = deltaX;
	}

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String toString() {
        return "Move {" +
                "deltaY=" + deltaY +
                ", deltaX=" + deltaX +
                '}';
    }
}
