import java.util.*;
import java.io.*;

public class FrontierQueue implements Frontier{

    private LinkedList<Location> e;

    public FrontierQueue(){
	e = new LinkedList<Location>();
    }
    
    public Location next(){
	if (!hasNext()){
	    throw new NullPointerException();
	}
	return e.removeFirst();
    }

    public void add(Location n){
	e.add(n);
    }

    public boolean hasNext(){
	if (e.size() > 0){
	    return true;
	}
	return false;
    }

}
