import java.util.*;
import java.io.*;

public class Merge{

 

  public static void mergesort(int[] data){
    msort(data, new int[data.length], 0, data.length-1);
  }

  private static void msort(int[] data, int[] temp, int lo, int hi){
    if (lo >= hi){
	    return;
    }
    temp = data;
    int mid = (hi - lo)/2 + lo;
    msort(temp,data,lo,mid);
    msort(temp,data,mid+1,hi);
    merge(data,temp,lo,mid,mid+1,hi);
  }

  private static void merge(int[]data,int[]temp,int lo, int mid, int Umid, int hi){
    int i = lo;
    while(lo <= mid && Umid <= hi){
	    if (temp[lo] <= temp[Umid]){
        data[i] = temp[lo];
        i++;
        lo++;
	    }
	    else if (temp[lo] > temp[Umid]){
        data[i] = temp[Umid];
        i++;
        Umid++;
	    }
    }
    for (;lo <= mid;lo++,i++){
        data[i] = temp[lo];
    }
    
    for (;Umid <= hi;Umid++,i++){
      data[i] = temp[Umid];
    }
  }
    

  public static void main(String[] args){
    int[] l = {1,34,3,455,2,234,2,5,6};
    int[] d = {2,34,34,5,6,87,34,2,78};
    // mergesort(l);
    // System.out.println(Arrays.toString(l));
    mergesort(d);
    System.out.println(Arrays.toString(d));
  }

}
