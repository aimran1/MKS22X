public class QueenBoard{

    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
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
        board[r+i][c-i]+=1;
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
        board[r+i][c-i]-=1;
        if(r-i>=0 && c+i <board.length){
          board[r-i][c+i]-=1;
        }
      }
	    return true;
	}
	return false;
    }

    public String toString(){
	String b = "";
	for (int i = 0; i < board.length; i++){
	    b = b + "\n";
	    for (int j = 0; j < board[i].length; j++){
		if (board[j][i] < 0){
		    b = b + " " + "Q";
		}else {
		    b = b + " " +board[j][i];
		}
	    }
	}
	return b;
    }

    public static void main (String[] args){
      QueenBoard n = new QueenBoard(5);
       n.addQueen(1,3);
      // n.addQueen(2,4);
      	n.removeQueen(1,3);
      //	n.removeQueen(1,3);
      System.out.println(n);
    }

}
