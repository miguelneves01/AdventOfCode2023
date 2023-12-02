import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Main {
    public static String file = "input.txt";

    public static void main(String[] args) {
        InputStream inputStream = Main.class.getResourceAsStream(file);
        if (inputStream == null) return;
        Scanner sc = new Scanner(inputStream);
        List<Game> games = new ArrayList<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
            String idLine = line.substring(line.indexOf("Game") + 5,line.indexOf(":"));
            int id = parseInt(idLine);
            //System.out.println(id);
            Game game = new Game(id);

            String setLine = line.substring(line.indexOf(":")+1);
            String[] sets = setLine.split(";");
            Arrays.stream(sets).forEach(
                    s -> {
                        String[] cubes = s.split(",");
                        Arrays.stream(cubes).forEach(
                                cbs -> {
                                    cbs = cbs.trim();
                                    String[] cube = cbs.split(" ");
                                    game.put(cube[1],Integer.parseInt(cube[0]));
                                }
                        );
                    }
            );

            games.add(game);
            System.out.println(game.isPossible(12,13,14));
        }
        List<Game> possibleGames = games.stream().filter(game -> game.isPossible(12,13,14)).collect(Collectors.toList());
        Integer sum = games.stream().map(Game::getId).reduce(0,Integer::sum);
        System.out.println(sum);
        Integer sumOfPower = games.stream().map(Game::getPower).reduce(0,Integer::sum);
        System.out.println(sumOfPower);
    }
}