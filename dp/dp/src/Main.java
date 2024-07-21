import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] d = new int[n+2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (i + t[i] <= n+1) {
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
            d[i+1] = Math.max(d[i+1], d[i]);
        }

        System.out.println(d[n+1]);
    }
}