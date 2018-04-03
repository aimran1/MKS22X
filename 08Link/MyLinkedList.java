import java.util.*;
import java.io.*;

public class MyLinkedList{
    private Node first, last;
    private int length; 

    public MyLinkedList(){
	first = new Node(null);
	last = first;
	length = 0;
    }
    
    private Node getNode(int n){
	Node c = first;

	if(n == length){
	    return last;
	}
	
	for (;n > 0; n--){
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
	    if (c.getValue().equals(value)){
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

    public boolean add(Integer newData){
	Node n = new Node(newData);
	if (length == 0){
	    first = n;
	    last = n;
	}
	else{
	    Node c = getNode(length);
	    n.setPrev(c);
	    c.setNext(n);
	    last = n;
	}
	length += 1;
	return true;
    }

    public void add (int index, Integer value){
	Node n = new Node(value);
	if (length == 0 || index == length){
	    add(value);
	}
	else {
	    if (index == 0){
		first.setPrev(n);
		n.setNext(first);
		first = n;
	    }
	    else{
		Node c = getNode(index);
		Node cp = c.getprev();
		n.setNext(c);
		n.setPrev(cp);
		c.setPrev(n);
		cp.setNext(n);
	    }
	    length += 1;
	}
    }

    public boolean remove(Integer value){
	Node n;
	int i = indexOf(value);
	if (i > -1){
	    
	    n = getNode(i);
	    n.getprev().setNext(n.getnext());
	    n.getnext().setPrev(n.getprev());
	    length -= 1;
	}
	return false;
    }

    /* public boolean remove(int index){
	
       }*/
    
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
	
	public Integer getValue(){
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
	Random n = new Random();
	for (int i = 0; i < 10; i++){
	    Integer l = n.nextInt(20);
	    m.add(l);
	}
	m.add(9, 30303);
	m.add(5, 30303);

       	System.out.println(m);
	Integer f = new Integer(30303);
	
	m.remove(f);
	System.out.println(m);    
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
