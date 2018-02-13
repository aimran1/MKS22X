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
          b = b + " " + "_";
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
    if (col > board.length-1){
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
    reset();
    if (!(zero())){
      throw new IllegalStateException();
    }
    for (int i = 0; i < board.length; i++){
      if (help(i) == true){
        count++;
      }
      reset();
    }
    reset();
    return count;
  }

  public static void main (String[] args){
    QueenBoard n = new QueenBoard(4);
    // n.solve();
    // n.addQueen(2,4);
    // n.removeQueen(1,3);
    // n.removeQueen(1,3);
    // System.out.println(Text.go(1,1));
    // System.out.println(n);
    // System.out.println(n.countSolutions());
    // Text.wait(50);
  }
  
}
