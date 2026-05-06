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

        while (true) {

            int slot = getUserInput();

            int[] position = convertSlotToIndex(slot);

            int row = position[0];
            int col = position[1];

            // UC5 Validation
            if (isValidMove(row, col)) {

                // UC6 Place Move
                placeMove(row, col, currentPlayer);

                System.out.println("Move placed successfully!");

                printBoard();
                break;

            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // UC1: Initialize Board
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    // UC2: Toss
    static void toss() {

        Random rand = new Random();

        int tossResult = rand.nextInt(2);

        if (tossResult == 0) {

            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = humanSymbol;

            System.out.println("You won the toss! You play first as X");

        } else {

            humanSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = humanSymbol;

            System.out.println("Computer won the toss! You are O");
        }
    }

    // UC3: User Input
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

    // UC4: Convert Slot → Row & Column
    static int[] convertSlotToIndex(int slot) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    // UC5: Validate Move
    static boolean isValidMove(int row, int col) {

        // Boundary check
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Empty cell check
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    // UC6: Place Move
    static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // Display Board
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