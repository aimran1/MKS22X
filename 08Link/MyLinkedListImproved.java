import java.util.*;
import java.io.*;

public class MyLinkedListImproved<T>{
    private Node first, last;
    private int length; 

    //Constructor
    public MyLinkedListImproved(){
	first = new Node(null);
	last = first;
	length = 0;
    }

    //ToString
    public String toString(){
	String ans = "";
	Node c = first;
	for (int i = 0; i < length; i++){
	    ans += "(" + c.getValue() + ") ";
	    c = c.getnext();
	}
	return ans;
    }

    //Reverse
    public String toStringR(){
	String ans = "";
	Node c = last;
	for (int i = 0; i < length; i++){
	    ans += "(" + c.getValue() + ") ";
	    c = c.getprev();
	}
	return ans;
    }

    //Clear
    public void clear(){
	first = null;
	last = null;
	length = 0;
    }

    
    //Size
    public int size(){
	return length;
    }

    //Gets Node at index n
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

    //Gets value of Node at index
    public T get(int index){
	return getNode(index).getValue();	
    }
    //Sets value of Node at index
    public T set(int index, T value){
	getNode(index).setValue(value);
	return value;
    }

    //Returns index of value
    public int indexOf(T value){
	Node c = first;
	for (int i = 0; i < length; i++){
	    if (c.getValue().equals(value)){
		return i;
	    }
	    c = c.getnext();
	}
	return -1;
    }


    //-------------------Adds--------------------
    public boolean add(T newData){
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

    public void add (int index, T value){
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

    //--------------------Removes-------------------
    public boolean remove(T value){
	Node n;
	int i = indexOf(value);
        return remove(i);
    }

    public boolean remove(int index){
	Node n = getNode(index);
	if (index >= 0 && index <= length){
	    length -= 1;
	    if (index == 0){
		first = first.getnext();
		return true;
	    }
	    else if (index == length){
		last = last.getprev();
		return true;
	    }
	    else {
		n.getprev().setNext(n.getnext());
		n.getnext().setPrev(n.getprev());
		return true;
	    }
	}
	return false;
    }


    //---------------------------NODE-------------------------
    private class Node{
	private Node next, prev;
	private T data;
	
	public Node(T d){
	    next = null;
	    prev = null;
	    data = d;
	}

	//Next
	public Node getnext(){
	    return next;
	}
	public void setNext(Node a){
	    next = a;
	}

	//Previous
	public Node getprev(){
	    return prev;
	}
	public void setPrev(Node b){
	    prev = b;
	}

	//Value
	public T getValue(){
	    return data;
	}
	public void setValue(T n){
	    data = n;
	}
	
	public String toString(){
	    return "" + data;
	}
    }

    public static void main(String[] args){
	MyLinkedListImproved<String> m = new MyLinkedListImproved<>();
	Random n = new Random();
	//for (int i = 0; i < 10; i++){
	    // Integer l = n.nextInt(20);
	// m.add(i);
	    //	}
	m.add("dog");
	m.add("ca");
	m.add("go");
	m.add("fish");
	m.add("la");
	m.add(0,"st");
	m.add(5,"rt");

       	System.out.println(m);
	System.out.println(m.toStringR());    
    }
    
}
