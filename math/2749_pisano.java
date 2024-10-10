import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        final int pisano = 1500000;
        n %= pisano;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] fib = new int[(int)n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % (int)1e6;
        }
        System.out.println(fib[(int)n]);
    }
}