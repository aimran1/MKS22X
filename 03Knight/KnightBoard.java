public class KnightBoard{
  
  private int[][] board;
  private int[][] cboard;
  private int[] x ={1,1,2,2,-1,-1,-2,-2};
  private int[] y ={2,-2,1,-1,2,-2,-1,1};
  
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
        board[i][j] = 0; 
	    }
    }
     cboard = board;
  }

  public String toString(){
    String b = "";
    for (int i = 0; i < board.length; i++){
	    b += "\n";
	    for (int j = 0; j < board[i].length; j++){
        if(board[i][j] == 0){
          b += " _";
        }
        else if (board[i][j] < 10){
          b += "  " + board[i][j];
        }
        else{
          b += " " + board[i][j];
        }
	    }
    }
    return b;
  }

  public boolean solve(int startingRows, int startingCol){
    if (!zero()){
	    throw new IllegalStateException();
    }
    if(!isValid(startingRows,startingCol)){
      throw new IllegalArgumentException();
    }
    return solveH(startingRows,startingCol,1);
  }

  public boolean solveH(int row, int col, int level){
    if (level == board.length * board[0].length){
      board[row][col] = level;
      return true;
    }
    for (int i = 0; i < 8; i++){
      if(isValid(row+x[i],col+y[i])){
        board[row][col] = level;
        if(solveH(row+x[i],col+y[i],level+1)){
          return true;
        }
        board[row][col] = 0;
      }
    }
    return false;
  }
  
  private boolean isValid(int newR, int newC){
    if (newR >= 0 && newR < board.length &&
        newC < board[0].length && newC >= 0 &&
        board[newR][newC] == 0){
      return true;
    }
    return false;
  }

  private boolean zero(){
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
          return false;
        }
	    }
    }
    return true;
  }
  
  public static void main(String[] args){
    // KnightBoard a = new KnightBoard(3,3);

    //  KnightBoard b = new KnightBoard(5,5);
    // System.out.println(b.solve(0,0)); //prints true
    // System.out.println(b); //prints a valid solution

    /*try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    */
    /* try{
      b.countSolutions(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    */
    /*  try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"
    */
    /* try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"
    */
    /*    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"
    */
    /*  try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    /    */
    /*  try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    */
    /*  try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    */


    /* for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
      }*/
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    /* for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
      }*/

    //  System.out.println(totalSol); //prints 1728

    /* KnightBoard d = new KnightBoard(5,5);
   System.out.println(d.countSolutions(0,0)); //prints 304*/

  }
  }
