import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] inDegree, res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        inDegree = new int[N+1];
        res = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            inDegree[to]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                res[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int tmp = list[cur].get(i);
                if (--inDegree[tmp] == 0) {
                    q.offer(tmp);
                    res[tmp] += res[cur] + 1;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(res[i] + " ");
        }
    }
}