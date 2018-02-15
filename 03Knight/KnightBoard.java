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

    public boolean solve(int startingRows, int startingCol){

	if (!zero()){
	    throw new IllegalStateException();
	}
	if (startingRows < 0 || startingCols < 0 ||
	    startingRows > board.length || startingCol > board[0].length){
	    throw new IllegalArgumentException();
	}
	
	return solveH(0,0,1);
    }

    public boolean solveH(int row, int col, int level){
	if (countValid(row,col) == 0){
	    return anyValid(row,col);
	}
	for(int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		solveH(board[]
	    }
	}
    }

    public boolean isValid(int row, int col, int newR, int newC){
	if (board[newR][newC] > 0){
	    return false;
	}
	if (newR >= board.size || newR < 0 ||
	    newC >= board[0].size || newC < 0 ||
	    row >= board.size || row < 0 ||
	    col >= board.size || col < 0){
	    return false;
	}
	if ((Math.abs(newR - row == 2 && Math.abs(newC - col == 1))) ||
	    (Math.abs(newC - col == 2 && Math.abs(newR - row == 1)))){
	    return true;
	}
	return false; 
    }

    public int countValid(int row, int col){
	int count = 0;
	if (isValid(row, col, row + 2, col + 1)){
	    count++;
	}
	if (isValid(row, col, row + 1, col + 2)){
	    count++;
	}
	if (isValid(row, col, row - 2, col + 1)){
	    count++;
	}
	if (isValid(row, col, row - 1, col + 2)){
	    count++;
	}
	if (isValid(row, col, row + 2, col - 1)){
	    count++;
	}
	if (isValid(row, col, row + 1, col - 2)){
	    count++;
	}
	if (isValid(row, col, row - 2, col - 1)){
	    count++;
	}
	if (isValid(row, col, row - 1, col - 2)){
	    count++;
	}
	return count;
    }

public boolean anyValid(int row, int col){
    if (isValid(row, col, row + 2, col + 1)){
	return true;
    }
    if (isValid(row, col, row + 1, col + 2)){
	return true;
    }
    if (isValid(row, col, row - 2, col + 1)){
	return true;
    }
    if (isValid(row, col, row - 1, col + 2)){
	return true;
    }
    if (isValid(row, col, row + 2, col - 1)){
	return true;
    }
    if (isValid(row, col, row + 1, col - 2)){
	return true;
    }
    if (isValid(row, col, row - 2, col - 1)){
	return true;
    }
    if (isValid(row, col, row - 1, col - 2)){
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
    
}
