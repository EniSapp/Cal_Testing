import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class DaysDurationCalculatorTest {
    public int dayOne, dayTwo, monthOne, monthTwo, year, expected;

    public DaysDurationCalculatorTest(int dayOne, int dayTwo, int monthOne, int monthTwo, int year, int expected) {
        this.dayOne = dayOne;
        this.dayTwo = dayTwo;
        this.monthOne = monthOne;
        this.monthTwo = monthTwo;
        this.year = year;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {{1, 2, 3, 3, 2000, 1}, {1, 2, 2, 3, 2001, 29}, {1, 2, 2, 4, 2001, 60}, {1, 2, 2, 3, 2000, 30}, {1, 2, 2, 4, 2000, 61}, {1, 2, 2, 3, 404, 30}, {1, 2, 2, 4, 404, 61}, {1, 1, 2, 2, 2000, 0}, {1, 31, 1, 12, 2001, 364}, {1, 31, 1, 12, 2000, 365}});
    }

    @Test
    public void calTest() {
        assertEquals(expected, DaysDurationCalculator.cal(monthOne, dayOne, monthTwo, dayTwo, year), "Calendar Test");
    }
}