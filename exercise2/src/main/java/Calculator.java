import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    //устанавливает количество цифр после запятой
    private final static int SCALE = 10;

    public final static int getScale() {
        return SCALE;
    };

    //сложить a и b
    public static Number add(Number a, Number b) {
        return new BigDecimal(a.toString()).add(new BigDecimal(b.toString())).stripTrailingZeros();
    }

    //из a вычесть b
    public static Number substract(Number a, Number b) {
        return new BigDecimal(a.toString()).subtract(new BigDecimal(b.toString())).stripTrailingZeros();
    }

    //умножить a на b
    public static Number multiply(Number a, Number b) {
        return new BigDecimal(a.toString()).multiply(new BigDecimal(b.toString())).stripTrailingZeros();
    }

    //поделить a на b
    //в случае, если b=0 выдается исключение ArithmeticException
    public static Number divide(Number a, Number b) throws ArithmeticException {
        if ("0".equals(b.toString())) {
            throw new ArithmeticException("на 0 делить нельзя");
        }
        return new BigDecimal(a.toString()).divide(new BigDecimal(b.toString()), SCALE, RoundingMode.CEILING).stripTrailingZeros();
    }

    //от числа a взять процент b (где b - число в %)
    public static Number getPercent(Number a, Number b) {
        return new BigDecimal(multiply(a, b).toString()).divide(new BigDecimal(100), SCALE, RoundingMode.CEILING).stripTrailingZeros();
    }

}
