import java.util.*;
import java.io.*;

public class MyLinkedList{
    private Node first,  last;
    private int length; 

    public MyLinkedList(){
	first = null;
	last = null;
	length = 0;
    }
    
    public int get(int n){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (i == n){
		return c.getValue();
	    }
	    c = c.getnext();
	}
	return -1;
    }

    public void set(int index, int value){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (i == index){
		c.setValue(value);
	    }
	    c = c.getnext();
	}
    }

    public int size(){
	return length;
    }

    public String toString(){
	String ans = "";
	Node c = first;
	for (int i = 0; i < length; i++){
	    ans += "(" + c.getValue() + ") ";
	    c = c.getnext();
	}
	return ans;
    }

    private class Node{
	private Node next, prev;
	private Integer data;
	
	public Node(Integer d){
	    next = null;
	    prev = null;
	    data = d;
	}
	
	public Node getnext(){
	    return next;
	}
	
	public void setNext(Node a){
	    next = a;
	}
	
	public Node getprev(){
	    return prev;
	}
	
	public void setPrev(Node b){
	    prev = b;
	}
	
	public int getValue(){
	    return data;
	}
	
	public void setValue(int n){
	    data = n;
	}
	
	public String toString(){
	    return "" + data;
	}
    }

    public static void main(String[] args){
	MyLinkedList m = new MyLinkedList();
    }
    
}


/*
public class Literator implements Iterator<String>{
    private int current, end;
    private Node v;

    public Literator(int s, Node d, int e){
      current = s;
      end = e;
      v = d;
    }

    public boolean hasNext(){
      if (current <= end){
        return true;
      }
      return false;
    }

    public Node next(){
      if (hasNext()){
        current++;
      }
      else {
        System.exit(0);
      }
      return v;
    }
}*/
