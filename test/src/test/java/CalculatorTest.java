import exercise1.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    // параметризованный тест
    @Test(dataProvider = "calculator", dataProviderClass = DP.class, groups = "add")
    public void testCalculator_Add_CorrectResult(Number num1, Number num2, Number result) {
        Assert.assertEquals(Calculator.add(num1, num2).doubleValue(), (double)result);
    }
    // простой тест
    @Test
    public void testCalculator_AddManual_CorrectResult() {
        Assert.assertEquals(Calculator.add(1.00001, 0.00005).doubleValue(), 1.00006);
    }

}