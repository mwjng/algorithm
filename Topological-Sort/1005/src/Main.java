import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, w;
    static int[] time, totalTime, indegree;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            time = new int[n + 1];
            totalTime = new int[n + 1];
            indegree = new int[n + 1];
            list = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                indegree[b]++;
                list[a].add(b);
            }

            w = Integer.parseInt(br.readLine());

            topologySort();

            System.out.println(totalTime[w]);
        }
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                totalTime[i] = time[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i = 0; i < list[temp].size(); i++) {
                int next = list[temp].get(i);
                totalTime[next] = Math.max(totalTime[next], totalTime[temp] + time[next]);
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
