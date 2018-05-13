import java.util.*;
import java.io.*;

public class FrontierPriorityQueue implements Frontier{

    @SuppressWarnings("unchecked")
    private MyHeap<Location> e;

    @SuppressWarnings("unchecked")
    public FrontierPriorityQueue(){
	e = new MyHeap(false);
    }
    
    public Location next(){
	if (!hasNext()){
	    throw new NullPointerException();
	}
	return e.remove();
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

    public String toString(){
	return e.toString();
    }

}
