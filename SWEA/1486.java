import java.io.*;
import java.util.*;

class Solution {
    static int N, B, min;
    static int[] arr;
    static boolean[] visited;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0);
            bw.write("#" + t + " " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int sum, int idx) {
        if (sum >= B) {
            min = Math.min(min, sum - B);
            return;
        }
        for (int i = idx; i < N; i++) {
            visited[i] = true;
            dfs(sum + arr[i], i+1);
            visited[i] = false;
        }
    }
}