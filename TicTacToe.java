import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        toss();
        printBoard();

        int slot, row, col;

        // Keep asking until valid move
        while (true) {
            slot = getUserInput();
            int[] pos = convertSlotToIndex(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(row, col)) {
                System.out.println("Valid move!");
                break;
            } else {
                System.out.println("Invalid move! Cell already occupied or out of bounds.");
            }
        }
    }

    // UC1
    static void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    // UC2
    static void toss() {
        Random rand = new Random();
        int tossResult = rand.nextInt(2);

        if (tossResult == 0) {
            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = humanSymbol;
            System.out.println("You won the toss! You play first with 'X'");
        } else {
            humanSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = computerSymbol;
            System.out.println("Computer won the toss! Computer plays first with 'X'");
        }
    }

    // UC3
    static int getUserInput() {
        int slot;

        while (true) {
            System.out.print("Enter a slot number (1-9): ");
            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) break;
            else System.out.println("Invalid input! Enter 1-9.");
        }

        return slot;
    }

    // UC4
    static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate move
    static boolean isValidMove(int row, int col) {
        // Check bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    // UC1
    static void printBoard() {
        System.out.println("-------------");
        for (int r = 0; r < 3; r++) {
            System.out.print("| ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}