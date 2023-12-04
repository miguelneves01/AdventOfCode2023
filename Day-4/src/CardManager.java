import java.util.*;

public class CardManager {
    private List<Card> cards;

    public CardManager(String inputFile) {
        CardImporter cardImporter = new CardImporter(inputFile);
        this.cards = cardImporter.getCards();
    }

    public Card getCardById(int id) {
        return cards.stream().filter(card -> card.getId() == id).findFirst().get();
    }

    public int getPoints(int index) {
        return cards.get(index).getPoints();
    }

    public int getPointSum() {
        return cards.stream().map(Card::getPoints).reduce(Integer::sum).get();
    }

    public int getExtraScratchCards() {
        Queue<Card> cardQueue = new LinkedList<>();
        cardQueue.addAll(cards);
        int cardAmount = 0;
        while (!cardQueue.isEmpty()) {
            Card card = cardQueue.remove();
            cardAmount++;
            for (Integer id : card.getWonScratchCardsId()) {
                Card newCard = getCardById(id);
                if (newCard == null) continue;
                cardQueue.add(newCard);
            }
        }
        return cardAmount;
    }
}
