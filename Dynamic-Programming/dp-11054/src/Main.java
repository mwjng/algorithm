import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] d1 = new int[N];
        int[] d2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d1, 1);
        Arrays.fill(d2, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && d1[i] < d1[j] + 1) {
                    d1[i] = d1[j] + 1;
                }
            }
        }

        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(arr[j] < arr[i] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, d1[i] + d2[i] - 1);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
