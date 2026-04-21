import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char humanSymbol;
    static char computerSymbol;
    static char currentPlayer;

    public static void main(String[] args) {
        initializeBoard();
        toss();
        printBoard();
    }

    // UC1: Initialize board
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // UC2: Toss logic
    static void toss() {
        Random rand = new Random();
        int tossResult = rand.nextInt(2); // 0 or 1

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

    // UC1: Print board
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