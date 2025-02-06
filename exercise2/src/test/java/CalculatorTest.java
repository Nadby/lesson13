import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    // параметризованный тест
    @DisplayName("Параметризованный тест - проверка деления")
    @ParameterizedTest
    @MethodSource("DP#loadNumbers")
    public void testCalculator_Divide_CorrectResult(Number num1, Number num2, Number result) {
        assertEquals(Calculator.divide(num1, num2).doubleValue(), Math.round((double)result), Calculator.getScale());
    }
    // простой тест
    @DisplayName("Простой тест - проверка деления")
    @Test
    public void testCalculator_DivideManual_CorrectResult() {
        assertEquals(Calculator.divide(1.01, 2).doubleValue(), 0.505);
    }

    // простой тест деления на 0
    @DisplayName("Простой тест - проверка деления на 0")
    @Test
    public void testCalculator_DivideManual_ExpectedTrowsArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(1.01, 0).doubleValue();
        });
    }

}