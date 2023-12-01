import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] numbers = { "zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void main(String[] args) {
        //System.out.println(getLast("jhctmxconelfkgmprnfourseven8twofkjvlvnjgd"));

        InputStream inputStream = Main.class.getResourceAsStream("input.txt");
        if (inputStream == null) return;
        Scanner sc = new Scanner(inputStream);
        int totalSum = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
         /*
            String line = "fbdqzbmjnkmqcgeight5five";
            System.out.println(line);
            line = convertLine(line);
        */
            System.out.println(line);
            String calibrationValue = String.valueOf(getFirst(line)) + getLast(line);
            System.out.println(calibrationValue);
            totalSum += Integer.parseInt(calibrationValue);

        }
        System.out.println(totalSum);

    }

    public static char getFirst(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (i < line.length() - 5 && Arrays.asList(numbers).contains(line.substring(i, i + 5))){
                //System.out.println(line.substring(i, i+5));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+5))+'0');
            }
            if (i < line.length() - 4 && Arrays.asList(numbers).contains(line.substring(i, i + 4))){
                //System.out.println(line.substring(i, i+4));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+4))+'0');
            }
            if (i < line.length() - 3 && Arrays.asList(numbers).contains(line.substring(i, i + 3))){
                //System.out.println(line.substring(i, i+3));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i, i+3))+'0');
            }
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    public static char getLast(String line) {
        for (int i = line.length() - 1; i >= 0 ; i--) {
            if (i >= 5 && Arrays.asList(numbers).contains(line.substring(i - 4, i + 1))){
                //System.out.println(line.substring(i - 5, i));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 4, i + 1))+'0');
            }
            if (i >= 4 && Arrays.asList(numbers).contains(line.substring(i - 3, i + 1))){
                //System.out.println(line.substring(i - 4, i));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 3, i + 1))+'0');
            }
            if (i >= 3 && Arrays.asList(numbers).contains(line.substring(i - 2, i + 1))){
                //System.out.println(line.substring(i - 2, i + 1));
                return (char) (Arrays.asList(numbers).indexOf(line.substring(i - 2, i + 1))+'0');
            }
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i);
            }
        }
        return ' ';
    }

    public static String convertLine(String line) {
        for (int i = numbers.length - 1; i > 0; i--) {
            line = line.replace(numbers[i], String.valueOf(i));
            //System.out.printf("replaced '%s' for '%d': %s\n",numbers[i],i, line);
        }
        return line;
    }
}