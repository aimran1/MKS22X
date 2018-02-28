public class KnightBoard{

  private int[][] board;
  private static int[][] fast;

  //----------------All possible Knight moves---------------------
  private int[] x ={1,1,2,2,-1,-1,-2,-2};
  private int[] y ={2,-2,1,-1,2,-2,-1,1};

  //---------------------Constructor------------------------------
  public KnightBoard(int startingRows, int startingCols){

    if (startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }

    board = new int[startingRows][startingCols];
    fast = new int[startingRows][startingCols];
    makeFast();

    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        board[i][j] = 0;
      }
    }

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

  //-------------------Solve and SolveHelper----------------------
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



  //--------------------Count and CountHelper---------------------
  public int countSolutions(int startingRow, int startingCol){

    if (!zero()){
      throw new IllegalStateException();
    }

    if(!isValid(startingRow,startingCol)){
      throw new IllegalArgumentException();
    }

    return countH(startingRow,startingCol,1);
  }

  private int countH(int row, int col, int level){
    int sol = 0;

    if(!isValid(row,col)){
      return 0;
    }

    if (level == board.length*board[0].length){
      board[row][col] = 0;
      return 1;
    }

    board[row][col] = level;

    for (int i = 0; i < 8; i++){
      sol += countH(row+x[i],col+y[i],level+1);
    }

    board[row][col] = 0;

    return sol;
  }

  //--------------Helper Methods to Check Conditions--------------
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

  //------------------------Fast Helpers----------------------
  private void makeFast(){
    int count = 0;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[0].length; j++){
        count = 0;
        for (int k = 0; k < 8; k++){
          if(isValid(i+x[k],j+y[k])){
            count += 1;
          }
        }
        fast[i][j] = count;
      }
    }
  }

  public static void print(){
    String b = "";

    for (int i = 0; i < fast.length; i++){
      b += "\n";
      for (int j = 0; j < fast[i].length; j++){
        if(fast[i][j] == 0){
          b += " _";
        }

        else if (fast[i][j] < 10){
          b += "  " + fast[i][j];
        }

        else{
          b += " " + fast[i][j];
        }
      }
    }

    System.out.println( b );
  }

  public static void main(String[] args){
    KnightBoard n = new KnightBoard(5,5);
    print();
  }

}
