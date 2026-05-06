static boolean checkWin(char symbol) {

    // Check rows
    for (int row = 0; row < 3; row++) {

        if (board[row][0] == symbol &&
            board[row][1] == symbol &&
            board[row][2] == symbol) {

            return true;
        }
    }

    // Check columns
    for (int col = 0; col < 3; col++) {

        if (board[0][col] == symbol &&
            board[1][col] == symbol &&
            board[2][col] == symbol) {

            return true;
        }
    }

    // Check left diagonal
    if (board[0][0] == symbol &&
        board[1][1] == symbol &&
        board[2][2] == symbol) {

        return true;
    }

    // Check right diagonal
    if (board[0][2] == symbol &&
        board[1][1] == symbol &&
        board[2][0] == symbol) {

        return true;
    }

    // No win found
    return false;
}