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

        // UC3: Take user input
        int slot = getUserInput();
        System.out.println("You selected slot: " + slot);
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

    // UC3: Get user input
    static int getUserInput() {
        int slot;

        while (true) {
            System.out.print("Enter a slot number (1-9): ");
            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) {
                break;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
            }
        }

        return slot;
    }

    // UC1
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