import java.util.*;
import java.io.*;

public class MyLinkedList{
    private Node first, last;
    private int length; 

    //Constructor
    public MyLinkedList(){
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
    public Integer get(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();	
    }
    //Sets value of Node at index
    public Integer set(int index, Integer value){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	getNode(index).setValue(value);
	return value;
    }

    //Returns index of value
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


    //-------------------Adds--------------------
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
	if (index < 0 || index > length){
	    throw new IndexOutOfBoundsException();
	}
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
    public boolean remove(Integer value){
	Node n;
	int i = indexOf(value);
        try{
	    remove(i);
	    return true;
	}catch(IndexOutOfBoundsException e){
	    return false;
	}
    }

    public Integer remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Node n = getNode(index);
	Integer v = n.getValue();
	length -= 1;
	if (index == 0){
	    first = first.getnext();
	}
	else if (index == length){
	    last = last.getprev();
	}
	else {
	    n.getprev().setNext(n.getnext());
	    n.getnext().setPrev(n.getprev());
	}
	return v;
    }


    //---------------------------NODE-------------------------
    private class Node{
	private Node next, prev;
	private Integer data;
	
	public Node(Integer d){
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
}
