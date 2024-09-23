import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<ArrayList<Character>> graph = new ArrayList<>();
    static List<ArrayList<Character>> graph2 = new ArrayList<>();
    static boolean[][] visited = new boolean[100][100];
    static boolean[][] visited2 = new boolean[100][100];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int cnt2 = 0;
        for(int i = 0; i < 100; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            String st = br.readLine();
            for(int j = 0; j < st.length(); j++) {
                graph.get(i).add(st.charAt(j));
                if(st.charAt(j) == 'G') {
                    graph2.get(i).add('R');
                }
                else
                    graph2.get(i).add(st.charAt(j));
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(graph, visited, i, j);
                    cnt++;
                }
                if(!visited2[i][j]) {
                    bfs(graph2, visited2, i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }

    public static void bfs(List<ArrayList<Character>> graph, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] a = q.poll();
            int tx = a[0];
            int ty = a[1];
            for(int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && graph.get(tx).get(ty) == graph.get(nx).get(ny)) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}