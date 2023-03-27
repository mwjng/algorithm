import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            count++;
            return;
        }
        for(int i = 0; i < n; i++) {
            arr[depth] = i;
            if(possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possible(int row) {
        for(int i = 0; i < row; i++) {
            if(arr[i] == arr[row]) {
                return false;
            }
            else if(Math.abs(i - row) == Math.abs(arr[i] - arr[row])) {
                return false;
            }
        }
        return true;
    }
}