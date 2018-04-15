import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr = new MyLinkedListImproved[10];
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] neg = new MyLinkedListImproved[10];
	int length = data.size();
	Integer max = data.get(data.max());
	int factor = 1;
	for (int i = 0; i < 10; i++){
	    arr[i] = new MyLinkedListImproved<Integer>();
	    neg[i] = new MyLinkedListImproved<Integer>();
	}
	System.out.println("Outside works");
	for (int n = 1; n <= numDigits(max); n++){
	    System.out.println("Inside 1 works");
	    for (Integer m:data){
		System.out.println(m);
		if (m.compareTo(0) < 0){
		    System.out.println(10 + m/factor%10);
		    System.out.println(m);
		    System.out.println("________________________");
		    neg[10 + (m/factor%10)].add(m);
		}
		else{
		    arr[m/factor%10].add(m);
		}
	    }
	    factor = factor * 10;
	    data.clear();
	    for (int i = 0; i < 10; i++){
		data.extend(neg[i]);
		neg[i].clear();
	    }
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
	for(int i = 0; i < 10; i++){
	    l.add(-1 * m.nextInt(200));
	}
	System.out.println(l);
	radixsort(l);
	System.out.println(l);
    }
    /* public static void main(String[] args) {
    //-----------SORTING POSITIVES-----------
       // System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
    MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
    int[] correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    long end,start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    //  System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    boolean hasError = false;
    int index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
	  //    System.out.println("THERE IS AN ERROR");
	  //     System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
	//     System.out.println("Your LinkedList with all positive integers is properly sorted.");
    }
    else{
	//  System.out.println(data);
    }
    //  System.out.println("\n");


    //-----------SORTING NEGATIVES-----------
    System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
    data.clear();
    correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      temp *= -1;
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with all negative numbers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVES AND NEGATIVES-----------
    System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
    data.clear();
    correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      if((int)(Math.random() * 1000) % 2 == 0){
        temp *= -1;
      }
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING EMPTY LISTS-----------
    System.out.println("SORTING ON EMPTY LISTS");
    data.clear();
    correctData = new int[0];

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your empty LinkedList is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    int temp = (int)(Math.random() * 1000);
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one positive element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    temp = (int)(Math.random() * 1000) * -1;
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one negative element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    }*/

}
