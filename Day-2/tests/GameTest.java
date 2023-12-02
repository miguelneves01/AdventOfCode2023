import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    public Game game;

    @BeforeEach
    void setUp() {
        game = new Game(1);
        game.put("blue", 4);
        game.put("green", 2);
        game.put("red", 6);
    }

    @Test
    void Assert_getId_Equals_1() {
        assertEquals(1, game.getId());
    }

    @Test
    void Assert_Put_Sets_The_Max_Value() {
        game.put("blue", 1);
        game.put("blue", 0);
        game.put("blue", 5);
        game.put("blue", 2);
        assertEquals(5, game.get("blue"));
    }

    @Test
    void Check_Game_Is_Not_Possible_When_Values_Bellow() {
        assertFalse(game.isPossible(4,4,4));
    }

    @Test
    void Assert_Power_Equals_48() {
        assertEquals(48,game.getPower());
    }
}