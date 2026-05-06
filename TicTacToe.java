import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Game board
    static char[][] board = new char[3][3];

    // Game state
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        // UC1
        initializeBoard();

        // UC2
        tossAndAssignSymbols();
        displayTossResult();

        // Display initial board
        printBoard();

        // Human move
        int slot = getUserSlot();

        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        // UC5 + UC6
        if (isValidMove(row, col)) {

            placeMove(row, col, humanSymbol);

            System.out.println("\nBoard After Human Move:");
            printBoard();

        } else {
            System.out.println("Invalid move!");
        }

        // 🔥 UC7 Computer move
        computerMove();

        System.out.println("\nBoard After Computer Move:");
        printBoard();
    }

    // 🔹 UC1: Initialize board
    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // 🔹 UC1: Print board
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

    // 🔹 UC2: Toss logic
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

    // 🔹 UC2: Display toss result
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

    // 🔹 UC3: User input
    static int getUserSlot() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = input.nextInt();

        return slot;
    }

    // 🔹 UC4: Slot to row
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // 🔹 UC4: Slot to column
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // 🔹 UC5: Validate move
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

    // 🔹 UC6: Place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // 🔥 UC7: Computer random move
    static void computerMove() {

        Random random = new Random();

        while (true) {

            int slot = random.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {

                placeMove(row, col, computerSymbol);

                System.out.println("\nComputer selected slot: " + slot);

                break;
            }
        }
    }
}
