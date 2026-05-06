public static void main(String[] args) {

    // Initialize game
    initializeBoard();

    // Toss
    tossAndAssignSymbols();
    displayTossResult();

    // Print initial board
    printBoard();

    // Game state
    boolean gameOver = false;

    // 🔥 UC8 Continuous loop
    while (!gameOver) {

        if (isHumanTurn) {

            System.out.println("\nHuman Turn");

            int slot = getUserSlot();

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {

                placeMove(row, col, humanSymbol);

                printBoard();

                // Switch turn
                isHumanTurn = false;

            } else {
                System.out.println("Invalid move! Try again.");
            }

        } else {

            System.out.println("\nComputer Turn");

            computerMove();

            printBoard();

            // Switch turn
            isHumanTurn = true;
        }

        // Temporary stopping condition
        // (Win/draw checking comes in next UC)
        gameOver = isBoardFull();
    }

    System.out.println("Game Over!");
}
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
