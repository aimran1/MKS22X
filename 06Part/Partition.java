import java.util.*;
import java.io.*;

public class Partition{

  public static int partition(int[]data,int start,int end){
    Random ind = new Random();
    int index = ind.nextInt((end-start)+1) + start;
    swap(data,0,index);

    end = data.length - 1;
    while (start <= end){
      if (data[start] <= data[0]){
        start++;
      }
      else if (data[start] > data[0]){
        swap(data,start,end);
        end--;
      }
      System.out.println(Arrays.toString(data));
    }

    swap(data,0,end);

    return index;
  }

  private static void swap(int[]ary,int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

  /*  public static void main(String[] args){
    int[] d = {2,12,54,5,8,21,4,545,4,854,12354,2,
               -94,25,3};
    partition(d,3,7);
    }*/

}
