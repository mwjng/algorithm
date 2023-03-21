import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] P = new long[100];
        P[0] = P[1] = P[2] = 1;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int num = Integer.parseInt(br.readLine()) - 1;
            for(int i = 3; i <= num; i++) {
                P[i] = P[i-3] + P[i-2];
            }
            sb.append(P[num]).append("\n");
        }
        System.out.println(sb);
    }
}