import java.io.*;
import java.util.*;

public class Main {

    static String text, pattern;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        for (int i = 0; i < text.length(); i++) {
            pattern = text.substring(i);
            makeTable();
        }
        System.out.println(res);
    }

    static void makeTable() {
        int[] table = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
            res = Math.max(res, table[i]);
        }
    }
}