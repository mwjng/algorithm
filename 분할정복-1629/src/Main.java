import java.util.*;

public class Main {
    static long c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(pow(a, b));
    }

    public static long pow(long a, long b) {
        if(b == 1)
            return a % c;
        long n = pow(a, b / 2);
        if(b % 2 == 1) {
            return (n * n % c) * a % c;
        }
        return n * n % c;
    }
}