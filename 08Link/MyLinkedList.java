import java.util.*;
import java.io.*;

public class MyLinkedList{
    Node first;
    Node last;
    int length;

    public int get(int n){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (i == n){
		return c.getValue();
	    }
	    c = c.next();
	}
	return -1;
    }

    public void set(int index, int value){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (i == index){
		c.setValue(value);
	    }
	    c = c.next();
	}
    }

    public int size(){
	return length;
    }

    private class Node{
	Node next, prev;
	int data;
	
	public Node(Node n, Node p, int d){
	    next = n;
	    prev = p;
	    data = d;
	}
	
	public Node next(){
	    return next;
	}
	
	public void setNext(Node a){
	    next = a;
	}
	
	public Node prev(){
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
	    return "p:" + prev+ " c:" + data + " n:" + next;
	}
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
