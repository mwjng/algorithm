import java.util.*;

public class Main {
    static int n, s;
    static int[] num;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            sum(i, s);
        }
        System.out.println(cnt);
    }

    public static void sum(int index, int ts) {
        if(num[index] == ts) {
            cnt++;
        }
        if(index == n-1) {
            return;
        }
        for(int i = index+1; i < n; i++) {
            sum(i, ts - num[index]);
        }

    }
}