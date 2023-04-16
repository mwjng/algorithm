import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static Character[][] map;
    static List<Character> check = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new Character[r][c];

        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        check.add(map[0][0]);
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && ty >= 0 && tx < r && ty < c) {
                if (!check.contains(map[tx][ty])) {
                    check.add(map[tx][ty]);
                    dfs(tx, ty, count + 1);
                    check.remove((Object) map[tx][ty]);
                }
            }
        }
    }
}
