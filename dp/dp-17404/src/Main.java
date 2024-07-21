import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        int[][] d = new int[N+1][3];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++) {
            d[1][i] = cost[1][i];
            d[1][(i+1)%3] = 1001;
            d[1][(i+2)%3] = 1001;
            for (int j = 2; j <= N; j++) {
                d[j][0] = Math.min(d[j-1][1], d[j-1][2]) + cost[j][0];
                d[j][1] = Math.min(d[j-1][0], d[j-1][2]) + cost[j][1];
                d[j][2] = Math.min(d[j-1][0], d[j-1][1]) + cost[j][2];
            }
            int min = Math.min(d[N][(i+1)%3], d[N][(i+2)%3]);
            res = Math.min(min, res);
        }

        System.out.println(res);
    }
}
