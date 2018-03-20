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

  public static void main(String[] args){
    int[] l = {1,34,3,455,2,234,2,5,6};
    int[] d = {2,34,34,5,6,87,34,2,78};
    merge(l,d);
  }

}
