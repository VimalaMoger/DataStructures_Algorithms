package dataStructuresAndAlgorithms.CodingExercises;

public class FactorialOfN {
    public static void main(String[] args) {
        System.out.println(factorialOfNs(0));
    }

    //using recursion
    private static int factorialOfN(int n){
        if(n == 0)
            return 1;
        return n * factorialOfN(n-1);
    }

    //using iteration
    private static int factorialOfNs(int n){
        int factorial = 1;
       for(int i = n; i > 0; i--){
           factorial *= i;
       }
        return factorial;
    }
}
