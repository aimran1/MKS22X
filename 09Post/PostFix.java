import java.util.*;
import java.io.*;

public class PostFix{

    public static double eval(String op){
	String[] elements = op.split(" ");
	double p1;
	double p2;
	LinkedList<Double> eq = new LinkedList<>();

	for (String n: elements){
	    System.out.println(n);
	    	    System.out.println(eq);

	    if (Character.isDigit(n.charAt(0))){
		eq.push(Double.parseDouble(n));
	    }
	    else {
		eq.push(operator(n,eq));
	    }
	}
	return eq.peek();
    }

    private static double operator(String o, LinkedList<Double> e){	
	double p2 = e.pop();
	double p1 = e.pop();

	if (o.equals("+")){return p1 + p2;}
	System.out.println("E: " + e);

	if (o.equals("-")){return p1 - p2;}
	System.out.println("E: " + e);

	if (o.equals("/")){return p1 / p2;}
	System.out.println("E: " + e);

	if (o.equals("*")){return p1 * p2;}
	System.out.println("E: " + e);

	if (o.equals("%")){return p1 % p2;}
	System.out.println("E: " + e);
	return 0.0;
    }

    public static void main(String[] args){
	System.out.println(	eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    
}
