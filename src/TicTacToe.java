import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];
    private static int moveCount = 0;
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            clearBoard();
            moveCount = 0;
            currentPlayer = "X";
            boolean done = true;
            while (done) {
                display();
                int rowMove = SafeInput.getRangedInt(in, "Enter a row number from ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, "Enter a column number from ", 1, 3) - 1;
                if (isValidMove(rowMove, colMove)) {
                    board[rowMove][colMove] = currentPlayer;
                    moveCount++;
                    if (isWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        done = false;
                    } else if (isTie()) {
                        display();
                        System.out.println("It's a tie!");
                        done = false;
                    } else {
                        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                    }
                }
            }
        } while (SafeInput.getYNConfirm(in, "Play again? :"));
        System.out.println("Thanks for playing!");

    }

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = String.valueOf(' ');
            }
        }
    }

    private static void display() {
        System.out.println("-------------");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("| ");
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col].equals(" ")) {
            return false;
        } return board[row][col].equals(" ");
} private static boolean isWin(String player) {
            return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
        } private static boolean isRowWin(String player) {
            for (int row = 0; row < ROWS; row++) {
                if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                    return true;
                }
            }
            return false;
        } private static boolean isColWin(String player) {
            for (int col = 0; col < COLS; col++) {
                if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                    return true;
                }
            }
            return false;
        } private static boolean isDiagonalWin(String player) {
            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
                return true;
            }
            if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
                return true;
            }
            return false;
        } private static boolean isTie() {
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    if (board[row][col].equals(" ")) {
                        return false;
                    }
                }
            }
            return true;
        }
}
