import java.util.*;
import java.io.*;

public class Partition{

  public static int partition(int[]data,int start,int end){
    Random ind = new Random();
    int index = ind.nextInt((end-start)+1) + start;
    int p = data[index];
    int begin = start;
    start++;
    end = data.length - 1;
    System.out.println("Chosen Number: " + data[index] + " Index: " + index);

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

    System.out.println("Sorted: " + Arrays.toString(data));
    return end;
  }

  private static void swap(int[]ary,int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

    public static void main(String[] args){
      int[] d =  {2,12,4,4,4,12354,545,4,54,5,8,8,8,21,4,545,4,854,12354,2,
                  -94,25,3,3};
      // Random ind = new Random();
  /* for (int i = 0; i < d.length; i++){
    d[i] = Math.abs(ind.nextInt(3));
    }*/
  System.out.println("Primary: " + Arrays.toString(d));
    partition(d,0,d.length-1);
    }

}
