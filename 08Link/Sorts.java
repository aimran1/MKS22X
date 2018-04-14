import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	int length = data.size();
	Integer max = data.max();
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>(); 
	}
	for (Integer i:data){
	    
	}
    }
	
    private static int numDigits(int num){
	int  dig = 0;
	while (num >= 1){
	    dig++;
	    num = num / 10;
	}
	return dig;
    }

    public static void main(String[] args){
	System.out.println(numDigits(1234567891));
    }
}

