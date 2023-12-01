import java.util.Arrays;

/**
 * Day 1 - Challenge 2
 */
public class ComplexCalibrationFile extends CalibrationFile{
    public static String[] numbers = { "zero","one","two","three","four","five","six","seven","eight","nine"};

    @Override
    public char getFirst(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (i < line.length() - 5 && Arrays.asList(numbers).contains(line.substring(i, i + 5))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+5))+'0');
            }
            if (i < line.length() - 4 && Arrays.asList(numbers).contains(line.substring(i, i + 4))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+4))+'0');
            }
            if (i < line.length() - 3 && Arrays.asList(numbers).contains(line.substring(i, i + 3))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+3))+'0');
            }
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    @Override
    public char getLast(String line) {
        for (int i = line.length() - 1; i >= 0 ; i--) {
            if (i >= 5 && Arrays.asList(numbers).contains(line.substring(i - 4, i + 1))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 4, i + 1))+'0');
            }
            if (i >= 4 && Arrays.asList(numbers).contains(line.substring(i - 3, i + 1))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 3, i + 1))+'0');
            }
            if (i >= 3 && Arrays.asList(numbers).contains(line.substring(i - 2, i + 1))){
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 2, i + 1))+'0');
            }
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }
}
