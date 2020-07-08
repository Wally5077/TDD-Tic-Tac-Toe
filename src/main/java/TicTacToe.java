import java.util.Arrays;

public class TicTacToe {

    public static final int NONE = -1;
    public static final int CIRCLE = -2;
    public static final int CROSS = -3;
    private int currentPlayer = CIRCLE;
    private int[][] board = new int[3][3];

    public void startGame() {
        for (int[] ints : board) {
            Arrays.fill(ints, NONE);
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void play(int row, int col) {
        if (board[row][col] == NONE) {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == CIRCLE) ? CROSS : CIRCLE;
        } else {
            throw new BlockInvalidException();
        }
    }

    public int getWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == CIRCLE) {
                for (int col = 1; col < 3; col++) {
                    int currentBoard = board[row][col];
                    if (currentBoard == CROSS || currentBoard == NONE) {
                        return NONE;
                    }
                }
                return CIRCLE;
            }
        }
        return NONE;
    }
}
