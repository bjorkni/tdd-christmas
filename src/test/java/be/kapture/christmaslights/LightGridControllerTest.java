package be.kapture.christmaslights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LightGridControllerTest {

    @Mock
    private LightGrid lightGrid;

    @Test
    public void getNumberOfLightsOn() {
        when(lightGrid.getNumberOfLightsOn()).thenReturn(555L);
        LightGridController controller = new LightGridController(lightGrid);

        long numberOfLightsOn = controller.getNumberOfLightsOn();

        assertThat(numberOfLightsOn).isEqualTo(555L);
    }

    @Test
    public void turnOn() {
        LightGridController controller = new LightGridController(lightGrid);

        controller.feedInstruction("turn on 1,2 through 3,4");

        verify(lightGrid).turnOn(1, 2, 3, 4);
    }

    @Test
    public void turnOff() {
        LightGridController controller = new LightGridController(lightGrid);

        controller.feedInstruction("turn off 888,999 through 666,777");

        verify(lightGrid).turnOff(888, 999, 666, 777);
    }

    @Test
    public void toggle() {
        LightGridController controller = new LightGridController(lightGrid);

        controller.feedInstruction("toggle 12,2 through 16,6");

        verify(lightGrid).toggle(12, 2, 16, 6);
    }
}