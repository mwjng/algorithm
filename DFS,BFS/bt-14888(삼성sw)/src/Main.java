import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        op = new int[4];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int n, int count) {
        if(count == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;

                switch(i) {
                    case 0: dfs(n + num[count], count+1); break;
                    case 1: dfs(n - num[count], count+1); break;
                    case 2: dfs(n * num[count], count+1); break;
                    case 3: dfs(n / num[count], count+1); break;
                }

                op[i]++;
            }
        }
    }
}