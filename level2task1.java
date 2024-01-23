import java.util.Scanner;

public class level2task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Goodbye.");
    }

    public static void playGame() {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        char currentPlayer = 'X';
        boolean gameWon = false;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            printBoard(board);
            getPlayerMove(board, currentPlayer);

            if (checkWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (checkDraw(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public static void getPlayerMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Player " + currentPlayer + ", enter row (0, 1, or 2): ");
            int row = scanner.nextInt();

            System.out.print("Player " + currentPlayer + ", enter column (0, 1, or 2): ");
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check rows
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check columns
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Check diagonal \
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Check diagonal /
        }
        return false;
    }

    public static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Game is still ongoing
                }
            }
        }
        return true; // All cells are filled, and no winner
    }
}
