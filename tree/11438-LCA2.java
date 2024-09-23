import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] depth;
    static int[][] parents;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        depth = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        K = 0;
        int tmp = 1;
        while (tmp <= N) {
            tmp *= 2;
            K++;
        }
        parents = new int[N+1][K];

        dfs(1, 1);
        getParents();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            sb.append(lca(v1, v2) + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static int lca(int v1, int v2) {
        if(depth[v1] < depth[v2]) {
            int tmp = v1;
            v1 = v2;
            v2 = tmp;
        }
        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[v1] - depth[v2]) {
                v1 = parents[v1][i];
            }
        }
        if(v1 == v2) return v1;
        for (int i = K - 1; i >= 0; i--) {
            if (parents[v1][i] != parents[v2][i]) {
                v1 = parents[v1][i];
                v2 = parents[v2][i];
            }
        }
        return parents[v1][0];
    }

    static void getParents() {
        for (int i = 1; i < K; i++) {
            for (int j = 0; j <= N; j++) {
                parents[j][i] = parents[parents[j][i-1]][i-1];
            }
        }
    }

    static void dfs(int node, int dep) {
        depth[node] = dep;
        for (int i = 0; i < list[node].size(); i++) {
            if (depth[list[node].get(i)] == 0) {
                dfs(list[node].get(i), dep + 1);
                parents[list[node].get(i)][0] = node;
            }
        }
    }
}
