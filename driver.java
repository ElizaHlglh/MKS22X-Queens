public class driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(3); //create a 3X3 size board
    System.out.println("printing a 3x3 size board");
    System.out.println(board);
    System.out.println("adding a Q at [0,0], [0,2] && [2,2]");
    board.addQueen(0,0);
    board.addQueen(0,2);
    board.addQueen(2,2);
    System.out.println(board);
    System.out.println("removing Q at [0,2] && [2,2]");
    board.removeQueen(0,2);
    board.removeQueen(2,2);
    System.out.println(board);
  }
}
