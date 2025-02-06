import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DP {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/numbers_divide.txt";

    public static Object[][] loadNumbers() {
        List<Number[]> numbersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 3)  {
                    continue;
                }
                Number num1 = Double.parseDouble(parts[0]);
                Number num2 = Double.parseDouble(parts[1]);
                Number num3 = Double.parseDouble(parts[2]);
                numbersList.add(new Number[] {num1, num2, num3});
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return numbersList.toArray(Number[][]::new);
    }
}
