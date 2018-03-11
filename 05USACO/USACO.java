import java.util.*;
import java.io.*;

public class USACO{

  public static int R;
  public static int C;
  
    public static int bronze(String filename) throws FileNotFoundException{

      //------------Setup-------------
      File l = new File(filename);
      Scanner in = new Scanner(l);
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

      //--------------Reads Through All Instructions----------------
      for (int n = 0; n < N; n++){
        int rs = in.nextInt()-1;
        int cs = in.nextInt()-1;
        int ds = in.nextInt();
        int max = 0;

        //--------------Smaller View// Will Remove Later----------
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
              cows[i][j] = lake[rs+i][cs+j];
          }
        }

        //-------------Find Max-------------
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
             if (cows[i][j] > max){
               max = cows[i][j];
            }
          }
        }

        //-----------Set elevations----------
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (max - cows[i][j] < ds){
              lake[rs+i][cs+j] = max - ds;
              cows[i][j] = lake[rs+i][cs+j];
            }
          }
        }
      }

      //------------Find Depth---------------
      int depth = 0;
      for (int i = 0; i < lake.length; i++){
        for (int j = 0; j < lake[0].length; j++){
          if (E - lake[i][j] > 0){
            depth += E - lake[i][j];
          }
        }
      }

      //----------------Return Solution-----------
      return 72*72*depth;
    }

  public static int silver(String filename) throws FileNotFoundException{
    
    //------------Setup-------------
    File l = new File(filename);
    Scanner in = new Scanner(l);
    int N, M, T;
    N = in.nextInt();
    M = in.nextInt();
    T = in.nextInt();
    R = N;
    C = M;
    char[][] map = new char[N][M];
    int[][] cur = new int[N][M];
    int[][] old = new int[N][M];
    int[] x = {0,0,1,-1};
    int[] y = {1,-1,0,0};
    for (int i = 0; i < N; i++){
      String line = in.next();
      for (int j = 0; j < M; j++){
        map[i][j] = line.charAt(j);
      }
    }
    System.out.println(toString(map));
    int R1,C1,R2,C2;
    R1 = in.nextInt()-1;
    C1 = in.nextInt()-1;
    R2 = in.nextInt()-1;
    C2 = in.nextInt()-1;
    cur[R1][C1] = 1;

    for (int t = 0; t < T; t++){

      for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
          for (int k = 0; k < 4; k++){
            if(isValid(i+x[k],j+y[k])){
              cur[i][j] += old[i+x[k]][j+y[k]];
            }
          }
        }

      }
      
    }
    
    System.out.println(toString(cur));
    return 1;
  }
  
  public static  String toString(char[][] arr){
    String sol = "";
    for (int i = 0; i < arr.length; i ++){
      sol+= "\n";
      for (int j = 0; j <arr[0].length; j++){
        sol+= arr[i][j] + " ";
      }
    }
    return sol;
  }

  private static boolean isValid(int r, int c){
    if (r >= 0 && r < R && c >= 0 & c < C){
      return true;
    }
    return false; 
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
     System.out.println(silver("d2.txt"));
   }catch(FileNotFoundException e){}
  }

}
