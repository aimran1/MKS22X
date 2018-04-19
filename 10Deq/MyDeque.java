import java.util.*;
import java.io.*;

public class MyDeque<E>{
    private E[] data;
    private int front;
    private int back;
    private int size;
    
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
	if (size == data.length){
	    resize();
	}
	if (front < back){
	    if (front > 0){
		data[front-1] = element;
		front = front - 1;
	    }
	}
	
    }

    private int nextElement(){
	for (int i = front; i < back; i++){
	    if (data[i] != null){
		return 1; 
	    }
	}
	
    }
}
