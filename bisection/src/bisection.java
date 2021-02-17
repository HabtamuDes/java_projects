
import java.lang.*;
public class bisection {

  public static void main(String argv[]) {
    double x = 0, del = 1e-2, a = 0, b = 2;
    double dx = b-a;
    int k = 0;
    while (Math.abs(dx) > del && k<10 && f(x)!=0 ) {
      x = ((a+b)/2);
      if ((f(a)*f(x)) < 0) {
        b  = x;
        dx = b-a;
      }
      else {
        a = x;
        dx = b-a;
      }
      k++;
    System.out.println("Iteration number: " + k);
    System.out.println("Root obtained: " + x);
    System.out.println("Estimated error: " + dx);
    }
    System.out.println("*****************");
    System.out.println("Iteration number: " + k);
    System.out.println("Root obtained: " + x);
    System.out.println("Estimated error: " + dx);
  }


  public static double f(double x) {
    return Math.exp(x)-2*x-2;
  }
}