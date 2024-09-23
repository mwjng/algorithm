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

        dfs(0, 0);

        if(s == 0)
            cnt--;

        System.out.println(cnt);
    }

    public static void dfs(int index, int count) {
        if(index == n) {
            if (count == s) {
                cnt++;
            }
            return;
        }
        dfs(index + 1, count + num[index]);
        dfs(index + 1, count);
    }
}