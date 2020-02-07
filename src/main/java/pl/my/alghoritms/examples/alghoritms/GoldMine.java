package pl.my.alghoritms.examples.alghoritms;

/**
 * Problem:
 * Given a gold mine of n*m dimensions.
 * Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\)
 * that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down
 * towards the right. Find out maximum amount of gold he can collect.
 */
public class GoldMine {
    private final int[][] mine;
    public GoldMine(int[][] mine) {
        this.mine =mine;
    }

    int getMaxGold() {
        int gold = 0;
        for (int row = 0; row < mine.length; row++) {
            int tempGold = getRecursiveGold(mine[row][0], row, 1);
            if (tempGold > gold) {
                gold = tempGold;
            }
        }
        return gold;
    }

    private int getRecursiveGold(int tempGold, int row, int col) {
        int amountMoveRight = 0;
        int amountMoveRightUp = 0;
        int amountMoveRightDown = 0;

        if (col == mine[0].length - 1) {
            return mine[row][col];
        }

        if (col < mine[0].length - 1) {
            amountMoveRight = tempGold + mine[row][col];
            amountMoveRight = amountMoveRight + getRecursiveGold(amountMoveRight, row, col + 1);
        }

        if (row > 0) {
            amountMoveRightUp = tempGold + mine[row-1][col];
            if(row > 1) {
                amountMoveRightUp = amountMoveRightUp + getRecursiveGold(amountMoveRightUp, row-2, col+1);
            } else {
                amountMoveRightUp = amountMoveRightUp + getRecursiveGold(amountMoveRightUp, row-1, col+1);
            }

        }

        if (row < mine.length - 1) {
            amountMoveRightDown = tempGold + mine[row+1][col];
            amountMoveRightDown = amountMoveRightDown + getRecursiveGold(amountMoveRightDown, row + 1, col + 1);
        }






        if (amountMoveRight > amountMoveRightUp && amountMoveRight > amountMoveRightDown) {
            return amountMoveRight;
        } else if( amountMoveRightUp > amountMoveRight && amountMoveRightUp > amountMoveRightDown) {
            return amountMoveRightUp;
        } else {
            return amountMoveRightDown;
        }
    }

    ;

}
