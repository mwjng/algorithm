import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] circle;
    static int[][] target;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        circle = new int[4][8];
        target = new int[4][2];
        visited = new boolean[4];

        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0; j < 8; j++) {
                circle[i][j] = input.charAt(j) - '0';
            }
            target[i][0] = 6;
            target[i][1] = 2;
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dict = Integer.parseInt(st.nextToken());

            dfs(num, dict);

            for(int j = 0; j < 4; j++) {
                visited[j] = false;
            }
        }

        int sum = 0;
        int score = 1;
        for(int i = 0; i < 4; i++) {
            int a = (target[i][0] + 2) % 8;
            if(circle[i][a] == 1) {
                sum += score;
            }
            score *= 2;
        }

        System.out.println(sum);
    }

    public static void dfs(int num, int dict) {
        visited[num] = true;
        if(num-1 >= 0 && !visited[num-1]) {
            int a = target[num][0];
            int b = target[num-1][1];
            if(circle[num][a] != circle[num-1][b]) {
                dfs(num-1, -dict);
            }
        }
        if(num+1 < 4 && !visited[num+1]) {
            int a = target[num][1];
            int b = target[num+1][0];
            if(circle[num][a] != circle[num+1][b]) {
                dfs(num+1, -dict);
            }
        }
        int a = target[num][0] - dict;
        int b = target[num][1] - dict;
        a = a < 0 ? 7 : a;
        b = b < 0 ? 7 : b;
        target[num][0] = a % 8;
        target[num][1] = b % 8;
    }
}