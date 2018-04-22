import java.util.*;
import java.io.*;

public class MyDeque<E>{
    private E[] data;
    private int front = -1;
    private int back = 0;
    private int size = 0;
    
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
	if (front <= back){
	    int m = -1;
	    for (int i = front; i <= back; i++, m++){
		temp[i] = data[i];
	    }
	    front = 0;
	    back = m;
	}
	else{
	    int m = 0;
	    for (int i = front; i < data.length; i++,m++){
		temp[m] = data[i];
	    }
	    for (int i = 0; i <= back; i++, m++){
		temp[m] = data[i];
	    }
	    front = 0;
	    back = m-1;
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
	if (front == -1){
	    front = 0;
	}
	else if (front == 0){
	    front = data.length - 1;
	}
	else {
	    front -= 1;
	}
	data[front] = element;
	size++;
    }

    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize();
	}
	if (front == -1){
	    front = 0;
	}
	else if (back == data.length - 1){
	    back = 0;
	}
	else {
	    back += 1;
	}
	data[back] = element;
	size++;
    }

    public E removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size--;
	E ans = data[front];
	data[front] = null;
	if(front == data.length - 1){
	    front = 0;
	}
	else {
	    front += 1;
	}
	return ans;
    }

    public E removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size--;
	E ans = data[back];
	data[back] = null;
	if(back == 0){
	    back = data.length - 1;
	}
	else {
	    back -= 1;
	}
	return ans;
    }

    public String toString(){
	String ans = "[";
	if(front < back){
	    for (int i = front; i <= back; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = front; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= back; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }


}
