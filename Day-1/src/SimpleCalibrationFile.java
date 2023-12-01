/**
 * Day 1 - Challenge 1
 */
public class SimpleCalibrationFile extends CalibrationFile{
    @Override
    public char getFirst(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    @Override
    public char getLast(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }
}
