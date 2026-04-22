import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        tossAndAssignSymbols();
        displayTossResult();

        int slot = getUserSlot();

        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        // UC5 validation
        if (isValidMove(row, col)) {
            System.out.println("Valid move!");
        } else {
            System.out.println("Invalid move!");
        }
    }

    // UC1
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

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

    // UC2
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

    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("You won the toss!");
        } else {
            System.out.println("Computer won the toss!");
        }

        System.out.println("Your symbol: " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }

    // UC3
    static int getUserSlot() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter slot (1-9): ");
        int slot = input.nextInt();

        return slot;
    }

    // UC4
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // 🔥 UC5
    static boolean isValidMove(int row, int col) {

        // Check boundaries
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}