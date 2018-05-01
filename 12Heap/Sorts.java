import java.util.*;
import java.io.*;

public class Sorts{

    private static MyHeap<Integer> h = new MyHeap<>();
    
    public static void heapSort(Integer[] m){
	heapify(m);
	for (int i = 0; i < m.length; i++){
	    m[m.length-1-i] = h.remove();
	}
	if (m[0] > m[1]){
	    Integer temp = new Integer(m[1]);
	    m[1] = m[0];
	    m[0] = temp;
	}
    }

    public static void heapify(Integer[] m){
	for (int i = 0; i < m.length; i++){
	    h.add(m[i]);
	}
    }

    /*public static void main(String[] args){
	Integer[] l = new Integer[12];
	Random f = new Random();
	for (int i = 0; i < 12; i++){
	    l[i] = f.nextInt(100);
	}
	heapSort(l);
    }*/
    
}
