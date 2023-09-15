public class Crossword {
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares)
    {
        puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int labels = 1;
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                Square sq;
                if (toBeLabeled(row, col, blackSquares)) {
                    sq = new Square(blackSquares[row][col], labels);
                    labels++;
                } else {
                    sq = new Square(blackSquares[row][col], 0);
                }
                puzzle[row][col] = sq;
            }
        }

    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        if (!blackSquares[r][c] && (r == 0 || c == 0 || blackSquares[r-1][c] || blackSquares[r][c-1])) {
            return true;
        }
        return false;
    }

    public Square[][] getPuzzle() {
        return puzzle;
    }
}
