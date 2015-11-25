package mars;

import search.Action;
import search.Printing;
import search.State;

import java.util.Arrays;

/**
 * Created by siqi on 11/25/15.
 */
public class ExplorationPrinting extends Printing {
    @Override
    public void print(Action action) {
        System.out.print(((Move) action));
    }

    @Override
    public void print(State state) {
        char[][] map = Planet.getMap();

        Exploration ex = (Exploration) state;
        for (Position p : ex.getVisitedPositions()) {
            map[p.x][p.y] = 'v';
        }

        Position curr = ex.getCurrentPosition();
        map[curr.x][curr.y] = 'c';

        for (char[] line : map) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("visited: " + ((Exploration) state).getVisitedPositions().size() + " battery left: " + ex.getBattery());
    }
}
