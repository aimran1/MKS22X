public class Recursion{

  public static int fact(int n){

    if (n < 0){
      throw new IllegalArgumentException();
    }

    if (n == 0){
      return 1;
    }

    return n * fact(n-1);

  }

  public static int fib(int n){

    if (n < 0){
      throw new IllegalArgumentException();
    }

    if (n == 0){
      return 0;
    }

    if (n == 1){
      return 1;
    }

    return helpFib(1,0,n);

  }

  private static int helpFib(int a, int b, int loc){

    if (loc == 0){
      return 1;
    }

    if (loc == 1){
      return a+b;
    }

    return helpFib(b, a + b, loc-1);

  }

  public static void main(String[] args){
    // System.out.println(fact(15));
    // System.out.println(fact(1));
    // System.out.println(fact(2));
    // System.out.println(fact(3));
    // System.out.println(fact(4));
    // System.out.println(fact(5));
    // System.out.println(fact(6));
    // System.out.println(fact(7));
    /* System.out.println(fib(0));
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
    System.out.println(fib(5));*/
    System.out.println(fib(20));

  }

}
