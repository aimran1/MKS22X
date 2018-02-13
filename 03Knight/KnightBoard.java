public class KnightBoard{

    private int[][] board;
    
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
    }

    public String toString(){
	String b = "";
	for (int i = 0; i < board.length; i++){
	    b+= "\n";
	    for (int j = 0; j < board[i].length; j++){
		if (board[j][i] <10){
		    b += "  " + board[j][i];
		}
		else{
		    b += " " + board[j][i];
		}
	    }
	}
    }
    
}
