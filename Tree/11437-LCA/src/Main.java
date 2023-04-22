import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] depth, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        depth = new int[N+1];
        parent = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, 1, 0);

        M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            sb.append(lca(v1, v2) + "\n");
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int lca(int v1, int v2) {
        while(depth[v1] > depth[v2]) {
            v1 = parent[v1];
        }
        while(depth[v1] < depth[v2]) {
            v2 = parent[v2];
        }
        if(depth[v1] == depth[v2]) {
            while(v1 != v2) {
                v1 = parent[v1];
                v2 = parent[v2];
            }
        }
        return v1;
    }

    public static void dfs(int node, int dep, int par) {
        depth[node] = dep;
        parent[node] = par;
        for(int i = 0; i < list[node].size(); i++) {
            if(list[node].get(i) != parent[node]) {
                dfs(list[node].get(i), dep+1, node);
            }
        }
    }
}
