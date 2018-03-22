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
    int[] m = new int[data.length+temp.length];
    int i = lo;
    while(lo <= mid && Umid <= hi){
	    if (data[lo] < temp[Umid]){
        m[i] = data[lo];
        i++;
        lo++;
	    }
	    else if (data[lo] > temp[Umid]){
        m[i] = temp[Umid];
        i++;
        Umid++;
	    }
    }
    if (lo != mid){
      for (;lo <= mid;lo++,i++){
        m[i] = data[lo];
      }
    }
    else if (Umid != hi){
      for (;Umid <= hi;Umid++,i++){
        m[i] = temp[Umid];
      }
    }
    data = m;
    System.out.println(Arrays.toString(m));
  }
    

  public static void main(String[] args){
    int[] l = {1,34,3,455,2,234,2,5,6};
    int[] d = {2,34,34,5,6,87,34,2,78};
    // mergesort(l);
    // System.out.println(Arrays.toString(l));
    mergesort(d);
    // System.out.println(Arrays.toString(d));
  }

}
