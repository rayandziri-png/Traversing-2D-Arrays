import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner input;

    public Game() {
        board = new Board();
        input = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Concentration!");
        System.out.println("Enter row and column numbers (example: 1 2)");
        System.out.println();

        while (!board.allTilesMatch()) {
            System.out.println(board);

            System.out.print("First choice: ");
            int r1 = input.nextInt();
            int c1 = input.nextInt();

            if (!board.validateSelection(r1, c1)) {
                System.out.println("Invalid selection.\n");
                continue;
            }

            board.showValue(r1, c1);
            System.out.println(board);

            System.out.print("Second choice: ");
            int r2 = input.nextInt();
            int c2 = input.nextInt();

            if (!board.validateSelection(r2, c2)) {
                System.out.println("Invalid selection.\n");
                board.showValue(r1, c1);
                continue;
            }

            board.showValue(r2, c2);
            System.out.println(board);

            System.out.println(board.checkForMatch(r1, c1, r2, c2));
            System.out.println();
        }

        System.out.println("Congratulations! You matched all tiles!");
    }
}