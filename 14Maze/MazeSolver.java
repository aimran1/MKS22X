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
      frontier.add(maze.getStart());
      
      while (frontier.hasNext()){
	  Location here = frontier.next();
	  Location[] neighs = maze.getNeighbors(here);

	  for (int i = 0; i < 4; i++){
	      if (neighs[i].getX() == maze.getEnd().getX() &&
		  neighs[i].getY() == maze.getEnd().getY()){
		  return path(neighs[i]);
	      }
	      else{
		  frontier.add(neighs[i]);
		  maze.set(neighs[i].getX(), neighs[i].getY(), '?');
	      }
	  }
      }
      
      
    return false;
  }

    private boolean path(Location loc){
	while(loc.getX() != maze.getStart().getX() &&
	      loc.getY() != maze.getStart().getY()){
	    maze.set(loc.getX(),loc.getY(),'@');
	    loc = loc.getPrev();
	}
	System.out.println(maze);
	return true;
    }

  public String toString(){
    return maze.toString();
  }
}

