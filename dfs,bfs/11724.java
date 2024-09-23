import java.util.*;

public class Main {
    static int n, m;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for(int i = 0; i < graph.get(start).size(); i++) {
            if(!visited[graph.get(start).get(i)]) {
                dfs(graph.get(start).get(i));
            }
        }
    }
}