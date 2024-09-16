import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }
        d[0] = 1;
        d[2] = 3;
        for (int i = 4; i <= N; i+=2) {
            d[i] = d[i-2]*3;
            for (int j = 4; j <= i; j+=2) {
                d[i] += d[i - j] * 2;
            }
        }
        System.out.print(d[N]);
    }
}