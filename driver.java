public class driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(8); //create a 8X8 size board
    System.out.println("printing a 8x8 size board");
    System.out.println(board);
    System.out.println("adding a Q at [0,0], [4,3], [3,2] && [6,4]");
    board.addQueen(0,0);
    //board.addQueen(4,3);
    board.addQueen(3,2);
    board.addQueen(4,3);

    System.out.println(board);

    System.out.println("adding Q at [6,4]");
    board.addQueen(6,4);
    System.out.println(board);

    System.out.println("removing Q at [3,2]");
    board.removeQueen(3,2);
    System.out.println(board);
    /*System.out.println("removing Q at [0,2] && [2,2]");
    board.removeQueen(0,2);
    board.removeQueen(2,2);
    System.out.println(board);
    System.out.println("Updated adding Q so there should be no Q at [0,2]&&[2,2], only at [0,0]");
    System.out.println("trying to add at [2,1], this should work");
    board.addQueen(2,1);
    System.out.println(board);
    */

    QueenBoard board1 = new QueenBoard(5); //create a 5X5 size board
    System.out.println(board1);
    System.out.println("Testing solve() in a new board");
    board1.solve();
    System.out.println(board1);
  }
}
