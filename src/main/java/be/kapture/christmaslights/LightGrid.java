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
        applyToRange(x1, y1, x2, y2, turnOn());
    }

    public void turnOff(int x1, int y1, int x2, int y2) {
        applyToRange(x1, y1, x2, y2, turnOff());
    }

    public void toggle(int x1, int y1, int x2, int y2) {
        applyToRange(x1, y1, x2, y2, toggle());
    }

    private void applyToRange(int x1, int y1, int x2, int y2, GridFunction function) {
        IntStream.rangeClosed(x1, x2)
                .forEach(x -> IntStream.rangeClosed(y1, y2)
                        .forEach(y -> function.apply(x, y)));
    }

    private GridFunction turnOn() {
        return (x, y) -> grid[x][y] = true;
    }

    private GridFunction turnOff() {
        return (x, y) -> grid[x][y] = false;
    }

    private GridFunction toggle() {
        return (x, y) -> grid[x][y] = !grid[x][y];
    }
}
