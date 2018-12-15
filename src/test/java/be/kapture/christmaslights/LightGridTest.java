package be.kapture.christmaslights;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightGridTest {

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
        lightGrid.turnOn(0, 0, 999, 999);

        expectOn(1_000_000);
    }

    @Test
    public void turnOnTwoLines() {
        lightGrid.turnOn(0, 0, 999, 0);
        lightGrid.turnOn(0, 8, 999, 8);

        expectOn(2000);
    }

    private void expectOn(int ex) {
        assertThat(lightGrid.getNumberOfLightsOn()).isEqualTo(ex);
    }


}