import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1001];
        int[] d = new int[1001];

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;

        for(int i = 1; i <= n; i++) {
            d[i] = 1;
            for(int j = 1; j < i; j++) {
                if(a[i] > a[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            if(max < d[i])
                max = d[i];
        }
        System.out.println(max);
    }
}