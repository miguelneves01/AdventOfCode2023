import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String file = "input.txt";

    public static void main(String[] args) {
        InputStream inputStream = Main.class.getResourceAsStream(file);
        if (inputStream == null) return;
        Scanner sc = new Scanner(inputStream);
        int height = 0;
        int width = 0;
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            height++;
            String line = sc.nextLine();
            System.out.println(line);
            lines.add(line);
            if (width == 0) width = line.length();
        }
        char[][] inputMatrix = new char[height][width];
        int counter = 0;
        for (String line : lines) {
            for (int j = 0; j < width; j++) {
                inputMatrix[counter][j] = line.charAt(j);
            }
            counter++;
        }

        List<Number> adjacentNumbers = findEverySymbolAdjacentNumber(inputMatrix);
        System.out.println(adjacentNumbers.stream().map(Number::getValue).reduce(Integer::sum));
        System.out.println(findGearRatio(inputMatrix));
    }

    public static int findGearRatio(char[][] inputMatrix) {
        int height = inputMatrix.length;
        int width = inputMatrix[0].length;

        int sum = 0;

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {

                char ch = inputMatrix[i][j];
                if (ch != '*' || Character.isDigit(ch)) {
                    continue;
                }
                List<Number> adjacentNumbers = new ArrayList<>();

                if (i > 0 && Character.isDigit(inputMatrix[i - 1][j])) {
                    //System.out.println(ch + " Up: " + (i - 1) + ":" + j);
                    Number num = getFullNumber(i - 1, j, inputMatrix);
                    adjacentNumbers.add(num);
                } else {

                    if (i > 0 && j > 0 && Character.isDigit(inputMatrix[i - 1][j - 1])) {
                        //System.out.println(ch + " Up Left: " + (i - 1) + ":" + (j - 1));
                        Number num = getFullNumber(i - 1, j - 1, inputMatrix);
                        adjacentNumbers.add(num);
                    }

                    if (j < width - 1 && Character.isDigit(inputMatrix[i - 1][j + 1])) {
                        //System.out.println(ch + " Up Right: " + (i - 1) + ":" + (j + 1));
                        Number num = getFullNumber(i - 1, j + 1, inputMatrix);
                        adjacentNumbers.add(num);

                    }

                }

                if (i < height - 1 && Character.isDigit(inputMatrix[i + 1][j])) {
                    //System.out.println(ch + " Down: " + (i + 1) + ":" + j);
                    Number num = getFullNumber(i + 1, j, inputMatrix);
                    adjacentNumbers.add(num);
                } else {
                    if (i < height - 1 && j < width - 1 && Character.isDigit(inputMatrix[i + 1][j + 1])) {
                        //System.out.println(ch + " Down Right: " + (i + 1) + ":" + (j + 1));
                        Number num = getFullNumber(i + 1, j + 1, inputMatrix);
                        adjacentNumbers.add(num);
                    }
                    if (j > 0 && Character.isDigit(inputMatrix[i + 1][j - 1])) {
                        //System.out.println(ch + " Down Left: " + (i + 1) + ":" + (j - 1));
                        Number num = getFullNumber(i + 1, j - 1, inputMatrix);
                        adjacentNumbers.add(num);
                    }
                }

                if (j > 0 && Character.isDigit(inputMatrix[i][j - 1])) {
                    //System.out.println(ch + " Left: " + (i) + ":" + (j - 1));
                    Number num = getFullNumber(i, j - 1, inputMatrix);
                    adjacentNumbers.add(num);
                }
                if (j < width - 1 && Character.isDigit(inputMatrix[i][j + 1])) {
                    //System.out.println(ch + " Right: " + (i) + ":" + (j + 1));
                    Number num = getFullNumber(i, j + 1, inputMatrix);
                    adjacentNumbers.add(num);
                }

                if (adjacentNumbers.size() == 2) {
                    sum+= adjacentNumbers.get(0).getValue() * adjacentNumbers.get(1).getValue();
                }
            }
        return sum;
    }

    public static List<Number> findEverySymbolAdjacentNumber(char[][] inputMatrix) {
        int height = inputMatrix.length;
        int width = inputMatrix[0].length;
        List<Number> adjacentNumbers = new ArrayList<>();

        for (int i = 0; i < height; i++)
        for (int j = 0; j < width; j++) {

            char ch = inputMatrix[i][j];
            if (ch == '.' || Character.isDigit(ch)) {
                continue;
            }

            if (i > 0 && Character.isDigit(inputMatrix[i - 1][j])) {
                //System.out.println(ch + " Up: " + (i - 1) + ":" + j);
                Number num = getFullNumber(i - 1, j, inputMatrix);
                if (!adjacentNumbers.contains(num)) {
                    adjacentNumbers.add(num);
                }
            } else {

                if (i > 0 && j > 0 && Character.isDigit(inputMatrix[i - 1][j - 1])) {
                    //System.out.println(ch + " Up Left: " + (i - 1) + ":" + (j - 1));
                    Number num = getFullNumber(i - 1, j - 1, inputMatrix);
                    if (!adjacentNumbers.contains(num)) {
                        adjacentNumbers.add(num);
                    }
                }

                if (j < width - 1 && Character.isDigit(inputMatrix[i - 1][j + 1])) {
                    //System.out.println(ch + " Up Right: " + (i - 1) + ":" + (j + 1));
                    Number num = getFullNumber(i - 1, j + 1, inputMatrix);
                    if (!adjacentNumbers.contains(num)) {
                        adjacentNumbers.add(num);
                    }
                }

            }

            if (i < height - 1 && Character.isDigit(inputMatrix[i + 1][j])) {
                //System.out.println(ch + " Down: " + (i + 1) + ":" + j);
                Number num = getFullNumber(i + 1, j, inputMatrix);
                if (!adjacentNumbers.contains(num)) {
                    adjacentNumbers.add(num);
                }
            } else {
                if (i < height - 1 && j < width - 1 && Character.isDigit(inputMatrix[i + 1][j + 1])) {
                    //System.out.println(ch + " Down Right: " + (i + 1) + ":" + (j + 1));
                    Number num = getFullNumber(i + 1, j + 1, inputMatrix);
                    if (!adjacentNumbers.contains(num)) {
                        adjacentNumbers.add(num);
                    }
                }
                if (j > 0 && Character.isDigit(inputMatrix[i + 1][j - 1])) {
                    //System.out.println(ch + " Down Left: " + (i + 1) + ":" + (j - 1));
                    Number num = getFullNumber(i + 1, j - 1, inputMatrix);
                    if (!adjacentNumbers.contains(num)) {
                        adjacentNumbers.add(num);
                    }
                }
            }

            if (j > 0 && Character.isDigit(inputMatrix[i][j - 1])) {
                //System.out.println(ch + " Left: " + (i) + ":" + (j - 1));
                Number num = getFullNumber(i, j - 1, inputMatrix);
                if (!adjacentNumbers.contains(num)) {
                    adjacentNumbers.add(num);
                }
            }
            if (j < width - 1 && Character.isDigit(inputMatrix[i][j + 1])) {
                //System.out.println(ch + " Right: " + (i) + ":" + (j + 1));
                Number num = getFullNumber(i, j + 1, inputMatrix);
                if (!adjacentNumbers.contains(num)) {
                    adjacentNumbers.add(num);
                }
            }
        }
        return adjacentNumbers;
    }

    public static Number getFullNumber(int y, int x, char[][] matrix) {
        char[] line = matrix[y];
        int start = x;
        int end = x;
        while (start > 0 && Character.isDigit(line[start-1])){
            start--;
        }
        while (end < line.length - 1 && Character.isDigit(line[end + 1])){
            end++;
        }

        Number number = new Number(Integer.parseInt(String.valueOf(line).substring(start,end+1)));
        number.setCoordinates(start,end, y);
        return number;
    }
}