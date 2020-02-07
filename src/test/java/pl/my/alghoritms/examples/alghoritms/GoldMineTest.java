package pl.my.alghoritms.examples.alghoritms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldMineTest {

    @Test
    void getMaxGold_should_be_12() {
        // given
        int[][] mine = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
        GoldMine goldMine = new GoldMine(mine);

        // then
        assertEquals(12, goldMine.getMaxGold());
    }

    @Test
    void getMaxGold_should_be_9() {
        //given
        int[][] mine = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };
        GoldMine goldMine = new GoldMine(mine);

        // then
        assertEquals(9, goldMine.getMaxGold());
    }

    @Test
    void getMaxGold_should_be_15() {
        //given
        int[][] mine = {
                {1, 1, 5},
                {2, 5, 2},
                {5, 3, 3}
        };
        GoldMine goldMine = new GoldMine(mine);

        // then
        assertEquals(15, goldMine.getMaxGold());
    }
}