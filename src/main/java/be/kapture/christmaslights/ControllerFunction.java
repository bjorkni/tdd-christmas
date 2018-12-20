package be.kapture.christmaslights;

import javafx.util.Pair;

import java.awt.*;

@FunctionalInterface
public interface ControllerFunction {
    void apply(Pair<Point, Point> pointPair, LightGrid lightGrid);
}
