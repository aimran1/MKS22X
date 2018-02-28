import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    private int rows = 0;
    private int cols = 0;
    
    public Maze(String filename) throws FileNotFoundException{
    	File text = new File(filename + ".dat");
	Scanner in = new Scanner(text);
	String line = "";
	int row = 0;
	while (in.hasNextLine()){
	    line += in.nextLine();
	    rows++;
	    cols = line.length();
	}
	maze = new char[rows][cols];
	maker(line);
    }

    /*  private void maker(String s){
	for (int i = 0; i < s.length();i++,cols++){
	    if (s.charAt(i) == '\n'){
		rows++;
		cols = 0;
	    }else{
		maze[rows][cols] = s.charAt(i);
	    }
	}
	}*/   

    public static void main(String[] args) {
	try{
	    Maze m = new Maze("d1");    
	}catch(FileNotFoundException e){}
    }
}
