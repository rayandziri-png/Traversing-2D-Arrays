public class Board
{
    private Tile[][] gameboard;

    private String[] tileValues = {
        "fox", "fox",
        "penguin", "penguin",
        "dog", "dog",
        "cat", "cat",
        "lion", "lion",
        "tiger", "tiger"
    };

    public Board()
    {
        gameboard = new Tile[3][4];

        int tileCount = tileValues.length - 1;

        for (int i = 0; i < gameboard.length; i++)
        {
            for (int j = 0; j < gameboard[i].length; j++)
            {
                int r = (int)(Math.random() * (tileCount + 1));
                gameboard[i][j] = new Tile(tileValues[r]);
                tileValues[r] = tileValues[tileCount];
                tileCount--;
            }
        }
    }

    public String toString()
    {
        String result = "";

        for (Tile[] row : gameboard)
        {
            for (Tile tile : row)
            {
                if (tile.isMatched())
                {
                    result += "*\t";
                }
                else if (tile.isShowing())
                {
                    result += tile.getValue() + "\t";
                }
                else
                {
                    result += "X\t";
                }
            }
            result += "\n";
        }

        return result;
    }

    public boolean allTilesMatch()
    {
        for (Tile[] row : gameboard)
        {
            for (Tile tile : row)
            {
                if (!tile.isMatched())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void showValue(int row, int col)
    {
        gameboard[row][col].setShowing(true);
    }

    public String checkForMatch(int r1, int c1, int r2, int c2)
    {
        Tile first = gameboard[r1][c1];
        Tile second = gameboard[r2][c2];

        if (first.getValue().equals(second.getValue()))
        {
            first.setMatched(true);
            second.setMatched(true);
            return "Match!";
        }
        else
        {
            first.setShowing(false);
            second.setShowing(false);
            return "Not a match.";
        }
    }

    // Updated validateSelection to prevent selecting the same tile twice
    public boolean validateSelection(int row, int col, int prevRow, int prevCol)
    {
        if (row < 0 || row >= gameboard.length)
            return false;

        if (col < 0 || col >= gameboard[0].length)
            return false;

        if (gameboard[row][col].isMatched())
            return false;

        if (row == prevRow && col == prevCol)
            return false; // cannot pick same tile twice

        return true;
    }
}