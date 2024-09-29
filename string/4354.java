import java.util.*;
import java.io.*;

public class Main {
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!(s = br.readLine()).equals(".")) {
            System.out.println(kmp(s + s, s)-1);
        }
    }

    static int kmp(String t, String p) {
        int[] table = makeTable(p);
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
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