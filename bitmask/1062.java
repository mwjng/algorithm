import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] words;
    static int alphabet = 1 | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('c' - 'a'));
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];
        int n;
        if(K < 5) bw.write(String.valueOf(0));
        else {
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 4; j < input.length()-4; j++) {
                    n = input.charAt(j) - 'a';
                    words[i] |= 1 << n;
                }
            }
            dfs(0, 0, alphabet);
            bw.write(String.valueOf(max));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth, int idx, int letters) {
        if (depth == K-5) {
            max = Math.max(max, compareWords(letters));
            return;
        }
        for (int i = idx; i < 26; i++) {
            if((alphabet & 1 << i) == 0) {
                dfs(depth + 1, i + 1, letters | 1 << i);
            }
        }
    }
    static int compareWords(int num) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i] == (words[i] & num)) cnt++;
        }
        return cnt;
    }
}