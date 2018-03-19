import java.util.*;
import java.io.*;

public class Quick{

  //-------------------QUICKSELECT--------------------
  public static int quickselect(int[] data, int k){
    int upper = data.length-1;
    int lower = 0;
    int[] index = partition(data,lower,upper);

    while(index[0] > k || index[1] < k){
      if (index[0] < k){
        lower = index[1] + 1;
      }
      else if (index[1] > k){
        upper = index[0] - 1;
      }
      index = partition(data,lower,upper);
    }

    return data[index[0]];
  }

  //---------------QUICKSORT & QUICKHElPER-----------------
  public static void quicksort(int[] ary){
    quickH(ary,0,ary.length-1);
  }

  private static void quickH(int[] ary, int lower, int upper){
    if (lower < upper){
      int[] i = partition(ary,lower,upper);
      quickH(ary,lower,i[0]-1);
      quickH(ary,i[1]+1,upper);
    }
  }

  //--------------------------PARTITION------------------------
  private static int[] partition(int[]data,int start,int end){

    //-----------Variables to keep track----------
    Random ind = new Random();
    int[] range = new int[2];
    int index = ind.nextInt((end-start)+1) + start;
    int p = data[index];
    int begin = start;
    start++;

    swap(data,index,begin);

    while (start <= end){
      if (data[start] == p){
        start++;
      }
      else if (data[start] < p){
        swap(data,start,begin);
        begin++;
        start++;
      }
      else{
        swap(data,start,end);
        end--;
      }
    }

    range[0] = begin;
    range[1] = end;

    return range;
  }

  //---------------------SWAP-----------------------
  private static void swap(int[]ary,int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

}
