package mars;

import search.GoalTest;
import search.State;

/**
 * Created by siqi on 11/25/15.
 */
public class EmptyBatteryGoalTest implements GoalTest {
    @Override
    public boolean isGoal(State state) {
        return ((Exploration) state).getBattery() == 0;
    }
}
