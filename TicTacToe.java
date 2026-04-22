import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];

    // UC2 variables
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        // UC2 methods
        tossAndAssignSymbols();
        displayTossResult();
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

    // 🔥 UC2: Toss logic
    static void tossAndAssignSymbols() {

        Random random = new Random();
        int toss = random.nextInt(2); // 0 or 1

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

    // 🔥 UC2: Display result
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
}