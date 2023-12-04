import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Card {

    private List<Integer> winningNumbers;
    private List<Integer> numbers;
    private int winCounter;
    private int id;
    private int points;

    public Card(int id) {
        this.winningNumbers = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.points = 0;
        this.winCounter = 0;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean addNumber(Integer number) {
        if (winningNumbers.contains(number)) {
            if (points == 0) {
                points = 1;
            } else {
                points*= 2;
            }
            winCounter++;
        }
        return numbers.add(number);
    }

    public boolean addAllWinners(Collection<? extends Integer> c) {
        return winningNumbers.addAll(c);
    }

    public int getPoints() {
        return points;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getWonScratchCardsId() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= winCounter; i++) {
            nums.add(id + i);
        }
        return nums;
    }
}
