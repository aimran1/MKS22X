import java.util.*;
import java.io.*;

public class Merge{

  public static int[] merge(int[] a1, int[] a2){
    int[] m = new int[a1.length+a2.length];
    int i1 = 0;
    int i2 = 0;
    int in = 0;
    while(i1 < a1.length || i2 < a2.length){
      if(a1[i1]>a2[i2]){
        m[in] = a2[i2];
        in++;
        i2++;
      }
      else if (a1[i1]==a2[i2]){
        m[in] = a2[i2];
        in++;
        m[in] = a1[i1];
        in++;
        i1++;
        i2++;
      }
      else{
        m[in] = a1[i1];
        i1++;
        in++;
      }
          System.out.println(Arrays.toString(m));

    }
    System.out.println(Arrays.toString(m));
    return m;
  }

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
	int i = 0;
	while(low <= mid && Umid <= hi){
	    if (data[low] < temp[Umid]){
		m[i] = data[low];
		i++;
		low++;
	    }
	    else if (data[low] > temp[Umid]){
		m[i] = temp[Umid];
		i++;
		Umid++;
	    }
	}
	if (low != mid){
	    m[i] = data[mid];
	}
	else if (Umid != hi){
	    m[i] = temp[hi];
	}
    }
    

  public static void main(String[] args){
    int[] l = {1,34,3,455,2,234,2,5,6};
    int[] d = {2,34,34,5,6,87,34,2,78};
    merge(l,d);
  }

}
