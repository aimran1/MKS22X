import java.util.*;
import java.io.*;

public class Partition{

  public static int partition(int[]data,int start,int end){
    Random ind = new Random();
    int index = ind.nextInt((end-start)+1) + start;
    System.out.println(index);
    return index;
  }

  public static void main(String[] args){
    int[] d = {2,12,54,5,8,21,4,545,4,854};
    partition(d,3,7);
  }

}
