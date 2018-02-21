public class KnightBoard{
  
  private int[][] board;
  private int[][] cboard;
  
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
        if (board[j][i] < 10){
          b += "  " + board[j][i];
        }
        else{
          b += " " + board[j][i];
        }
	    }
    }
    return b;
  }

  public boolean solve(int startingRows, int startingCol){
    
    if (!zero()){
	    throw new IllegalStateException();
    }
    if (startingRows < 0 || startingCol < 0 ||
        startingRows > board.length || startingCol > board[0].length){
	    throw new IllegalArgumentException();
    }
	
    return solveH(0,0,1);
  }

  public boolean solveH(int row, int col, int level){
    if (level > board.length * board[0].length){
      return true;
    }
    for(int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (isValid(row,col,i,j)){
          board[i][j] = level;
          solveH(i,j,level + 1);
        }
      }
    }
    board = cboard;
    return false;
  }

  public boolean isValid(int row, int col, int newR, int newC){
    if (board[newR][newC] > 0){
	    return false;
    }
    if (newR >= board.length || newR < 0 ||
        newC >= board[0].length || newC < 0 ||
        row >= board.length || row < 0 ||
        col >= board.length || col < 0){
	    return false;
    }
    if (Math.abs(newR - row) == 2 && Math.abs(newC - col) == 1 ||
        Math.abs(newC - col) == 2 && Math.abs(newR - row) == 1){
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
    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b);
    b.solve(0,0);
    System.out.println(b);
  }
    
}
