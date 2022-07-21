package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final String parameterWarning = "<h3>Missing parameter</h3>\n You need to pass two numbers";

    public String calculator(){
        return "<h3>This is calculator.</h3>\n" +
                "It can /plus, /minus, /multiply, /divide like /calculator/plus?num1=5&num2=5";
    }

    public String plus(Integer num1, Integer num2){
        if(num1 == null || num2 == null) return parameterWarning;

        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public String minus(Integer num1, Integer num2){
        if(num1 == null || num2 == null) return parameterWarning;

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiply(Integer num1, Integer num2){
        if(num1 == null || num2 == null) return parameterWarning;

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public String divide(Integer num1, Integer num2){
        if(num1 == null || num2 == null) return parameterWarning;
        if(num2 == 0) return "<b>You can`t divide by zero</b>";

        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}
