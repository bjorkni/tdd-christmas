package be.kapture.christmaslights;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightGridControllerTest {

    @Test
    public void initial_allOff() {
        LightGridController controller = new LightGridController();

        assertThat(controller.getNumberOfLightsOn()).isEqualTo(0);
    }

    @Test
    public void turnOn() {
        LightGridController controller = new LightGridController();
        controller.feedInstruction("turn on 1,1 through 3,2");

        assertThat(controller.getNumberOfLightsOn()).isEqualTo(6);
    }
}