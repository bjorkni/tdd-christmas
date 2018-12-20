package be.kapture.christmaslights;

import javafx.util.Pair;

import java.awt.*;

public class LightGridController {

    private final LightGrid lightGrid;

    public LightGridController(LightGrid lightGrid) {
        this.lightGrid = lightGrid;
    }

    public long getNumberOfLightsOn() {
        return lightGrid.getNumberOfLightsOn();
    }

    public void feedInstruction(String instruction) {
        for (InstructionType instructionType : InstructionType.values()) {
            if (instruction.startsWith(instructionType.getPrefix())) {
                Pair<Point, Point> pointPair = extractPointPair(instruction, instructionType.getPrefix());
                instructionType.getControllerFunction().apply(pointPair, lightGrid);
            }
        }
    }

    private Pair<Point, Point> extractPointPair(String instruction, String prefix) {
        String aThroughB = instruction.substring(prefix.length() + 1);

        Point p1 = convertToPoint(extractFirstPair(aThroughB));
        Point p2 = convertToPoint(extractSecondPair(aThroughB));

        return new Pair<>(p1, p2);
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
