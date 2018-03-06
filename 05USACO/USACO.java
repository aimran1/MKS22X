import java.util.*;
import java.io.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    File l = new File(filename);
    Scanner in = new Scanner(l);
    String line = in.nextLine();
    int R, C, E, N;
    R = line.charAt(0);
    C = line.charAt(2);
    E = line.charAt(4);
    N = line.charAt(6);
    int[][] lake = new int[R][C];
    for (int i = 0; i < R; i++){
      line = in.nextLine();
      for (int j = 0; j < C; j++){
        lake[R][C] = line.charAt(j);
      }
    }
    return 1;
  }

}
