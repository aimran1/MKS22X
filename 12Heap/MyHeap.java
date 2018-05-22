import java.util.*;
import java.io.*;

public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private boolean ismax;
    private int length = 0;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[]) new Comparable[10];
	ismax = true;

    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
	if (max){
	    ismax = true;
	}
	else{
	    ismax = false;
	}
	heap = (T[]) new Comparable[10];
    }

    public int size(){
	return length;
    }

    public T peek(){
	return heap[0];
    }

    private void pushDown(int i){
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	if (left < length-1){
	    if (ismax && heap[left].compareTo(heap[i]) > 0 && heap[left].compareTo(heap[right]) >= 0){
		swap(heap,left,i);
		pushDown(left);
	    }
	    else if (!ismax && heap[left].compareTo(heap[i]) < 0 && heap[left].compareTo(heap[right]) <= 0){
		swap(heap,left,i);
		pushDown(left);
	    }
	}
	if (right < length-1){
	    if (ismax && heap[right].compareTo(heap[i]) > 0){
		swap(heap,right,i);
		pushDown(right);
	    }   
	    else if (!ismax && heap[right].compareTo(heap[i]) < 0){
		swap(heap,right,i);
		pushDown(right);
	    }
	}

    }

    public T remove(){
	T ans = heap[0];
	swap(heap, 0, length - 1);
	pushDown(0);
	length--;
	if (length == 0){
	    heap[0] = null;
	}
	return ans;
    }

    private void pushUp(int i){
	int parent = (i - 1) / 2;
	if (ismax && heap[parent].compareTo(heap[i]) < 0){
	    swap(heap,parent,i);
	    pushUp(parent);
	}
      	else if (!ismax && heap[parent].compareTo(heap[i]) > 0){
	    swap(heap,parent,i);
	    pushUp(parent);
	}
    }

    public void add(T str){
	if (length == heap.length){
	    resize();
	}
	heap[length] = str;
	pushUp(length);
	length++;
    }
    
    private void swap(T[]ary,int a, int b){
	T c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[]) new Comparable[heap.length * 2];
	for (int i = 0; i < heap.length; i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < length; i++){
	    ans += heap[i] + " ";
	}
	return ans;
    }
    
}
