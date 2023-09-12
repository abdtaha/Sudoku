package inl;



public class Sudoku implements SudokuSolver {

    private int[][] board;

    public Sudoku() {
        board = new int[9][9];
    }
 
  //skriver ut matrisen i console
    public String toString() {
        String s = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                s += board[i][j];
                s += "|";
            }
            s += '\n';
        }
        return s;
    }
    @Override
    public boolean solve() {
        return solve(0, 0);
    }

    /**
     * Recursively solves the sudoku.
     * 
     * @param row the starting row
     * @param col the starting column
     * @return true is the sudoku was solved, otherwise false
     */
    private boolean solve(int row, int col) {
    	// kollar att alla värden som är placerade följer reglerna
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.board[i][j] != 0) {
                    int nbr = board[i][j];
                    this.board[i][j] = 0;
                    if (!isSafe(i, j, nbr)) {
                        return false;
                    }
                    this.board[i][j] = nbr;
                }
            }
        }
        if (row == 8 && col == 9)
            return true;

        if (col == 9) {
            row++;
            col = 0;
        }
              if (board[row][col] != 0) 
                  return solve(row, col + 1);

              for (int number = 1; number < 10; number++) {

                  if (isSafe(row, col, number)) {
                	  setCell (row, col, number);
                       if (solve(row, col))
                           return true;
                   }
                

                  board[row][col] = 0;
              }
              return false;
}
public boolean isSafe(int row, int col, int n) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n) {
                return false;
            }
        }

        int x = row - (row% 3);
        int y = col - (col% 3);

        for (int i = x; i < x+3; i++) {
            for (int k = y; k < y+3; k++) {
                if (board[i][k] == n) {
                    return false;
                }
            }
        }
        return true;
    }


@Override
public void setCell(int row, int col, int val) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(val >= 0 && val < 10 && col > -1 && col < 9 && row > -1 && row < 9) {
         board[row][col] = val;
    }
    else {
        throw new IllegalArgumentException(" not");
    }
}


@Override
public int getCell(int row, int col) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(col > -1 && col < 9 && row > -1 && row < 9) {
    return board[row][col];
    }
    else {
        throw new IllegalArgumentException();
    }
}

}
