import java.util.*;
import java.io.*;

public class Merge{

  public static void mergesort(int[] data){
    msort(data, new int[data.length], 0, data.length-1);
  }

  private static void msort(int[] data, int[] temp, int lo, int hi){
      int mid = (hi + lo)/2;
      
      if (lo < hi){
	  for (int i = lo; i <= hi;i++){
	      temp[i] = data[i];
	  }
	  msort(temp,data,lo,mid);
	  msort(temp,data,mid+1,hi);
      }
      merge(data,temp,lo,mid,mid+1,hi);
  }

    private static void merge(int[]data,int[]temp,int lo, int mid, int Umid, int hi){
    for(int i = lo;i < hi; i++){
	if(lo <= mid){
	    if (temp[lo] < temp[Umid]){
		data[i] = temp[lo];
		lo++;
	    }
	    else {
		data[i] = temp[Umid];
		Umid++;
	    }
	}
    }
    
    System.out.println(Arrays.toString(data));
  }
    

  public static void main(String[] args){
      // int[] l = {1,34,3,455,2,234,2,5,6};
    int[] d = {2,34,34,5,6,87,34,2,78};
    // mergesort(l);
    // System.out.println(Arrays.toString(l));
    mergesort(d);
    // System.out.println(Arrays.toString(d));
  }

}
