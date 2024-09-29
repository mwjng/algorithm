import java.util.*;
import java.io.*;

public class Main {
    static String t, p;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = br.readLine();
        p = br.readLine();
        KMP();
        System.out.println(cnt);
        System.out.println(sb);
    }

    static int[] makeTable() {
        int[] table = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j>0 && p.charAt(j)!=p.charAt(i)) {
                j = table[j-1];
            }
            if (p.charAt(j) == p.charAt(i)) {
                table[i] = ++j;
            }
        }
        return table;
    }

    static void KMP() {
        int[] table = makeTable();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            while(j>0 && t.charAt(i) != p.charAt(j)) {
                j = table[j-1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if(j == p.length()-1) {
                    cnt++;
                    sb.append(i - p.length() + 2).append(" ");
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}