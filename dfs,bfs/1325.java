import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static List<Integer>[] list;
    static int[] result;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i = 1; i <= N; i++) {
            check = new boolean[N+1];
            bfs(i);
//            dfs(i);
        }

        for(int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int n : list[t]) {
                if (!check[n]) {
                    q.offer(n);
                    check[n] = true;
                    result[n]++;
                }
            }
        }
    }

    static void dfs(int start) {
        check[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int idx = list[start].get(i);
            if (!check[idx]) {
                result[idx]++;
                dfs(idx);
            }
        }
    }
}