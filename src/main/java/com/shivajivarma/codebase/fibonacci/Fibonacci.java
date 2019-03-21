public class Fibonacci {

    public static void main(String[] args) {
        System.out.print(fibonacci(1));
    }
    
    public static int fibonacci(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n should be greater than zero");
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
}
