package vasouv.dietlogs.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author vasouv
 */
@Service
public class BMICalculator {

    public double calculate(double weight, double height) {
        if (height == 0.0) {
            throw new ArithmeticException("Height cannot be zero!");
        }
        return weight / Math.pow(height, 2);
    }

}
