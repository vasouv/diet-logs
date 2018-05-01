package vasouv.dietlogs.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author vasouv
 */
@Service
public class BMICalculator {

    public double calculate(double weight, double height) {
        return weight / Math.pow(height, 2);
    }

}
