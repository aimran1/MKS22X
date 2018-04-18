import java.util.*;
import java.io.*;

public class Calculator{

    public static double eval(String op){
	String[] elements = op.split(" ");
	double p1;
	double p2;
	LinkedList<Double> eq = new LinkedList<>();

	for (String n: elements){

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
	if (o.equals("-")){return p1 - p2;}
	if (o.equals("/")){return p1 / p2;}
	if (o.equals("*")){return p1 * p2;}
	if (o.equals("%")){return p1 % p2;}

	return 0.0;
    }
    
}
