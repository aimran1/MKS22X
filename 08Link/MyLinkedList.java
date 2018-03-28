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
	    c = first.next();
	}
	return -1;
    }

    
    
}

private class Node{
    Node next, prev;
    int data;

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
	return "p:" + prev+ " c:" data + " n:" + next;
    }
}
