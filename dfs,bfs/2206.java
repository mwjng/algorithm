import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> wall = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 1) {
                    wall.add(new int[] {i, j});
                }
            }
        }

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        map[0][0] = 2;
        visit[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            if(x == N-1 && y == M-1) {
                return map[x][y] - 1;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(!visit[nx][ny][z]) {
                        if(map[nx][ny] == 0) {
                            map[nx][ny] = map[x][y] + 1;
                            q.offer(new int[]{nx, ny, z});
                            visit[nx][ny][z] = true;
                        }
                        else if(map[nx][ny] == 1) {
                            if (z == 0) {
                                map[nx][ny] = map[x][y] + 1;
                                q.offer(new int[]{nx, ny, 1});
                                visit[nx][ny][z] = true;
                            }
                        }
                        else {
                            if(z == 1)
                                continue;
                            map[nx][ny] = map[x][y] + 1;
                            q.offer(new int[]{nx, ny, z});
                            visit[nx][ny][z] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
