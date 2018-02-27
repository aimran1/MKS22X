import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;

    public Maze(String filename){
	try{
	Scan(filename);
	}catch(FileNotFoundException e){
	    System.out.println("Invalid");
	}
    }

    public void Scan(String filename) throws FileNotFoundException{
	File text = new File(filename + ".dat");
	Scanner in = new Scanner(text);
	char line;
	int row = 0;
	while (in.hasNextLine()){
	    line = in.nextLine();
	    for (int i = 0; i < line.length; i++){
		maze[row][i] = ;
	    }
	}
    }

    public static void main(String[] args) {
	Maze m = new Maze("d1");
    }
}
