package mars;

import search.State;

public class MapCoveringGoalTest implements search.GoalTest {
    @Override
    public boolean isGoal(State state) {
        int[][] map = Planet.getAccessible();
        Exploration ex = (Exploration) state;

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if (map[i][j] == 0 && !ex.isVisited(i, j)) return false;
            }
        }
        return true;
    }
}
