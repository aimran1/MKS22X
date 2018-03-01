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
	while (in.hasNextLine()){
	    line += in.nextLine();
	    cols = line.length();
	    rows++;
	}
	maze = new char[rows][cols];
	
	System.out.println(toString());
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

    private void maker(String s){
	for (int i = 0; i < s.length()-1;i++,cols++){
	    if (s.charAt(i) == '\n'){
		rows++;
		cols = 0;
	    }else{
		maze[rows][cols] = s.charAt(i);
	    }
	}
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < rows-1;i++){
	    for (int j = 0; j < cols-1; j++){
		ans += maze[i][j];
	    }
	    ans += '\n'; 
	}
	return ans;
      }

    public static void main(String[] args) {
	try{
	    Maze m = new Maze("d1");    
	}catch(FileNotFoundException e){
	    System.out.println("Are u sure the file's here");
	}
    }
}
