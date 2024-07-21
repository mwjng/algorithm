import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] card;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N];
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        num = new int[M];
        for(int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            if(binarySearch(num[i]))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }

    public static boolean binarySearch(int num) {
        int left = 0;
        int right = N-1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(num == card[mid]) {
                return true;
            }
            else if(num < card[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}