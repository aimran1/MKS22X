public class QueenBoard{

  private int[][] board;
  private int count = 0;
  
  public QueenBoard(int size){
    board = new int[size][size];
    reset();
  }
  
  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
	    board[r][c] = -1;
      for (int row = 0; row < board.length; row++){
        for (int col = 0; col < board[row].length; col++){
          if (row == r && col != c){
            board[row][col] += 1; 
          }
          if (col == c && row != r){
            board[row][col] += 1;
          }
          if ((c - col == r - row) && (row != r || col != c)){
            board[row][col] += 1;
          }
        }
	    }
	    for (int i = 1; r + i < board.length || c + i < board.length; i++){
        if( r + i < board.length && c - i >= 0){ 
          board[r+i][c-i]+=1;
        }
        if(r-i>=0 && c+i <board.length){
          board[r-i][c+i]+=1;
        }
}
	    return true;
    }
    return false;
  }

  
  
  private boolean removeQueen(int r, int c){
    if (board[r][c] < 0){
	    board[r][c] = 0;
 for (int row = 0; row < board.length; row++){
        for (int col = 0; col < board[row].length; col++){
          if (row == r && col != c){
            board[row][col] -= 1; 
          }
          if (col == c && row != r){
            board[row][col] -= 1;
          }
          if ((c - col == r - row) && (row != r || col != c)){
            board[row][col] -= 1;
          }
        }
	    }
	    for (int i = 1; r + i < board.length || c + i < board.length; i++){
        if( r + i < board.length && c - i >= 0){ 
          board[r+i][c-i]-=1;
        }
        if(r-i>=0 && c+i <board.length){
          board[r-i][c+i]-=1;
        }
}
	    return true;
    }
    return false;
  }

  private boolean zero(){
    for (int col = 0; col < board.length; col++){
      for (int row = 0; row < board.length; row++){
        if (board[col][row] != 0){
          return false;
        }
      }
    }
    return true;
  }

  private void reset(){
    for (int col = 0; col < board.length; col++){
      for (int row = 0; row < board.length; row++){
        board[col][row] = 0;
      }
    }
  }

  
  public String toString(){
    String b = "";
    for (int i = 0; i < board.length; i++){
	    b = b + "\n";
	    for (int j = 0; j < board[i].length; j++){
        if (board[j][i] < 0){
          b = b + " " + "Q";
        }else {
          b = b + " " + board[j][i];
        }
	    }
    }
    return b;
  }

  public boolean solve(){
    if (!(zero())){
      throw new IllegalStateException();
    }
    return help(0);
  }

  public boolean help(int col){
    if (col == board.length){
	    return true;
    }
    for ( int i = 0; i < board.length; i++){
	    if (addQueen(i,col)){
        if (help(col+1)){
          return true;
        }
        removeQueen(i,col);
	    }
    }
    return false;
  }

  public int countSolutions(){
    if (!(zero())){
      throw new IllegalStateException();
    }
    return helpCount(0);
  }

  private int helpCount(int row){
    if (row >= board.length){
      return count+=1;
    }
    for (int i = 0; i < board.length; i++){
      if (addQueen(row,i)){
        helpCount(row+1);
        removeQueen(row,i);
      }
    }
    return count;
  }
     
public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);
    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

   try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */
      System.out.println(a); //prints out an empty i by i grid of underscores
  }
}
  
}
