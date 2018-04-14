import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	int length = data.size();
	Integer max = data.get(data.max());
	int factor = 1;
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>(); 
	}
	
	for (int n = 1; n <= numDigits(max); n++){
	    System.out.println(n);
	    System.out.println(max);
	    for (Integer m:data){
		System.out.println("_________________");
		System.out.println(m/factor%10);
		System.out.println(m);
		System.out.println("_________________");
		arr[m/factor%10].add(m);
	    }
	    factor = factor * 10;
	    data.clear();
	    for (int i = 0; i < 10; i++){
		data.extend(arr[i]);
		arr[i].clear();
	    }
	    
	}
    }
	
    private static int numDigits(Integer num){
	int  dig = 0;
	while (num >= 1){
	    dig++;
	    num = num / 10;
	}
	return dig;
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
	Random m = new Random();
	for (int i = 0; i < 10;i++){
	    l.add(m.nextInt(2000));
	}
	System.out.println(l);
	radixsort(l);
	System.out.println(l);
    }
}

