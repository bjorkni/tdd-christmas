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
        expectTotalBrightness(0);
    }

    @Test
    public void increaseOne() {
        lightGrid.increase(0, 0, 0, 0);

        expectTotalBrightness(1);
    }

    @Test
    public void increaseOneTwice() {
        lightGrid.increase(0, 0, 0, 0);
        lightGrid.increase(0, 0, 0, 0);

        expectTotalBrightness(2);
    }

    @Test
    public void increaseAll() {
        setUpAllOn();

        expectTotalBrightness(1_000_000);
    }

    private void setUpAllOn() {
        lightGrid.increase(0, 0, MAX, MAX);
    }

    @Test
    public void increaseTwoLines() {
        lightGrid.increase(0, 0, MAX, 0);
        lightGrid.increase(0, 8, MAX, 8);

        expectTotalBrightness(2000);
    }

    @Test
    public void decrease() {
        setUpAllOn();
        lightGrid.decrease(0, 0, MAX, MAX);

        expectTotalBrightness(0);
    }

    @Test
    public void decrease_noEffectWhenZero() {
        lightGrid.decrease(0, 0, MAX, MAX);

        expectTotalBrightness(0);
    }

    @Test
    public void doubleIncrease_zeroToTwo() {
        lightGrid.doubleIncrease(0, 0, MAX, MAX);

        expectTotalBrightness(2_000_000);
    }

    @Test
    public void doubleIncrease_oneToThree() {
        setUpAllOn();
        lightGrid.doubleIncrease(0, 0, MAX, MAX);

        expectTotalBrightness(3_000_000);
    }

    private void expectTotalBrightness(int ex) {
        assertThat(lightGrid.getNumberOfLightsOn()).isEqualTo(ex);
    }


}