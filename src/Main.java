import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameOver = false;
        Player player1, player2, currentPlayer;
        Board board = new Board();
        player1 = getPlayerFromKeyboard();
        player2 = getPlayerFromKeyboard();
        currentPlayer = getRandomPlayer(player1, player2);
        while (!gameOver) {
            System.out.println(board);
           Shot shot  = getShot(currentPlayer);
            if (board.correctShoot(shot, currentPlayer)) {
                if (board.wins()) {
                    System.out.println("Winner:" + currentPlayer.getName());
                    gameOver = true;
                } else {

                    currentPlayer = changePlayer(currentPlayer, player1, player2);
                }

            }
        }
    }

    public static Shot getShot (Player currentPlayer) {

        System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")" +
                " Enter row and col:");
        System.out.println("Row: ");
        int row = input.nextInt() - 1;
        System.out.println("Column:");
        int col = input.nextInt() - 1;
        return new Shot(row, col);
    }

    private static Player changePlayer(Player current, Player player1, Player player2) {
        return current == player1 ? player2 : player1;

    }

    private static Player getRandomPlayer(Player player1, Player player2) {
        int rand = (int) (Math.random() * 2);
        return rand == 0 ? player1 : player2;
    }

    private static Player getPlayerFromKeyboard() {
        System.out.println("Enter the name of the player" + (Player.getNumPlayers() == 0 ? "1" : "2"));
        String name = input.next();
        return new Player(name);
    }


}

