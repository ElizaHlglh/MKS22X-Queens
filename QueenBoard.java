public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){ //constructor
    board = new int[size][size];
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        board[r][c] = '_' + 0;
      }
    }
  }

  public boolean addQueen(int r, int c){ //public for testing
    try{
      //testing horizontal Queen
      for (int x = 0; x < board[r].length; x++){
        if (board[r][x] == 'Q'){
          return false;
        }
      }
      //no vertical testing since we add according to column (left to right)
      //testing horizontal (left to right down) Queen
      int checkX = c;
      int checkY = r;
      while (checkX > 0 && checkY > 0){ //find the first top grid for horizontal check
        checkX--;
        checkY--;
      }
      while (checkX < board.length && checkY < board.length){ //go down horizontally from the top grid
        if (board[checkY][checkX] == 'Q'){
          return false;
        }
        else{ //move to next horizontal grid
          checkX++;
          checkY++;
        }
      }

      board[r][c] = 'Q' + 0;
      return true;
    }
    catch(IndexOutOfBoundsException e){ //public for testing
      return false;
    }
  }

  public boolean removeQueen(int r, int c){
    try{
      board[r][c] = '_' + 0;
      return true;
    }
    catch(IndexOutOfBoundsException e){
      return false;
    }
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String Board = "";
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        Board += (char) board[r][c];
        Board += ' ';
      }
      Board += '\n';
    }
    return Board;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }


}
