import java.util.*;
import java.io.*;

public class MyDeque<E>{
    private E[] data;
    private int front;
    private int back;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
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

    public 

}
