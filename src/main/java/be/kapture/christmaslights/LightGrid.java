package be.kapture.christmaslights;

public class LightGrid {

    private int numberOfLightsOn;

    public int getNumberOfLightsOn() {
        return numberOfLightsOn;
    }

    public void turnOn(int x1, int x2, int y1, int y2) {
        numberOfLightsOn = 1;
    }
}
