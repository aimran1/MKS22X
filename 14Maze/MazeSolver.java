import java.util.*;
import java.io.*;

public class MazeSolver{
    private boolean animate = false;
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
	Location finish = maze.getEnd();
	
	frontier.add(here);
	
	while (frontier.hasNext()){
	   
	    System.out.println(maze);

	    Location[] neighs = maze.getNeighbors(here);
	    Location path;
        
	    if(frontier.next() != null){
		    
		    if (here.getX() == maze.getEnd().getX() &&
			here.getY() == maze.getEnd().getY()){
			
			path = here;
		      
			while(path.getPrev() != null){
			    maze.set(path.getX(),path.getY(),'@');
			    path = path.getPrev();
			}
			return true;
		    }
		    else{
			maze.set(here.getX(),here.getY(),'.');
			for (int i = 0; i < 4; i++){
			    frontier.add(neighs[i]);
			    if (neighs[i].getX() < maze.length && neighs[i].getY() < maze[0].length){
			    maze.set(neighs[i].getX(), neighs[i].getY(), '?');
			}
		    }		
		}
	    		here = frontier.next();
			
	}
	
      
	return false;
    }

  public String toString(){
    return maze.toString();
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


    public static void main(String[] args){
	MazeSolver e = new MazeSolver("test.txt");
	System.out.println(e);
	System.out.println(e.maze.getStart());
	System.out.println(e.maze.getEnd());
	e.solve(1);
	System.out.println(e);
    }
}

