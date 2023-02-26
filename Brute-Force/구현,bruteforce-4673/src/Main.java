import java.util.*;

public class Main {
    static boolean[] checked = new boolean[10001];
    static boolean[] p = new boolean[10001];

    public static void main(String[] args) {
        for(int i = 1; i < 10000; i++) {
            if(!checked[i]) {
                find(i);
            }
        }
        for(int i = 1; i <= 10000; i++) {
            if(!p[i])
                System.out.println(i);
        }
    }

    public static void find(int n) {
        if(!checked[n] && n < 10000) {
            String s = Integer.toString(n);
            checked[n] = true;
            int sum = n;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            if(sum > 10000)
                return;
            p[sum] = true;
            find(sum);
        }
    }
}