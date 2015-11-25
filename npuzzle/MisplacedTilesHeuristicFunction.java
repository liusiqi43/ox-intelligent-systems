package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    @Override
    public int compute(Node n) {
        int h = 0;
        Tiles tiles = (Tiles) n.state;

        int lastTileIndex = tiles.width * tiles.width - 1;
        for (int index = lastTileIndex - 1; index >= 0; --index)
            if (tiles.tiles[index] != index + 1)
                ++h;
        return h;
    }
}
