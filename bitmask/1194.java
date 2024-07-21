import java.io.*;
import java.util.*;

class Node {
    int x, y, keys, cnt;
    Node(int x, int y, int keys, int cnt) {
        this.x = x;
        this.y = y;
        this.keys = keys;
        this.cnt = cnt;
    }
}
class Main {
    static int N, M, sx, sy;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] visited;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][64];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, 0, 0));
        visited[sx][sy][0] = true;
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            if(map[tmp.x][tmp.y] == '1')
                return tmp.cnt;
            for(int i = 0; i < 4; i++) {
                int tx = tmp.x + dx[i];
                int ty = tmp.y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < N && ty < M && map[tx][ty] != '#' && !visited[tx][ty][tmp.keys]) {
                    if(map[tx][ty] >= 'a' && map[tx][ty] <= 'f') {
                        int newKeys = tmp.keys | (1 << (map[tx][ty] - 'a'));
                        visited[tx][ty][newKeys] = true;
                        q.offer(new Node(tx, ty, newKeys, tmp.cnt+1));
                    } else if(map[tx][ty] >= 'A' && map[tx][ty] <= 'F') {
                        if((tmp.keys & (1 << (map[tx][ty] - 'A'))) != 0) {
                            visited[tx][ty][tmp.keys] = true;
                            q.offer(new Node(tx, ty, tmp.keys, tmp.cnt+1));
                        }
                    } else {
                        visited[tx][ty][tmp.keys] = true;
                        q.offer(new Node(tx, ty, tmp.keys, tmp.cnt+1));
                    }
                }
            }
        }
        return -1;
    }
}