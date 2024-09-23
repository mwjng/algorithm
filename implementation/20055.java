import java.io.*;
import java.util.*;

public class Main {
    static int N, K, cnt;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N*2+1];
        check = new boolean[N+1];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N*2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(isOk()) {
            int tmp = arr[2*N];
            for(int i = 2*N; i >= 2; i--) {
                arr[i] = arr[i-1];
            }
            arr[1] = tmp;

            for(int i = N; i >= 2; i--) {
                check[i] = check[i-1];
            }
            check[1] = false;
            check[N] = false;

            for (int i = N-1; i >= 1; i--) {
                if (check[i] && !check[i+1] && arr[i+1] > 0) {
                    check[i+1] = true;
                    check[i] = false;
                    arr[i+1]--;
                }
            }

            if (arr[1] > 0) {
                check[1] = true;
                arr[1]--;
            }

            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isOk() {
        int cnt = 0;
        for(int i = 1; i <= 2*N; i++) {
            if(arr[i] == 0) {
                cnt++;
            }
        }
        if(cnt >= K) {
            return false;
        }
        return true;
    }
}