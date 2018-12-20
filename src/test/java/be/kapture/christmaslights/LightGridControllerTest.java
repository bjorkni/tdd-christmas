package be.kapture.christmaslights;

import org.junit.Before;
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
    private LightGridController controller;

    @Before
    public void setUp() {
        controller = new LightGridController(lightGrid);
    }

    @Test
    public void getNumberOfLightsOn() {
        when(lightGrid.getNumberOfLightsOn()).thenReturn(555L);

        long numberOfLightsOn = controller.getNumberOfLightsOn();

        assertThat(numberOfLightsOn).isEqualTo(555L);
    }

    @Test
    public void turnOn() {
        controller.feedInstruction("turn on 1,2 through 3,4");

        verify(lightGrid).increase(1, 2, 3, 4);
    }

    @Test
    public void turnOff() {
        controller.feedInstruction("turn off 888,999 through 666,777");

        verify(lightGrid).decrease(888, 999, 666, 777);
    }

    @Test
    public void toggle() {
        controller.feedInstruction("toggle 12,2 through 16,6");

        verify(lightGrid).doubleIncrease(12, 2, 16, 6);
    }
}