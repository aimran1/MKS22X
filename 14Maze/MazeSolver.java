import java.util.*;
import java.io.*;

public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
      if (mode == 0){
	  frontier = new FrontierQueue();
      }
      else if(mode == 1){
	  frontier = new FrontierStack();
      }
      Location here = maze.getStart();
      frontier.add(here);
      System.out.println(frontier);
      
      while (frontier.hasNext()){
	  Location[] neighs = maze.getNeighbors(here);
	  System.out.println(Arrays.toString(neighs));
	  for (int i = 0; i < 4; i++){
	      Location path;
	      if(neighs[i] != null){

		  if (neighs[i].getX() == maze.getEnd().getX() &&
		      neighs[i].getY() == maze.getEnd().getY()){
		      path = new Location(neighs[i].getPrev().getX(), neighs[i].getPrev().getY(), neighs[i].getPrev().getPrev());
		      
		      while(path.getX() != maze.getStart().getX() &&
			    path.getY() != maze.getStart().getY()){			  		      System.out.println("Got in");

			  maze.set(path.getX(),path.getY(),'@');
			  path = path.getPrev();
		      }
		      return true;
		  }
		  else{
		      frontier.add(neighs[i]);
		      maze.set(neighs[i].getX(), neighs[i].getY(), '?');
		  }
		  here = frontier.next();
	      }
	  }
      }
      
      
    return false;
  }

  public String toString(){
    return maze.toString();
  }

    public static void main(String[] args){
	MazeSolver e = new MazeSolver("test.txt");
	System.out.println(e);
	System.out.println(e.solve(0));
	System.out.println(e);
    }
}

