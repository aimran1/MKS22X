import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File l = new File(filename);
	Scanner in = new Scanner(l);
	// String line = in.nextLine();
	int R, C, E, N;
	R = in.nextInt();
	C = in.nextInt();
	E = in.nextInt();
	N = in.nextInt();
	int[][] lake = new int[R][C];
	for (int i = 0; i < R; i++){
	    for (int j = 0; j < C; j++){
		lake[R][C] = in.nextInt();
	    }
	}
	System.out.println("R:" + R + 
			   ";C:" + C +
			   ";E:" + E +
			   ";N:" + N);
	return 1;
    }
    
    public static void main (String[] args){
	try{
        bronze("d1.txt");
	}catch(FileNotFoundException e){}
    }

}
