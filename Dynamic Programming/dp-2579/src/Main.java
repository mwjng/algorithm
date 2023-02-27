import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] st = new int[300];
        int[] d = new int[300];

        for(int i = 0; i < n; i++) {
            st[i] = sc.nextInt();
        }

        d[0] = st[0];
        d[1] = st[0] + st[1];
        d[2] = Math.max(st[0] + st[2], st[1] + st[2]);

        for(int i = 3; i < n; i++) {
            d[i] = Math.max(d[i-2], d[i-3] + st[i-1]) + st[i];
        }

        System.out.println(d[n-1]);
    }
}