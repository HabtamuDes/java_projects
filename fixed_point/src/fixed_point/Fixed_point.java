
import java.lang.*;

public static void main(String args[]){
    Scanner console = new Scanner(System.in);
    double p, p0, Tol;
    int i = 1;
    int No;

    System.out.println("Enter approximate p: ");
    p0 = console.nextDouble();

    System.out.println("Desired tolerance: ");
    Tol = console.nextDouble();

    System.out.println("Maximum Iterations: ");
    No = console.nextInt();

    while(i<=No){
        p = g(p0);

        if((f(p-p0)) < Tol){
            System.out.println("P: " + p);
            break;
        }
        System.out.println("Iteration: Current Value = " + i + " " + p);

        i++;
        p0 = p;

        if(i>No){
            System.out.println("Method Failed after: " + No);
            System.out.println("");
        }
    }
}
public static double f(double x){
    return x*x*x*x-3*x*x-3;
}
public static double g(double x){
    return Math.pow(3*x*x+3, .25);
}
}

j