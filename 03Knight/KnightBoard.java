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
        if (board[i][j] < 10){
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
    
    if (!zero() ||
        startingRows < 0 || startingCol < 0 ||
        startingRows > board.length || startingCol > board[0].length){
	    throw new IllegalArgumentException();
    }
    return solveH(startingRows,startingCol,1);
  }

  public boolean solveH(int row, int col, int level){
    if (level ==  board.length * board[0].length){
      board[row][col] = level;
      return true;
    }
    for (int i = 0; i < 8; i++){
      if(test(row+x[i],col+y[i],level)){
        if(solveH(row+x[i],col+y[i],level+1)){
          return true;
        }
        board[row][col] = 0;
      }
    }
    /* if(test(row,col,level)){
      return solveH(row+x[0],col+y[0],level+1) ||
        solveH(row+x[1],col+y[1],level+1) ||
        solveH(row+x[2],col+y[2],level+1) ||
        solveH(row+x[3],col+y[3],level+1) ||
        solveH(row+x[4],col+y[4],level+1) ||
        solveH(row+x[5],col+y[5],level+1) ||
        solveH(row+x[6],col+y[6],level+1) ||
        solveH(row+x[7],col+y[7],level+1);       
        }*/
    return false;
  }

  public boolean test(int newr, int newc, int level){
    if (isValid(newr,newc)){
      board[newr][newc] = level;
      return true;
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

  public boolean zero(){
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
    KnightBoard b = new KnightBoard(3,5);
    System.out.println(b.solve(0,0));
    // b.add(6,5,10);
    System.out.println(b);
  }
    
}
