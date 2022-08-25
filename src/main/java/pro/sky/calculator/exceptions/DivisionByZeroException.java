package pro.sky.calculator.exceptions;

public class DivisionByZeroException extends IllegalArgumentException{
    public DivisionByZeroException() {
        super("You can`t divide by zero");
    }
}
