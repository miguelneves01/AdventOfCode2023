import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Chalenge 1
        CalibrationFile calibrationFile = new SimpleCalibrationFile();
        System.out.println(calibrationFile.getCalibration());
        //Chalenge 2
        calibrationFile = new ComplexCalibrationFile();
        System.out.println(calibrationFile.getCalibration());
    }
}