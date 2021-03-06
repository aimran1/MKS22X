import java.util.*;
import java.io.*;

public class RunningMedian{

    @SuppressWarnings("unchecked")
    private MyHeap<Double> min = new MyHeap();
    @SuppressWarnings("unchecked")
    private MyHeap<Double> max = new MyHeap(false);
    
    public RunningMedian(){}

    public void add(Double m){
	if (size() == 0){
	    min.add(m);
	}
	else if (m.compareTo(getMedian()) > 0){
	    max.add(m);
	}
	else {
	    min.add(m);
	}
	equalify();
    }

    private void equalify(){
	if (min.size() - max.size() >= 2){
	    max.add(min.remove());
	}
	else if (max.size() - min.size() >= 2){
	    min.add(max.remove());
	}
    }

    public Double getMedian(){

	if (size() == 0){
	    throw new NoSuchElementException();
	}
	if (min.size() == max.size()){
	    return (min.peek() + max.peek()) / 2;
	}
	else if (min.size() > max.size()){
	    return min.peek();
	}
	else {
	    return max.peek();
	}
    }

    public int size(){
	return max.size() + min.size();
    }

    public String toString(){
	return min.peek() + " " + max.peek();
    }

    /*public static void main(String[] args){
	RunningMedian i = new RunningMedian();
	String list = "";
	for (double m = 0.0; m < 8.0; m++){
	    list+= " " + m;
	    i.add(m);
	    System.out.println(i);
	    System.out.println(i.min.size() + " " + i.max.size());

	    System.out.println(i.getMedian());
	    System.out.println("_______________________________");

	}
		    System.out.println(i.getMedian());

	System.out.println(list);
    }*/
    
}
