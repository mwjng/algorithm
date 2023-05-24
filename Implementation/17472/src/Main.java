import java.io.*;
import java.util.*;

class Coo {
    int x, y;
    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Edge implements Comparable<Edge>{
    int start, end, weight;
    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int count;
    static int[] parent;
    static List<Edge> list;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        List<Coo> land = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    land.add(new Coo(i, j));
            }
        }

        count = 0;
        for(int i = 0; i < land.size(); i++) {
            int x = land.get(i).x;
            int y = land.get(i).y;
            if(!visit[x][y]) {
                dfs(x, y, count);
                count++;
            }
        }

        list = new ArrayList<>();
        parent = new int[count];
        for(int i = 0; i < count; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < land.size(); i++) {
            Coo c = land.get(i);
            bfs(c.x, c.y, map[c.x][c.y]);
        }

        Collections.sort(list);

        int idx = 0;
        int cnt = 0;

        while(cnt < count-1) {
            if(list.size() <= idx) {
                res = -1;
                break;
            }
            Edge e = list.get(idx++);
            int a = find(e.start);
            int b = find(e.end);
            if(a != b) {
                parent[b] = a;
                res += e.weight;
                cnt++;
            }
        }

        if(res == 0)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int idx) {
        visit[x][y] = true;
        map[x][y] = idx+1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0) {
                if(!visit[nx][ny]) {
                    dfs(nx, ny, idx);
                }
            }
        }
    }

    public static void bfs(int x, int y, int num) {
        Queue<Coo> q = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            q.offer(new Coo(x, y));
            while(!q.isEmpty()) {
                Coo c = q.poll();
                int tx = c.x + dx[i];
                int ty = c.y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                    if(map[tx][ty] != num) {
                        if (map[tx][ty] != 0) {
                            int dist = Math.abs(x - tx) + Math.abs(y - ty);
                            if(dist > 2) {
                                list.add(new Edge(num-1, map[tx][ty]-1, dist-1));
                            }
                            break;
                        }

                        q.offer(new Coo(tx, ty));
                    }

                    else
                        break;
                }
            }

            q.clear();
        }
    }

    public static int find(int i) {
        if(i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }
}
