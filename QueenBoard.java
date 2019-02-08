public class QueenBoard{
  private int[][]board;
  //Queen is -1; empty/safe is 0; not safe location is greater 0 determined by the num of queens threatening it

  public QueenBoard(int size){ //constructor
    board = new int[size][size];
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        board[r][c] = 0;
      }
    }
  }

/*  public boolean addQueen(int r, int c){ //public for testing
    try{
      //testing horizontal Queen
      for (int x = 0; x < board[r].length; x++){
        if (board[r][x] == 'Q' + 0){
          return false;
        }
      }
      //no vertical testing since we add according to column (left to right)
      //testing horizontal (left to right down) Queen
      int checkX = c;
      int checkY = r;
      while (checkX > 0 && checkY > 0){ //find the first top left grid for horizontal check
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

      //testing horizontal (right to left down) Queen
      checkX = c;
      checkY = r;
      while (checkX < board.length-1 && checkY > 0){ //find the first top right grid for horizontal check
        checkX++;
        checkY--;
      }
      while (checkX > 0 && checkY < board.length){ //go down horizontally from the top right grid
        if (board[checkY][checkX] == 'Q'){
          return false;
        }
        else{ //move to next horizontal grid
          checkX--;
          checkY++;
        }
      }
      //only add after passing the testings above
      board[r][c] = 'Q' + 0;
      return true;
    }
    catch(IndexOutOfBoundsException e){ //public for testing
      return false;
    }
  }
  */

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
      board[r][c] = 0;
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
        /*if (board[r][c] != -1){
          Board += '_';
          Board += ' ';
        }
        else{
          Board += 'Q';
          Board += ' ';
        }*/
        //testing threat level
        Board += board[r][c];
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
    //use recursion here to add Q using different column for (int x)
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    //the total number of combination of solutions(nth queens all on board)
    return 0;
  }


}
