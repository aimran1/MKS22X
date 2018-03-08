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

      while (in.hasNext()){
        int rs = in.nextInt();
        int cs = in.nextInt();
        int ds = in.nextInt();
        int max = lake[rs][cs];
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            try{
              cows[i][j] = lake[rs+i][cs+j];
            }catch(ArrayIndexOutOfBoundsException e){System.out.println((rs + i) + " " +cs + j);}
          }
        }

        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
             if (cows[i][j] > max){
               max = cows[i][j];
            }
          }
        }

        while(ds > 0){
          for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
              if (cows[i][j] == max){
                cows[i][j] = max - 1;
                lake[rs+i][cs+j] = cows[i][j];
              }
            }
          }
          ds--;
        }
      }

      int depth = 0;
      for (int i = 0; i < lake.length; i++){
        for (int j = 0; j < lake[0].length; j++){
          depth += lake[i][j];
        }
      }

      return 72*72*depth;
    }
    
  public static void main (String[] args){
   try{
     bronze("d1.txt");
   }catch(FileNotFoundException e){}
  }

}
