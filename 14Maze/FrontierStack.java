import java.util.*;
import java.io.*;

public class FrontierStack implements Frontier{

    private LinkedList<Location> e;

    public FrontierStack(){
	e = new LinkedList<Location>();
    }
    
    public Location next(){
	if (!hasNext()){
	    throw new NullPointerException();
	}
	return e.removeLast();
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
