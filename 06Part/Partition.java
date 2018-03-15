import java.util.*;
import java.io.*;

public class Partition{

  public static int partition(int[]data,int start,int end){
    Random ind = new Random();
    int index = ind.nextInt((end-start)+1) + start;
    int begin = start;
    swap(data,begin,index);
    start++;
    int equal = 0;
    end = data.length - 1;

    while (start <= end){
      if (data[start] == data[begin]){
        equal++;
        swap(data,begin+equal,start);
        start++;
      }
      else if (data[start] < data[begin]){
        start++;
      }
      else if (data[start] > data[begin]){
        swap(data,start,end);
        end--;
      }
    }

    swap(data,begin,end);

    if(equal != 0) {
      for (int i = 1; equal > 0; equal--,i++){
        swap(data,begin+equal,end-i);
      }
    }

    return end;
  }

  private static void swap(int[]ary,int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

    public static void main(String[] args){
    int[] d = {2,12,4,4,4,12354,545,4,54,5,8,8,8,21,4,545,4,854,12354,2,
               -94,25,3,3};
    partition(d,0,7);
    }

}
