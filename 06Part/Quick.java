import java.util.*;
import java.io.*;

public class Quick{

  public static int quickselect(int[] data, int k){
    int upper = data.length-1;
    int lower = 0;
    int index = -1;
    while(index != k){
      index = Partition.partition(data,lower,upper);
      /* if (index == k){
        return data[k];
        }*/
      if (index > k){
        upper = index - 1;
      }
      else{
        lower = index + 1;
      }
    }
    System.out.println(Arrays.toString(data));
    System.out.println(data[k]);
    return -1;
  }

  public static void main(String[] args){
    int[] d =  {2,10,15,23,0,5};
    quickselect(d,4);

  }

}
