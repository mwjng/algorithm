import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Coo {
    int x, y;
    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static int count= 0, close;
    static int countHome = 0;
    static Coo[] chickens, homes;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chickens = new Coo[13];
        homes = new Coo[N*2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) {
                    chickens[count] = new Coo(i, j);
                    count++;
                }
                else if(map[i][j] == 1) {
                    homes[countHome] = new Coo(i, j);
                    countHome++;
                }
            }
        }
        close = count - M;
        dfs(0, 0);
        System.out.println(min);
    }
    public static void dfs(int index, int depth) {
        if(depth == close) {
            int sum = 0;
            for(int i = 0; i < countHome; i++) {
                sum += distance(homes[i].x, homes[i].y);
            }
            min = Math.min(sum, min);
            return;
        }
        for(int i = index; i < count; i++) {
            map[chickens[i].x][chickens[i].y] = 0;
            dfs(i+1, depth+1);
            map[chickens[i].x][chickens[i].y] = 2;
        }
    }

    public static int distance(int x, int y) {
        int md = Integer.MAX_VALUE;
        for(int i = 0; i < count; i++) {
            int cx = chickens[i].x;
            int cy = chickens[i].y;
            if(map[cx][cy] == 2) {
                int distance = Math.abs(x-cx) + Math.abs(y-cy);
                md = Math.min(distance, md);
            }
        }
        return md;
    }
}