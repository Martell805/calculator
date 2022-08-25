package pro.sky.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.exceptions.DivisionByZeroException;

import java.util.stream.Stream;

public class CalculatorServiceTest {
    CalculatorService calculatorService;
    String result;
    String expected;

    @BeforeEach
    public void beforeEach(){
        this.calculatorService = new CalculatorService();
    }

    @AfterEach
    public void afterEach() {
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void plus(){
        result = calculatorService.plus(5, 3);
        expected = "5 + 3 = 8";
    }

    @Test
    public void plusZero(){
        result = calculatorService.plus(5, 0);
        expected = "5 + 0 = 5";
    }

    @Test
    public void minus(){
        result = calculatorService.minus(5, 3);
        expected = "5 - 3 = 2";
    }

    @Test
    public void minusZero(){
        result = calculatorService.minus(5, 0);
        expected = "5 - 0 = 5";
    }

    @Test
    public void multiply(){
        result = calculatorService.multiply(5, 3);
        expected = "5 * 3 = 15";
    }

    @Test
    public void multiplyZero(){
        result = calculatorService.multiply(5, 0);
        expected = "5 * 0 = 0";
    }

    @Test
    public void divide(){
        result = calculatorService.divide(5, 3);
        expected = "5 / 3 = 1";
    }

    @Test
    public void divideZero(){
        result = null;
        expected = null;

        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(5, 0));
    }

    // Parameterized tests

    public static Stream<Arguments> provideParamsForPlusTests(){
        return Stream.of(
                Arguments.of(9, 4, "9 + 4 = 13"),
                Arguments.of(9, -4, "9 + -4 = 5"),
                Arguments.of(9, 0, "9 + 0 = 9")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTests")
    public void plusParamTest(int num1, int num2, String exp){
        result = calculatorService.plus(num1, num2);
        expected = exp;
    }

    public static Stream<Arguments> provideParamsForMinusTests(){
        return Stream.of(
                Arguments.of(9, 4, "9 - 4 = 5"),
                Arguments.of(9, -4, "9 - -4 = 13"),
                Arguments.of(9, 0, "9 - 0 = 9")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTests")
    public void minusParamTest(int num1, int num2, String exp){
        result = calculatorService.minus(num1, num2);
        expected = exp;
    }

    public static Stream<Arguments> provideParamsForMultiplyTests(){
        return Stream.of(
                Arguments.of(9, 4, "9 * 4 = 36"),
                Arguments.of(9, -4, "9 * -4 = -36"),
                Arguments.of(9, 0, "9 * 0 = 0")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTests")
    public void multiplyParamTest(int num1, int num2, String exp){
        result = calculatorService.multiply(num1, num2);
        expected = exp;
    }

    public static Stream<Arguments> provideParamsForDivideTests(){
        return Stream.of(
                Arguments.of(9, 4, "9 / 4 = 2"),
                Arguments.of(9, -4, "9 / -4 = -2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTests")
    public void divideParamTest(int num1, int num2, String exp){
        result = calculatorService.divide(num1, num2);
        expected = exp;
    }
}
