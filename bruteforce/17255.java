import java.util.*;
import java.io.*;

public class Main {
    static String[] arr;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        arr = N.split("");
        for (int i = 0; i < arr.length; i++) {
            dfs(i, i, arr[i]);
        }
        System.out.print(set.size());
    }

    static void dfs(int left, int right, String path) {
        if(left == 0 && right == arr.length-1) {
            set.add(path);
            return;
        }
        if(left > 0) dfs(left-1, right, path + arr[left-1] + path);
        if(right < arr.length-1) dfs(left, right+1, path + path + arr[right+1]);
    }
}