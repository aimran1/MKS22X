import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private boolean animate;
  private int[] sLoc = new int[2];
  private int[] x = {0,0,1,-1};
  private int[] y = {1,-1,0,0};
  private int rows = 0;
  private int cols = 0;
    
  public Maze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner in = new Scanner(text);
    Scanner m = new Scanner(text);
    String line = "";
    while (in.hasNextLine()){
	    line = in.nextLine();
	    cols = line.length();
	    rows++;
    }
    maze = new char[rows][cols];
    for (int i = 0; m.hasNextLine(); i++){
      String c = m.nextLine();
      for(int j = 0; j < c.length(); j++){
        maze[i][j] = c.charAt(j);
      }
    }
    isValid();
    System.out.println(toString());
  }

  public int solve(){
    maze[sLoc[0]][sLoc[1]] = ' ';
    return solve(sLoc[0],sLoc[1],0);
  }

  private int solve(int row, int col, int moves){
    if (animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    
    if (maze[row][col] == 'E'){
      return moves;
    }

    if (maze[row][col] == ' '){
      maze[row][col] = '@';
    }

    else{
      return -1;
    }

    for (int i = 0; i < 4; i++){
      int sol = solve(row+x[i], col+y[i],moves++);
      if (sol > 0){
        return sol;
      }
    }
    maze[row][col] = '.';
    return -1;
  }

  public boolean isValid(){
    int s = 0;
    int e = 0;
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        if(maze[i][j] == 'S'){
          s++;
          sLoc[0] = i;
          sLoc[1] = j;
        }
        if(maze[i][j] == 'S'){
          e++;
        }
      }
    }
    if (s != 1 && e != 1){
      throw new IllegalStateException();
    }
    return true;
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
    for (int i = 0; i < rows;i++){
	    for (int j = 0; j < cols; j++){
        ans += maze[i][j];
	    }
	    ans += '\n'; 
    }
    return ans;
  }
  
  public static void main(String[] args) {
    try{
	    Maze m = new Maze("d3.dat");
      m.solve();
      System.out.println("Final State:");
      System.out.println(m);
    }catch(FileNotFoundException e){
	    System.out.println("Are u sure the file's here");
    }
  }
}
