import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int cnt, sum, res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visit = new boolean[N][N];
            boolean check = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visit[i][j]) {
                        bfs(i, j);
                        if(cnt > 1) {
                            check = true;
                        }
                    }
                }
            }

            if(check)
                res++;
            else
                break;
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        sum = map[x][y];
        cnt = 1;
        list.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visit[nx][ny]) {
                        int diff = Math.abs(map[tmp[0]][tmp[1]] - map[nx][ny]);
                        if (diff >= L && diff <= R) {
                            q.offer(new int[]{nx, ny});
                            visit[nx][ny] = true;
                            sum += map[nx][ny];
                            list.add(new int[]{nx, ny});
                            cnt++;
                        }
                    }
                }
            }
        }

        int avg = sum / cnt;

        for(int i = 0; i < list.size(); i++) {
            int[] coo = list.get(i);
            map[coo[0]][coo[1]] = avg;
        }
    }
}