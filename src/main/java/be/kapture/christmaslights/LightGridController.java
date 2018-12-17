package be.kapture.christmaslights;

import javafx.util.Pair;

import java.awt.*;

public class LightGridController {

    private static final String TURN_ON_PREFIX = "turn on";
    private static final String TURN_OFF_PREFIX = "turn off";
    private static final String TOGGLE_PREFIX = "toggle";

    private final LightGrid lightGrid;

    public LightGridController(LightGrid lightGrid) {
        this.lightGrid = lightGrid;
    }

    public long getNumberOfLightsOn() {
        return lightGrid.getNumberOfLightsOn();
    }

    public void feedInstruction(String instruction) {
        if (instruction.startsWith(TURN_ON_PREFIX)) {
            turnOn(extractPointPair(instruction, TURN_ON_PREFIX));
        } else if (instruction.startsWith(TURN_OFF_PREFIX)) {
            turnOff(extractPointPair(instruction, TURN_OFF_PREFIX));
        } else if (instruction.startsWith(TOGGLE_PREFIX)) {
            toggle(extractPointPair(instruction, TOGGLE_PREFIX));
        }
    }

    private Pair<Point, Point> extractPointPair(String instruction, String prefix) {
        String aThroughB = instruction.substring(prefix.length() + 1);

        Point p1 = convertToPoint(extractFirstPair(aThroughB));
        Point p2 = convertToPoint(extractSecondPair(aThroughB));

        return new Pair<>(p1, p2);
    }

    private void turnOn(Pair<Point, Point> pointPair) {
        Point p1 = pointPair.getKey();
        Point p2 = pointPair.getValue();
        lightGrid.turnOn(p1.x, p1.y, p2.x, p2.y);
    }

    private void turnOff(Pair<Point, Point> pointPair) {
        Point p1 = pointPair.getKey();
        Point p2 = pointPair.getValue();
        lightGrid.turnOff(p1.x, p1.y, p2.x, p2.y);
    }

    private void toggle(Pair<Point, Point> pointPair) {
        Point p1 = pointPair.getKey();
        Point p2 = pointPair.getValue();
        lightGrid.toggle(p1.x, p1.y, p2.x, p2.y);
    }

    private String extractSecondPair(String aThroughB) {
        return aThroughB.substring(aThroughB.lastIndexOf(' ') + 1);
    }

    private String extractFirstPair(String aThroughB) {
        return aThroughB.substring(0, aThroughB.indexOf(' '));
    }

    private Point convertToPoint(String firstPair) {
        String[] point1 = firstPair.split(",");
        int x1 = Integer.parseInt(point1[0]);
        int y1 = Integer.parseInt(point1[1]);
        return new Point(x1, y1);
    }
}
