import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void dfs(int n, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[n] = true;
        System.out.print(n + " ");
        for (int i = 0; i < graph.get(n).size(); i++) {
            int m = graph.get(n).get(i);
            if (!visited[m]) {
                dfs(m, graph, visited);
            }
        }
    }

    public static void bfs(int n, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> q =  new LinkedList<>();
        visited[n] = true;
        q.offer(n);
        while (!q.isEmpty()) {
            n = q.poll();
            System.out.print(n + " ");
            for (int value : graph.get(n)) {
                if (!visited[value]) {
                    q.offer(value);
                    visited[value] = true;
                }
            }
        }

    }
      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
          StringTokenizer st;
          ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

          st = new StringTokenizer(br.readLine(), " ");
          int n = Integer.parseInt(st.nextToken());
          int m = Integer.parseInt(st.nextToken());
          int start = Integer.parseInt(st.nextToken());
          int a, b;

          boolean[] visited_dfs = new boolean[n+1];
          boolean[] visited_bfs = new boolean[n+1];

          for (int i = 0; i <= n; i++) {
              graph.add(new ArrayList<Integer>());
          }

          for (int i = 0; i < m; i++) {
              st = new StringTokenizer(br.readLine());
              a = Integer.parseInt(st.nextToken());
              b = Integer.parseInt(st.nextToken());
              graph.get(a).add(b);
              graph.get(b).add(a);
          }

          for (int i = 1; i <= n; i++) {
              Collections.sort(graph.get(i));
          }

          dfs(start, graph, visited_dfs);
          System.out.println();
          bfs(start, graph, visited_bfs);

      }
}