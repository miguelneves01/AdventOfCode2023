import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card(1);
    }

    @Test
    void id_Equals_1() {
        assertEquals(1,card.getId());
    }

    @Test
    void check_If_Winning_Numbers_Added() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertAll(
                () -> assertTrue(card.addAllWinners(nums)),
                () -> assertEquals(nums,card.getWinningNumbers())
        );
    }

    @Test
    void check_If_Number_Added() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        assertAll(
                () -> assertTrue(card.addNumber(1)),
                () -> assertEquals(nums,card.getNumbers())
        );
    }

    @Test
    void check_Points_When_0_Numbers_Match() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        card.addAllWinners(nums);
        assertEquals(0,card.getPoints());
    }

    @Test
    void check_Points_When_1_Number_Match() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        card.addAllWinners(nums);
        card.addNumber(1);
        assertEquals(1,card.getPoints());
    }

    @Test
    void check_Points_When_4_Numbers_Match() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        card.addAllWinners(nums);
        card.addNumber(1);
        card.addNumber(2);
        card.addNumber(3);
        card.addNumber(4);
        assertEquals(8,card.getPoints());
    }

    @Test
    void check_Won_Scratch_Cards() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        card.addAllWinners(nums);
        card.addNumber(1);
        card.addNumber(2);
        card.addNumber(3);
        card.addNumber(4);
        assertEquals(Arrays.asList(2,3,4,5),card.getWonScratchCardsId());
    }

    @Test
    void check_Won_2_Scratch_Cards() {
        card = new Card(2);
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(13, 32, 20, 16, 61));
        card.addAllWinners(nums);
        card.addNumber(61);
        card.addNumber(30);
        card.addNumber(68);
        card.addNumber(82);
        card.addNumber(17);
        card.addNumber(32);
        card.addNumber(24);
        card.addNumber(19);
        assertEquals(Arrays.asList(3,4),card.getWonScratchCardsId());
    }
}