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

        // Human move
        int slot = getUserInput();

        int[] userPos = convertSlotToIndex(slot);

        int userRow = userPos[0];
        int userCol = userPos[1];

        if (isValidMove(userRow, userCol)) {

            placeMove(userRow, userCol, humanSymbol);

            System.out.println("Human move placed.");
            printBoard();
        }

        // UC7: Computer move
        computerMove();

        System.out.println("Computer move placed.");
        printBoard();
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

            System.out.println("You won toss! You are X");

        } else {

            humanSymbol = 'O';
            computerSymbol = 'X';

            System.out.println("Computer won toss! Computer is X");
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