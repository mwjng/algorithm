import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        dfs(0 , 0);

        System.out.println(min);
    }
    public static void dfs(int index, int count) {
        if (count == N / 2) {
            calculate();
            return;
        }

        for(int i = index; i < N; i++) {
            visited[i] = true;
            dfs(i+1, count+1);
            visited[i] = false;
        }
    }

    public static void calculate() {
        int st = 0;
        int lt = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    st += S[i][j] + S[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    lt += S[i][j] + S[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(st - lt));
        if(min == 0) {
            System.out.println(min);
            System.exit(0);
        }
    }
}