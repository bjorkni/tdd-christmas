package be.kapture.christmaslights;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LightGrid {

    private static final int GRID_SIZE = 1000;

    private int[][] grid = new int[GRID_SIZE][GRID_SIZE];

    public long getNumberOfLightsOn() {
        return IntStream.range(0, GRID_SIZE)
                .mapToLong(x ->
                        Arrays.stream(grid[x], 0, GRID_SIZE)
                                .sum())
                .sum();
    }

    public void increase(int x1, int y1, int x2, int y2) {
        applyToRange(x1, y1, x2, y2, increase());
    }

    public void decrease(int x1, int y1, int x2, int y2) {
        applyToRange(x1, y1, x2, y2, decrease());
    }

    public void doubleIncrease(int x1, int y1, int x2, int y2) {
        applyToRange(x1, y1, x2, y2, doubleIncrease());
    }

    private void applyToRange(int x1, int y1, int x2, int y2, GridFunction function) {
        IntStream.rangeClosed(x1, x2)
                .forEach(x -> IntStream.rangeClosed(y1, y2)
                        .forEach(y -> function.apply(x, y)));
    }

    private GridFunction increase() {
        return (x, y) -> grid[x][y]++;
    }

    private GridFunction decrease() {
        return (x, y) -> grid[x][y] = Math.max(0, grid[x][y] - 1);
    }

    private GridFunction doubleIncrease() {
        return (x, y) -> grid[x][y] = grid[x][y] + 2;
    }
}
