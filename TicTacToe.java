import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        initializeBoard();
        toss();
        printBoard();

        boolean gameOver = false;

        // UC8: Continuous game loop
        while (!gameOver) {

            if (currentPlayer == humanSymbol) {

                humanMove();

            } else {

                computerMove();
            }

            printBoard();

            // Check win
            if (checkWin(currentPlayer)) {

                if (currentPlayer == humanSymbol) {
                    System.out.println("Human wins!");
                } else {
                    System.out.println("Computer wins!");
                }

                gameOver = true;
            }

            // Check draw
            else if (isBoardFull()) {

                System.out.println("Game Draw!");

                gameOver = true;
            }

            // Switch turn
            else {

                switchPlayer();
            }
        }
    }

    // UC1
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    // UC2
    static void toss() {

        int tossResult = rand.nextInt(2);

        if (tossResult == 0) {

            humanSymbol = 'X';
            computerSymbol = 'O';

            currentPlayer = humanSymbol;

            System.out.println("You won toss! You are X");

        } else {

            humanSymbol = 'O';
            computerSymbol = 'X';

            currentPlayer = computerSymbol;

            System.out.println("Computer won toss! Computer starts");
        }
    }

    // Human move
    static void humanMove() {

        while (true) {

            int slot = getUserInput();

            int[] pos = convertSlotToIndex(slot);

            int row = pos[0];
            int col = pos[1];

            if (isValidMove(row, col)) {

                placeMove(row, col, humanSymbol);

                break;
            }

            System.out.println("Invalid move! Try again.");
        }
    }

    // UC7
    static void computerMove() {

        while (true) {

            int randomSlot = rand.nextInt(9) + 1;

            int[] pos = convertSlotToIndex(randomSlot);

            int row = pos[0];
            int col = pos[1];

            if (isValidMove(row, col)) {

                placeMove(row, col, computerSymbol);

                System.out.println("Computer selected slot: " + randomSlot);

                break;
            }
        }
    }

    // UC3
    static int getUserInput() {

        int slot;

        while (true) {

            System.out.print("Enter slot number (1-9): ");

            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) {
                return slot;
            }

            System.out.println("Invalid input!");
        }
    }

    // UC4
    static int[] convertSlotToIndex(int slot) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    // UC5
    static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // UC6
    static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // UC8
    static void switchPlayer() {

        if (currentPlayer == humanSymbol) {
            currentPlayer = computerSymbol;
        } else {
            currentPlayer = humanSymbol;
        }
    }

    // Win check
    static boolean checkWin(char symbol) {

        // Rows
        for (int row = 0; row < 3; row++) {

            if (board[row][0] == symbol &&
                board[row][1] == symbol &&
                board[row][2] == symbol) {

                return true;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {

            if (board[0][col] == symbol &&
                board[1][col] == symbol &&
                board[2][col] == symbol) {

                return true;
            }
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }

    // Draw check
    static boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    // Display board
    static void printBoard() {

        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            System.out.print("| ");

            for (int col = 0; col < 3; col++) {

                System.out.print(board[row][col] + " | ");
            }

            System.out.println();
            System.out.println("-------------");
        }
    }
}