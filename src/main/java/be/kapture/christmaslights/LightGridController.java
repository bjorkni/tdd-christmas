package be.kapture.christmaslights;

import java.awt.*;

public class LightGridController {

    private final LightGrid lightGrid;

    public LightGridController() {
        lightGrid = new LightGrid();
    }

    public long getNumberOfLightsOn() {
        return lightGrid.getNumberOfLightsOn();
    }

    public void feedInstruction(String instruction) {
        String aThroughB = instruction.substring(8);

        String firstPair = aThroughB.substring(0, aThroughB.indexOf(' '));
        Point p1 = extractPoint(firstPair);

        String secondPair = aThroughB.substring(aThroughB.lastIndexOf(' ') + 1);
        Point p2 = extractPoint(secondPair);

        lightGrid.turnOn(p1.x, p1.y, p2.x, p2.y);
    }

    private Point extractPoint(String firstPair) {
        String[] point1 = firstPair.split(",");
        int x1 = Integer.parseInt(point1[0]);
        int y1 = Integer.parseInt(point1[1]);
        return new Point(x1, y1);
    }
}
