package mars;

import search.Action;
import search.State;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by siqi on 11/18/15.
 */
public class Exploration implements State {
    private final int battery;
    private Position currentPosition;
    private Set<Position> visitedPositions;

    public Exploration(Position currentPosition, int battery) {
        this.visitedPositions = new HashSet<>();
        this.currentPosition = currentPosition;
        this.visitedPositions.add(currentPosition);
        this.battery = battery;
    }

    public Exploration(Position currentPosition, Set<Position> visitedPositions, int battery) {
        this.currentPosition = currentPosition;
        this.visitedPositions = visitedPositions;
        this.battery = battery;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getBattery() {
        return battery;
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }

    @Override
    public Set<? extends Action> getApplicableActions() {
        Set<Move> res;
        Set<Position> neighbors = Planet.getAccessibleNeighbors(currentPosition);

        Set<Move> moves = new HashSet<>();
        for (Position n : neighbors) {
            moves.add(new Move(n.x - currentPosition.x, n.y - currentPosition.y));
        }
        return moves;
    }

    @Override
    public State getActionResult(Action action) {
        Move m = (Move) action;
        Position newPos = new Position(currentPosition.x + m.deltaX, currentPosition.y + m.deltaY);
        Set<Position> visited = new HashSet<>(visitedPositions);
        visited.add(newPos);
        return new Exploration(newPos, visited, battery-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exploration that = (Exploration) o;

        if (battery != that.battery) return false;
        if (currentPosition != null ? !currentPosition.equals(that.currentPosition) : that.currentPosition != null)
            return false;
        return !(visitedPositions != null ? !visitedPositions.equals(that.visitedPositions) : that.visitedPositions != null);

    }

    @Override
    public int hashCode() {
        int result = battery;
        result = 31 * result + (currentPosition != null ? currentPosition.hashCode() : 0);
        result = 31 * result + (visitedPositions != null ? visitedPositions.hashCode() : 0);
        return result;
    }

    public boolean isVisited(int x, int y) {
        return visitedPositions.contains(new Position(x, y));
    }


}
