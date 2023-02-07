import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k;
    public static int[] array;
    public static int[] result = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;
            array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int n : result) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < k; i++) {
            result[depth] = array[i];
            dfs(i + 1, depth + 1);
        }
    }
}