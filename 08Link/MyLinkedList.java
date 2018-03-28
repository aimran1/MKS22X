public class MyLinkedList{
    Node first;
    Node last;
    int length;

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
