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
    
    private Node getNode(int n){
	Node c = first;
	for (int i = 0; i < n; i++){
	    c = c.getnext();
	}
	return c;
    }

    public void clear(){
	first = null;
	last = null;
	length = 0;
    }

    public Integer get(int index){
	return getNode(index).getValue();	
    }

    public Integer set(int index, Integer value){
	getNode(index).setValue(value);
	return value;
    }

    public int indexOf(Integer value){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (c.getValue() == value){
		return i;
	    }
	    c = c.getnext();
	}
	return -1;
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
