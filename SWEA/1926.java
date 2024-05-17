import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            String tmp = String.valueOf(i);
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    cnt++;
                }
            }
            if (cnt == 0) {
                sb.append(tmp);
            } else {
                while (cnt-- > 0) {
                    sb.append("-");
                }
            }
            sb.append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}