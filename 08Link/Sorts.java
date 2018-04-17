import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();

	if(data.size() < 1){
	    return;
	}
	
	Integer max = data.get(data.max());
	int factor = 1;
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>();
	}
	
	for (Integer i:data){
	    if(i<0){
		neg.add(i);
		data.remove(i);
	    }
	}

	for (int n = 1; n <= numDigits(max); n++){
	    for (Integer m:data){
		arr[m/factor%10].add(m);
	    }
	    factor = factor * 10;
	    data.clear();
	    for (int i = 0; i < 10; i++){
		data.extend(arr[i]);
		arr[i].clear();
	    }
	}
	neg = radixN(neg);
	neg.extend(data);
	data.extend(neg);
    }

    private static MyLinkedListImproved<Integer> radixN(MyLinkedListImproved<Integer> data){
	if(data.size() == 0){
	    return data;
	}
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	Integer min = data.get(data.min());
	int factor = 1;
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>();
	}
	for (int n = 1; n <= numDigits(min); n++){
	    for (Integer m:data){
		arr[9 + m/factor%10].add(m);
	    }
	    factor = factor * 10;
	    data.clear();
	    for (int i = 0; i < 10; i++){
		data.extend(arr[i]);
		arr[i].clear();
	    }
	}
	return data;
    }
    
    private static int numDigits(Integer num){
	int  dig = 0;
	if (num < 0){
	    num = num * -1;
	}
	while (num >= 1){
	    dig++;
	    num = num / 10;
	}
	return dig;
    }

    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
	radixsort(data);
    }

}
