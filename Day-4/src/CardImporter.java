import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardImporter {
    private InputStream inputStream;

    private final boolean DEBUG = false;

    public CardImporter(String file) {
        this.inputStream = CardImporter.class.getResourceAsStream(file);
    }

    public List<Card> getCards() {
        if (inputStream == null) throw new NullPointerException("Invalid Input File");

        List<Card> cards = new ArrayList<>();
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            int id = Integer.parseInt(line.substring(4,line.indexOf(':')).trim());
            List<Integer> winningNumbers =
                    Arrays.stream(line.substring(line.indexOf(':') + 1, line.indexOf('|')).split(" "))
                    .filter(s -> !s.isEmpty() && !Character.isWhitespace(s.charAt(0)))
                    .map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
            Card card = new Card(id);
            card.addAllWinners(winningNumbers);
            Arrays.stream(line.substring(line.indexOf('|') + 1).split(" "))
                .filter(s -> !s.isEmpty() && !Character.isWhitespace(s.charAt(0)))
                .map(s -> Integer.parseInt(s.trim()))
                .forEach(card::addNumber);
            if (DEBUG) {
                System.out.println("Id: " + id);
                System.out.println("Winning Nums: " + winningNumbers);
                System.out.println("Numbers: " + card.getNumbers());
                System.out.println("Card Points: " + card.getPoints());
                System.out.println("Cards Won: " + card.getWonScratchCardsId());
            }
            cards.add(card);
        }
        return cards;
    }
}
