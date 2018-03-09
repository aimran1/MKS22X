import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{

      //------------Setup-------------
      File l = new File(filename);
      Scanner in = new Scanner(l);
      // String line = in.nextLine();
      int R, C, E, N;
      R = in.nextInt();
      C = in.nextInt();
      E = in.nextInt();
      N = in.nextInt();
      int[][] lake = new int[R][C];
      int[][] cows = new int[3][3];
      for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
          lake[i][j] = in.nextInt();
        }
      }
      System.out.println(toString(lake));

      
      while (in.hasNext()){
        int rs = in.nextInt()-1;
        int cs = in.nextInt()-1;
        int ds = in.nextInt();
        int max = 0;
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
              cows[i][j] = lake[rs+i][cs+j];
          }
        }

        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
             if (cows[i][j] > max){
               max = cows[i][j];
            }
          }
        }

                      System.out.println(toString(cows));

        
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (max - cows[i][j] < ds){
              lake[rs+i][cs+j] = max - ds;
              cows[i][j] = lake[rs+i][cs+j];
            }
          }
        }

        System.out.println(toString(cows));



      }


      
      System.out.println(toString(lake));

      int depth = 0;
      for (int i = 0; i < lake.length; i++){
        for (int j = 0; j < lake[0].length; j++){
          if (E - lake[i][j] > 0){
            depth += E - lake[i][j];
            
          }
        }
      }

      return 72*72*depth;
    }

  public static  String toString(int[][] arr){
    String sol = "";
    for (int i = 0; i < arr.length; i ++){
      sol+= "\n";
      for (int j = 0; j <arr[0].length; j++){
        sol+= arr[i][j] + " ";
      }
    }
    return sol;
  }
  
  public static void main (String[] args){
   try{
     System.out.println(bronze("d1.txt"));
   }catch(FileNotFoundException e){}
  }

}
