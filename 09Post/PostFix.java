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
	    if (Character.isDigit(n.charAt(0))){
		eq.push(Double.parseDouble(n));
			System.out.println(eq.peek());

	    }
	    else {

	    eq.push(operator(n,eq));
	System.out.println(eq.peek());

	    }
	}
	System.out.println(eq.peek());

	return eq.peek();
    }

    private static double operator(String o, LinkedList<Double> e){
	System.out.println(o.equals( "+"));
	
	if (o.equals("+")){return e.pop() + e.pop();}
	if (o.equals("-")){return e.pop() - e.pop();}
	if (o.equals("/")){return e.pop() / e.pop();}
	if (o.equals("*")){return e.pop() * e.pop();}
	if (o.equals("%")){return e.pop() % e.pop();}
	return 0.0;
    }

    public static void main(String[] args){
	System.out.println(	eval("10 2.0 +"));
    }
    
}
