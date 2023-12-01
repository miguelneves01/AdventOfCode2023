import java.io.InputStream;
import java.util.Scanner;

public abstract class CalibrationFile {
    public static String file = "input.txt";

    public int getCalibration() {
        InputStream inputStream = Main.class.getResourceAsStream(file);
        if (inputStream == null) return 0;
        Scanner sc = new Scanner(inputStream);
        int totalSum = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String calibrationValue = String.valueOf(getFirst(line)) + getLast(line);
            totalSum += Integer.parseInt(calibrationValue);

        }
        return totalSum;
    }

    abstract char getFirst(String line);

    abstract char getLast(String line);
}
