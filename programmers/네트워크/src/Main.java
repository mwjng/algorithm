import java.util.*;

class Solution {
    static boolean[] check;
    static int res = 0;
    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                dfs(n, computers, i);
                res++;
            }
        }
        return res;
    }

    public static void dfs(int n, int[][] computers, int idx) {
        check[idx] = true;
        for(int i = 0; i < n; i++) {
            if(computers[idx][i] == 1 && !check[i]) {
                dfs(n, computers, i);
            }
        }
    }
}