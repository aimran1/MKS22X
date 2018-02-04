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

    return helpFib(0,1,1,n);

  }

  private static int helpFib(int a, int b, int result, int loc){

    if (a == 0){
      return 0;
    }

    if (b == 1){
      return 1;
    }

    if (loc == 0){
      return result;
    }

    return helpFib(b, result, a + b + result, loc-1);

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
  }

}
