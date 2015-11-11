package search;

import java.util.Set;

public interface State {
	Set<? extends Action> getApplicableActions();

	State getActionResult(Action action);

    // Return true if two states are equal.
	boolean equals(Object other);

    // Return the hashCode for a given state.
    int hashCode();
}
