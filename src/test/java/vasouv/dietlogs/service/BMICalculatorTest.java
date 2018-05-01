package vasouv.dietlogs.service;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vasou
 */
public class BMICalculatorTest {

    BMICalculator calculator = new BMICalculator();

    @Test
    public void weightZeroReturnsZero() {
        assertEquals(0.0, calculator.calculate(0, 1.75), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void heightZeroThrowsException() {
        double error = calculator.calculate(76.5, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void bothZeroThrowsException() {
        double error = calculator.calculate(0, 0);
    }

}
