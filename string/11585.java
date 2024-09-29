import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String text, pattern;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pattern = br.readLine().replace(" ", "");
        text = br.readLine().replace(" ", "");
        int count = kmp(text+text, pattern);
        int n = gcd(N, count);
        System.out.println((count/n) + "/" + (N/n));
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static int kmp(String t, String p) {
        int[] table = makeTable(p);
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < t.length()-1; i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = table[j-1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
        return cnt;
    }

    static int[] makeTable(String p) {
        int[] table = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                j = table[j-1];
            }
            if (p.charAt(j) == p.charAt(i)) {
                table[i] = ++j;
            }
        }
        return table;
    }
}