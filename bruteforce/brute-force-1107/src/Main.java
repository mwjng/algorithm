import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M == 0) {
            System.out.println(Math.min(Math.abs(N - 100), Integer.toString(N).length()));
            return;
        }

        boolean[] cn = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());
            cn[t] = true;
        }

        int min = Math.abs(N - 100);

        for(int i = 0; i <= 999999; i++) {
            String str = Integer.toString(i);
            boolean check = false;
            for(int j = 0; j < str.length(); j++) {
                if(cn[str.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                min = Math.min(min, str.length() + Math.abs(i - N));
            }
        }

        System.out.println(min);
    }
}