import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardImporterTest {

    CardImporter cardImporter;

    @BeforeEach
    void setUp() {
        cardImporter = new CardImporter("test.txt");
    }

    @Test
    void check_All_Cards_Imported() {
        List<Card> cards = cardImporter.getCards();
        assertAll(
                () -> assertEquals(6, cards.size()),
                () -> assertEquals(5, cards.get(0).getWinningNumbers().size()),
                () -> assertEquals(8 ,cards.get(0).getNumbers().size())
        );
    }
}