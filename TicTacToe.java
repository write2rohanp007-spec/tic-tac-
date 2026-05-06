static boolean isBoardFull() {

    // Traverse entire board
    for (int row = 0; row < 3; row++) {

        for (int col = 0; col < 3; col++) {

            // Empty cell found
            if (board[row][col] == '-') {

                return false;
            }
        }
    }

    // No empty cells left
    return true;
}