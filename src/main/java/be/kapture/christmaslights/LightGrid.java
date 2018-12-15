package be.kapture.christmaslights;

import java.util.stream.IntStream;

public class LightGrid {

    private static final int GRID_SIZE = 1000;

    private boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE];

    public long getNumberOfLightsOn() {
        return IntStream.range(0, GRID_SIZE)
                .mapToLong(x ->
                        IntStream.range(0, GRID_SIZE)
                                .mapToObj(y -> grid[x][y])
                                .filter(Boolean::booleanValue)
                                .count())
                .sum();

    }

    public void turnOn(int x1, int y1, int x2, int y2) {
        IntStream.rangeClosed(x1, x2)
                .forEach(x -> IntStream.rangeClosed(y1, y2)
                        .forEach(y -> grid[x][y] = true));
    }
}
