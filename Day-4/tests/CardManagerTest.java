import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardManagerTest {

    private CardManager manager;

    @BeforeEach
    void setUp() {
        manager = new CardManager("test.txt");
    }

    @Test
    void check_Points_Of_1st_Card() {
        assertEquals(8,manager.getPoints(0));
    }

    @Test
    void check_Total_Points_Sum() {
        assertEquals(13, manager.getPointSum());
    }

    @Test
    void check_Total_Card_Amount() {
        assertEquals(30, manager.getExtraScratchCards());
    }
}