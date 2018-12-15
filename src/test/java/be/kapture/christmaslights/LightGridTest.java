package be.kapture.christmaslights;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightGridTest {

    @Test
    public void initialState_allOff() {
        LightGrid lightGrid = new LightGrid();

        assertThat(lightGrid.getNumberOfLightsOn()).isEqualTo(0);
    }

    @Test
    public void turnOnOne() {
        LightGrid lightGrid = new LightGrid();

        lightGrid.turnOn(0, 0, 1, 1);

        assertThat(lightGrid.getNumberOfLightsOn()).isEqualTo(1);
    }
}