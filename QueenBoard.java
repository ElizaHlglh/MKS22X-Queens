public class QueenBoard{
  private int[][]board;
  private int count;
  //Queen is -1; empty/safe is 0; not safe location is greater 0 determined by the num of queens threatening it

  public QueenBoard(int size){ //constructor
    board = new int[size][size];
    count = 0;
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        board[r][c] = 0;
      }
    }
  }

  public boolean addQueen(int r, int c){
    try{
      if (board[r][c] > 0){ // check if this coordinate is threatened
        return false;
      }
      else{
        board[r][c] = -1; // add the queen
        //increasing threats horizontally
        for (int x = c+1; x < board[r].length; x++){
          board[r][x] += 1; //increase threat level by 1;
        }

        //increase threats diagonal (left to right down)
        int checkX = c+1;
        int checkY = r+1;
        while (checkX < board.length && checkY < board.length){
          board[checkY][checkX] += 1;
          checkX++;
          checkY++;
        }

        //increase threats diagonal (left to right up)
        checkX = c+1;
        checkY = r-1;
        while (checkX < board.length && checkY >= 0){
          board[checkY][checkX] += 1;
          checkX++;
          checkY--;
        }

        return true;
      }

    }
    catch(IndexOutOfBoundsException e){ //public for testing
      return false;
    }
  }

  public boolean removeQueen(int r, int c){
    try{
      if (board[r][c] != -1){ // check if this coordinate is have a queen
        return false;
      }
      else{
        board[r][c] = 0; // add the queen
        //decreasing threats horizontally
        for (int x = c+1; x < board[r].length; x++){
          board[r][x] -= 1; //decrease threat level by 1;
        }

        //decrease threats diagonal (left to right down)
        int checkX = c+1;
        int checkY = r+1;
        while (checkX < board.length && checkY < board.length){
          board[checkY][checkX] -= 1;
          checkX++;
          checkY++;
        }

        //decrease threats diagonal (left to right up)
        checkX = c+1;
        checkY = r-1;
        while (checkX < board.length && checkY >= 0){
          board[checkY][checkX] -= 1;
          checkX++;
          checkY--;
        }

        return true;
      }

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
        if (board[r][c] != -1){
          Board += '_';
          Board += ' ';
        }
        else{
          Board += 'Q';
          Board += ' ';
        }
        /*//testing threat level
        Board += board[r][c];
        Board += ' ';*/
      }
      Board += '\n';
    }
    return Board;
  }

/*  boolean solveR(int col)
     if col is past end of board:
        return true
     for each row:
         if addQueen:
             if solveR(col+1):
                 return true
             removeQueen
     return false
*/

  private void clear(){
    for (int r = 0; r < board.length; r++){ //clear board if not solvable
      for (int c = 0; c < board[r].length; c++){
        board[r][c] = 0;
      }
    }
  }

  public boolean solveR(int col){
    if (col >= board.length){
      return true;
    }
    for (int r = 0; r < board.length; r++){//check all rows in each column
      if (addQueen(r,col)){ //see if the queen can be added to this row
        if (solveR(col+1)){
          return true;
        }
        else{
          removeQueen(r,col);
        }
      }
    }
    return false;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    try{
      for (int r = 0; r < board.length; r++){ //check is the board is clear/clean
        for (int c = 0; c < board[r].length; c++){
          if (board[r][c] != 0){
            throw new IllegalStateException();
          }
        }
      }

      if (solveR(0)){
        return true;
      }

      clear();
      return false;
    }
    catch(IllegalStateException e){
      clear();
      return false;
    }
  }

  public boolean solveAll(int col){
    if (col >= board.length){
      count++;
      return true;
    }
    for (int r = 0; r < board.length; r++){//check all rows in each column
      if (addQueen(r,col)){ //see if the queen can be added to this row
        solveAll(col+1); //not suppose to return anything because it will stop checking next row
        removeQueen(r,col);
      }
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
Testing solve() in a new board
-1 1 1 2 2
0  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    //the total number of combination of solutions(nth queens all on board)
    int ans = 0;
    count = 0;
    try{
      for (int r = 0; r < board.length; r++){ //check is the board is clear/clean
        for (int c = 0; c < board[r].length; c++){
          if (board[r][c] != 0){
            throw new IllegalStateException();
          }
        }
      }
        solveAll(0);
        ans = count;
        count = 0;
        clear();
        return ans;
    }
    catch(IllegalStateException e){
      clear();
      return 0;
    }
  }


}
