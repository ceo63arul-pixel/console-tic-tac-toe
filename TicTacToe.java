import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Game board
    static char[][] board = new char[3][3];

    // Game state variables
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        // Initialize board
        initializeBoard();

        // Toss and assign symbols
        tossAndAssignSymbols();
        displayTossResult();

        // Print initial board
        printBoard();

        // Game loop flag
        boolean gameOver = false;

        // UC8 + UC9 Continuous game loop
        while (!gameOver) {

            // Human turn
            if (isHumanTurn) {

                System.out.println("\nHuman Turn");

                int slot = getUserSlot();

                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                // Validate move
                if (isValidMove(row, col)) {

                    // Place move
                    placeMove(row, col, humanSymbol);

                    // Print updated board
                    printBoard();

                    // Check winning condition
                    if (hasWon(humanSymbol)) {
                        System.out.println("Human Wins!");
                        gameOver = true;
                    }

                    // Check draw
                    else if (isBoardFull()) {
                        System.out.println("Game Draw!");
                        gameOver = true;
                    }

                    // Switch turn
                    else {
                        isHumanTurn = false;
                    }

                } else {
                    System.out.println("Invalid move! Try again.");
                }

            }

            // Computer turn
            else {

                System.out.println("\nComputer Turn");

                computerMove();

                // Print updated board
                printBoard();

                // Check winning condition
                if (hasWon(computerSymbol)) {
                    System.out.println("Computer Wins!");
                    gameOver = true;
                }

                // Check draw
                else if (isBoardFull()) {
                    System.out.println("Game Draw!");
                    gameOver = true;
                }

                // Switch turn
                else {
                    isHumanTurn = true;
                }
            }
        }

        System.out.println("Game Over!");
    }

    // UC1: Initialize board
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    // UC1: Print board
    static void printBoard() {

        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                System.out.print("| " + board[row][col] + " ");
            }

            System.out.println("|");
            System.out.println("-------------");
        }
    }

    // UC2: Toss and assign symbols
    static void tossAndAssignSymbols() {

        Random random = new Random();

        int toss = random.nextInt(2);

        if (toss == 0) {

            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';

        } else {

            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    // UC2: Display toss result
    static void displayTossResult() {

        if (isHumanTurn) {

            System.out.println("You won the toss!");
            System.out.println("You play first.");

        } else {

            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first.");
        }

        System.out.println("Your symbol: " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }

    // UC3: Get user slot
    static int getUserSlot() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");

        return input.nextInt();
    }

    // UC4: Convert slot to row
    static int getRowFromSlot(int slot) {

        return (slot - 1) / 3;
    }

    // UC4: Convert slot to column
    static int getColFromSlot(int slot) {

        return (slot - 1) % 3;
    }

    // UC5: Validate move
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

    // UC6: Place move
    static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // UC7: Computer random move
    static void computerMove() {

        Random random = new Random();

        while (true) {

            int slot = random.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {

                placeMove(row, col, computerSymbol);

                System.out.println("Computer selected slot: " + slot);

                break;
            }
        }
    }

    // UC8: Check if board is full
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

    // UC9: Check winning condition
    static boolean hasWon(char symbol) {

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

        // Check main diagonal
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        // Check opposite diagonal
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }
}
