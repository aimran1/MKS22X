import java.util.*;
import java.io.*;

public class Quick{

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

    System.out.println(data[index[0]]);
    return data[index[0]];
  }

  public static int[] partition(int[]data,int start,int end){
    Random ind = new Random();
    int[] range = new int[2];
    int index = ind.nextInt((end-start)+1) + start;
    int p = data[index];
    int begin = start;
    start++;
    end = data.length - 1;

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

  private static void swap(int[]ary,int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

  public static void main(String[] args){
    int[] d =  {2,10,15,23,0,5,10,23,2};
    Arrays.sort(d);
    System.out.println(Arrays.toString(d));
    quickselect(d,0);
    quickselect(d,1);
    quickselect(d,2);
    quickselect(d,3);
    quickselect(d,4);
    quickselect(d,5);

  }

}
