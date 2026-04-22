import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC1: Board
    static char[][] board = new char[3][3];

    // UC2: Game state
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        // UC1
        initializeBoard();
        printBoard();

        // UC2
        tossAndAssignSymbols();
        displayTossResult();

        // UC3
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
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

    // 🔹 UC2: Display result
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

    // 🔹 UC3: Get user input
    static int getUserSlot() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = input.nextInt();

        return slot;
    }
}