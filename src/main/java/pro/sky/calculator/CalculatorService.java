package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String calculator(){
        return "<h3>This is calculator.</h3>\n" +
                "It can /plus, /minus, /multiply, /divide like /calculator/plus?num1=5&num2=5";
    }

    public String plus(int num1, int num2){
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public String minus(int num1, int num2){
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiply(int num1, int num2){
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public String divide(int num1, int num2){
        if(num2 == 0){
            return "<b>You can`t divide by zero</b>";
        }

        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}
