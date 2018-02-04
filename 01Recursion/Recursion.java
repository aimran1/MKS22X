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

  public static void main(String[] args){
    System.out.println(fact(0));
    System.out.println(fact(1));
    System.out.println(fact(2));
    System.out.println(fact(3));
    System.out.println(fact(4));
    System.out.println(fact(5));
    System.out.println(fact(6));
    System.out.println(fact(7));
  }

}
