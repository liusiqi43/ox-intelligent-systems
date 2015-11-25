package mars;

import java.util.HashSet;
import java.util.Set;

public class Planet {
    private static final int[][] accessible = new int[][]{
            {1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1},

//        {        0      },
//        		   |
//        {    0-0-0-0-0  },
//        		 |   |
//        {  0   0   0    },
//        	 |		 |
//        {0-0       0-0-0},
//           |		   |
//        {  0-0   S   0  },
//             |   |   |
//        {    0-0-0   0  },
//               | |   |
//        {      0-0-0-0  },
//        		   |
//        {        0      },
    };
    public static int accessibleCount = -1;

    public static boolean isAccessible(int x, int y) {
        int offx = x + 0;
        int offy = y + 0;
        if (offx >= 0 && offy >= 0 && offx < accessible.length && offy < accessible[0].length)
            return (accessible[offx][offy] == 0);
        else return false;
    }

    public static int getAccessibleCount() {
        if (accessibleCount > 0) return accessibleCount;

        accessibleCount = 0;
        for (int i = 0; i < accessible.length; ++i) {
            for (int j = 0; j < accessible[i].length; ++j) {
                accessibleCount += accessible[i][j] == 1 ? 0 : 1;
            }
        }
        return accessibleCount;
    }

    public static char[][] getMap() {
        char[][] map = new char[accessible.length][accessible[0].length];
        for (int i = 0; i < accessible.length; ++i) {
            for (int j = 0; j < accessible[i].length; ++j) {
                map[i][j] = accessible[i][j] == 1 ? '1' : '0';
            }
        }
        return map;
    }

    public static int[][] getAccessible() {
        return accessible;
    }

    public static Set<Position> getAccessibleNeighbors(Position p) {
        Set<Position> res = new HashSet<>();
        if (isAccessible(p.x - 1, p.y)) res.add(new Position(p.x - 1, p.y));
        if (isAccessible(p.x + 1, p.y)) res.add(new Position(p.x + 1, p.y));
        if (isAccessible(p.x, p.y + 1)) res.add(new Position(p.x, p.y + 1));
        if (isAccessible(p.x, p.y - 1)) res.add(new Position(p.x, p.y - 1));
        return res;
    }

    public int height() {
        return accessible.length;
    }

    public int width() {
        return accessible[0].length;
    }
}
