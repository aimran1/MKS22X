public class QueenBoard{

  //---------------------Variables-------------------
  private int[][] board;
  private int count = 0;

  //---------------------Constructor-----------------
  public QueenBoard(int size){
    board = new int[size][size];
    reset();
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
  
  //------------------Add & Remove-------------------
  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
	    board[r][c] = -1;
      for (int row = 0; row < board.length; row++){
        for (int col = 0; col < board[row].length; col++){
          //Same row
          if (row == r && col != c){
            board[row][col] += 1; 
          }
          //Same column
          if (col == c && row != r){
            board[row][col] += 1;
          }
          //Diagonal left up and right down
          if ((c - col == r - row) && (row != r || col != c)){
            board[row][col] += 1;
          }
        }
	    }
	    for (int i = 1; r + i < board.length || c + i < board.length; i++){
        //Rest of diagonals
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
          //Same row and column
          if (row == r && col != c){
            board[row][col] -= 1; 
          }
          if (col == c && row != r){
            board[row][col] -= 1;
          }
          //Some Diagonals
          if ((c - col == r - row) && (row != r || col != c)){
            board[row][col] -= 1;
          }
        }
	    }
	    for (int i = 1; r + i < board.length || c + i < board.length; i++){
        //Rest of diagonals
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


  //---------------------Helper Methods-------------------
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

  public boolean Shelp(int col){
    if (col == board.length){
	    return true;
    }
    for ( int i = 0; i < board.length; i++){
	    if (addQueen(i,col)){
        if (Shelp(col+1)){
          return true;
        }
        removeQueen(i,col);
	    }
    }
    return false;
  }

  private int Chelp(int row){
    if (row >= board.length){
      return count+=1;
    }
    for (int i = 0; i < board.length; i++){
      if (addQueen(row,i)){
        Chelp(row+1);
        removeQueen(row,i);
      }
    }
    return count;
  }

  //-----------------Solve and countSolutions---------------

  public boolean solve(){
    if (!(zero())){
      throw new IllegalStateException();
    }
    return Shelp(0);
  }

  public int countSolutions(){
    if (!(zero())){
      throw new IllegalStateException();
    }
    return Chelp(0);
  }

}
