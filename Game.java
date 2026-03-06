import java.util.Scanner;

public class Game
{
    private Board board;
    private Scanner input;

    public Game()
    {
        board = new Board();
        input = new Scanner(System.in);
    }

    public void play()
    {
        System.out.println("Welcome to Concentration!");
        System.out.println("Enter row and column numbers (example: 1 2)");
        System.out.println();

        while (!board.allTilesMatch())
        {
            System.out.println(board);

            int r1, c1, r2, c2;

            // FIRST SELECTION
            while (true)
            {
                System.out.print("First choice: ");
                r1 = input.nextInt();
                c1 = input.nextInt();

                if (board.validateSelection(r1, c1, -1, -1)) // no previous choice yet
                    break;

                System.out.println("Invalid selection. Try again.");
            }

            board.showValue(r1, c1);
            System.out.println(board);

            // SECOND SELECTION
            while (true)
            {
                System.out.print("Second choice: ");
                r2 = input.nextInt();
                c2 = input.nextInt();

                if (board.validateSelection(r2, c2, r1, c1))
                    break;

                System.out.println("Invalid selection. Cannot pick same tile or already matched. Try again.");
            }

            board.showValue(r2, c2);
            System.out.println(board);

            System.out.println(board.checkForMatch(r1, c1, r2, c2));
            System.out.println();
        }

        System.out.println("Congratulations! You matched all tiles!");
    }
}