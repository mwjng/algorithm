import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[H+2];
        int[] up = new int[H+2];

        for(int i = 0; i < N/2; i++) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        for(int i = H; i >= 1; i--) {
            down[i] += down[i+1];
        }
        for(int i = H; i >= 1; i--) {
            up[i] += up[i+1];
        }

        int min = N;
        int count = 0;

        for(int i = 1; i <= H; i++) {
            int cnt = down[i] + up[H-i+1];
            if(cnt == min) {
                count++;
            }
            else if(min > cnt) {
                min = cnt;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
}