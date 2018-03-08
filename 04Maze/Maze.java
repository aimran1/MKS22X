import java.util.*;
import java.io.*;

public class Maze{

  private char[][]maze;
  private boolean animate = false;
  private int[] sLoc = new int[2];
  private int[] x = {0,0,1,-1};
  private int[] y = {1,-1,0,0};
  private int rows = 0;
  private int cols = 0;

  //---------------------------Constructor-----------------------------
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
  }

  //-----------------------------Solve Methods-------------------------
  public int solve(){
    maze[sLoc[0]][sLoc[1]] = ' ';
    return solve(sLoc[0],sLoc[1],0);
  }

  private int solve(int row, int col, int moves){
    /* if (animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
      }*/
    
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

  //----------------Helper to Check Board State-------------------
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
        if(maze[i][j] == 'E'){
          e++;
        }
      }
    }
    if (s != 1 && e != 1){
      throw new IllegalStateException();
    }
    return true;
  }

  //----------------------Animation Code---------------------------
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

}
