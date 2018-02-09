public class QueenBoard{

    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }
    
    private boolean addQueen(int r, int c){
	if (board[r][c] >= 0){
	    board[r][c] = -1;
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] < 0){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }

    public String toString(){
	String b = "";
	for (int i = 0; i < board.length; i++){
	    b = b + "\n";
	    for (int j = 0; j < board[i].length; j++){
		if (board[i][j] < 0){
		    b = b + " " + "Q";
		}else {
		    b = b + " " + "_";
		}
	    }
	}
	return b;
    }

    public static void main (String[] args){
	QueenBoard n = new QueenBoard(5);
	System.out.println(n);
    }

}
