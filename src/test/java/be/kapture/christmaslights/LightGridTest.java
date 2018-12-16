package be.kapture.christmaslights;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightGridTest {

    private static final int MAX = 999;

    private LightGrid lightGrid;

    @Before
    public void setUp() {
        lightGrid = new LightGrid();
    }

    @Test
    public void initialState_allOff() {
        expectOn(0);
    }

    @Test
    public void turnOnOne() {
        lightGrid.turnOn(0, 0, 0, 0);

        expectOn(1);
    }

    @Test
    public void turnOnAll() {
        setUpAllOn();

        expectOn(1_000_000);
    }

    private void setUpAllOn() {
        lightGrid.turnOn(0, 0, MAX, MAX);
    }

    @Test
    public void turnOnTwoLines() {
        lightGrid.turnOn(0, 0, MAX, 0);
        lightGrid.turnOn(0, 8, MAX, 8);

        expectOn(2000);
    }

    @Test
    public void turnOff() {
        setUpAllOn();
        lightGrid.turnOff(0, 0, MAX, MAX);

        expectOn(0);
    }

    @Test
    public void toggle_offToOn() {
        lightGrid.toggle(0, 0, MAX, MAX);

        expectOn(1_000_000);
    }

    @Test
    public void toggle_onToOff() {
        setUpAllOn();
        lightGrid.toggle(0, 0, MAX, MAX);

        expectOn(0);
    }

    private void expectOn(int ex) {
        assertThat(lightGrid.getNumberOfLightsOn()).isEqualTo(ex);
    }


}