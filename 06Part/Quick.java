import java.util.*;
import java.io.*;

public class Quick{

  public static int quickselect(int[] data, int k){
    int upper = data.length-1;
    int lower = 0;
    int index = Partition.partition(data,lower,upper);
    while(index != k){
      /* if (index == k){
        return data[k];
        }*/
      if (index > k){
        upper = index - 1;
      }
      else{
        lower = index + 1;
      }
      index = Partition.partition(data,lower,upper);
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
