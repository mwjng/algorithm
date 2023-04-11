import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static double min = Double.MAX_VALUE;
    static int N;
    static List<int[]> list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            check = new boolean[N];
            min = Double.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            dfs(0, 0);

            System.out.println(min);
        }
    }

    public static void dfs(int idx, int depth) {
        if(depth == N/2) {
            min = Math.min(min, calc());
            return;
        }
        for(int i = idx; i < N; i++) {
            check[i] = true;
            dfs(i+1, depth+1);
            check[i] = false;
        }
    }

    public static double calc() {
        int x = 0;
        int y = 0;
        for(int i = 0; i < N; i++) {
            if(check[i]) {
                x += list.get(i)[0];
                y += list.get(i)[1];
            }
            else {
                x -= list.get(i)[0];
                y -= list.get(i)[1];
            }
        }
        return distance(x, y);
    }

    public static double distance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
