import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	int length = data.size();
	Integer max = data.max();
	int dig = numDigits(max);
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>(); 
	}
	for (int n = 1; n <= dig; n++){
	    for (Integer m:data){
		Integer loc = m%10;
		arr[loc].add(m);
	    }
	}

	String ans = "";
	for (int i = 0; i < 10;i++){
	    ans += "" + i +arr[i] + "\n";
	}
	System.out.println(ans);
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
	    l.add(m.nextInt(20));
	}
	System.out.println(l);
	radixsort(l);
    }
}

