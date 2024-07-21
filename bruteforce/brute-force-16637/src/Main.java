import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Character> ch = new ArrayList<>();
    static List<Integer> num = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for(int i = 0; i < N; i++) {
            if(i % 2 == 1)
                ch.add(str.charAt(i));
            else
                num.add(str.charAt(i) - '0');
        }

        dfs(0, num.get(0));

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int res) {
        if(idx == ch.size()) {
            max = Math.max(max, res);
            return;
        }

        dfs(idx+1, calc(ch.get(idx), res, num.get(idx+1)));

        if(idx+2 <= ch.size()) {
            dfs(idx+2, calc(ch.get(idx), res, calc(ch.get(idx+1), num.get(idx+1), num.get(idx+2))));
        }
    }

    public static int calc(char ch, int a, int b) {
        switch(ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }

        return 0;
    }
}
