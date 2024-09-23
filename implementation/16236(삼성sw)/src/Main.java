import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Coo {
    int cx, cy, time;
    Coo(int x, int y, int time) {
        this.cx = x;
        this.cy = y;
        this.time = time;
    }
}
public class Main {
    static int N;
    static int[][] map;
    static int x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int size = 2;
    static int cnt = 0;
    static int second = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        while(true) {
            map[x][y] = 0;
            ArrayList<Coo> tmp = bfs(x, y);
            if(tmp.isEmpty()) {
                break;
            }
            int mx = Integer.MAX_VALUE;
            int my = Integer.MAX_VALUE;
            int distance = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < tmp.size(); i++) {
                if(distance >= tmp.get(i).time) {
                    distance = tmp.get(i).time;
                    if (mx > tmp.get(i).cx) {
                        mx = tmp.get(i).cx;
                        my = tmp.get(i).cy;
                        idx = i;
                    } else if (mx == tmp.get(i).cx) {
                        if (my > tmp.get(i).cy) {
                            my = tmp.get(i).cy;
                            idx = i;
                        }
                    }
                }
            }

            x = tmp.get(idx).cx;
            y = tmp.get(idx).cy;
            cnt++;
            second += tmp.get(idx).time;
            if (cnt == size) {
                size++;
                cnt = 0;
            }

        }

        System.out.println(second);
    }

    public static ArrayList<Coo> bfs(int a, int b) {
        int[][] check = new int[N][N];
        ArrayList<Coo> arr = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        check[a][b]++;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];
            for(int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(check[nx][ny] == 0) {
                        if (map[nx][ny] < size && map[nx][ny] > 0) {
                            arr.add(new Coo(nx, ny, check[tx][ty]));
                            check[nx][ny] = check[tx][ty];
                        }
                        else if(map[nx][ny] == 0 || map[nx][ny] == size){
                            q.offer(new int[]{nx, ny});
                            check[nx][ny] = check[tx][ty] + 1;
                        }
                    }
                }
            }
        }
        return arr;
    }
}
