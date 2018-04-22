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
	System.out.println(data.length);
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
	if (front == back + 1){
	    //  resize();
	    return;
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
	if (front == -1){
	    throw new NoSuchElementException();
	}
	size--;
	E ans = data[front];
	if (size == 1){
	    data[front] = null;
	    front = -1;
	    back = 0;
	}
	else {
	    data[front] = null;
	    if(front == data.length - 1){
		front = 0;
	    }
	    else {
	    front += 1;
	    }
	}
	return ans;
    }

    public E removeLast(){
	if (front == -1){
	    throw new NoSuchElementException();
	}
	if (size == 1){
	    data[front] = null;
	    front = -1;
	    back = 0;
	}
	E ans = data[back];
	data[back] = null;
	if(back == 0){
	    back = data.length - 1;
	}
	else {
	    back -= 1;
	}
	size--;
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

    public static void main (String[] args){
	MyDeque<Integer> l = new MyDeque<>();
	for (int i = 0; i < 5; i++){
	    l.addFirst(i);
	    System.out.println(l.getFirst());
	}
	System.out.println(l);
	l.removeFirst();
	System.out.println(l);
	l.removeFirst();
	System.out.println(l);l.removeFirst();
	System.out.println(l);l.removeFirst();
	System.out.println(l);l.removeFirst();
	System.out.println(l);
	for (int i = 5; i < 11; i++){
	    l.addLast(i);
	    System.out.println(l.getLast());
	}
	System.out.println(l);
	      
    }
}
