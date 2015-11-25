package mars;

import java.util.Arrays;

/**
 * Created by siqi on 11/18/15.
 */
public class Position {
    public final int x;
    public final int y;
    private final int[][] shortestDistance;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        shortestDistance = Planet.shortestDistanceForPosition(this);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int shortestDistance(Position p) {
        return shortestDistance[p.x][p.y];
    }

    public void printShortestDistance() {
        for (int[] line : shortestDistance) {
            for (int i : line) {
                System.out.printf("%5d,", i == Integer.MAX_VALUE ? -1 : i);
            }
            System.out.println();
        }
        System.out.println();
    }
}
