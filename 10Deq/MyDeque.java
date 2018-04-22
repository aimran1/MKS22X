import java.util.*;
import java.io.*;

public class MyDeque<E>{
    private E[] data;
    private int front = -1;
    private int back = 0;
    private int size = 10;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	size = initialCapacity;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
        E[] temp = (E[]) new Object[data.length*2];
	for (int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    public int size(){
	return size;
    }

    public E getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[front];
    }

    public E getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[back];
    }

    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if (front == back + 1){
	    //  resize();
	    return;
	}
	if (front == -1){
	    front = 0;
	}
	else if (front == 0){
	    front = size - 1;
	}
	else {
	    front -= 1;
	}
	data[front] = element;
    }

    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if (front == back + 1){
	    //  resize();
	    return;
	}
	if (front == -1){
	    front = 0;
	}
	else if (back == size - 1){
	    back = 0;
	}
	else {
	    back += 1;
	}
	data[back] = element;
    }

    public E removeFirst(){
	if (front == -1){
	    throw new NoSuchElementException();
	}
	E ans = data[front];
	data[front] = null;
	if(front == size - 1){
	    front = 0;
	}
	else {
	    front += 1;
	}
	return ans;
    }

    public E removeLast(){
	if (front == -1){
	    throw new NoSuchElementException();
	}
	E ans = data[back];
	data[back] = null;
	if(back == 0){
	    back = size - 1;
	}
	else {
	    back -= 1;
	}
	return ans;
    }
    
    public  String toString(){
	String e = "";
	for (int i = 0; i < data.length; i++){
	    e += data[i] + " ";
	}
	return e;
    }
    
    public static void main(String[] args){
	MyDeque<Integer> l = new MyDeque<>();
        for (int i = 0; i < 10; i++){
	    l.addLast(i);
	    System.out.println(l);

	    System.out.println(l.getLast());

	}
	System.out.println(l);
    }

}
