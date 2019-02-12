public class driver{
  public static void main(String[] args){
    QueenBoard board1 = new QueenBoard(5); //create a 5X5 size board
    System.out.println(board1);
    System.out.println("Testing solve() in a new board");
    board1.solve();
    System.out.println(board1);
    System.out.println("Testing exception");
    board1.solve();
    System.out.println(board1);
    System.out.println("COunting total solutions");
    System.out.println(board1.countSolutions());


    QueenBoard board2 = new QueenBoard(2); //create a 2X2 size board
    System.out.println(board2);
    System.out.println("Testing solve() in a new unsolvable board");
    board2.solve();
    System.out.println(board2);


  }
}
