import java.util.*;
import java.io.*;

public class Main {
    static final int INF = (int) 1e8;
    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N][1 << N];
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 1));
    }

    static int dfs(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            if (cost[cur][0] == 0) return INF;
            return cost[cur][0];
        }
        if(dp[cur][visited] != 0) return dp[cur][visited];
        dp[cur][visited] = INF;
        for (int i = 0; i < N; i++) {
            if((visited & (1 << i)) == 0 && cost[cur][i] != 0) {
                dp[cur][visited] = Math.min(dp[cur][visited], cost[cur][i] + dfs(i, visited | (1 << i)));
            }
        }
        return dp[cur][visited];
    }
}