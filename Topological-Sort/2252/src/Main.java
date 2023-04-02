import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n+1];
        List<Integer>[] list = new ArrayList[n+1];
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int temp = q.poll();
            res.add(temp);
            for(int i = 0; i < list[temp].size(); i++) {
                int in = list[temp].get(i);
                indegree[in]--;
                if(indegree[in] == 0) {
                    q.offer(in);
                }
            }
        }

        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
