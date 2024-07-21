import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            binarySearch(0, N-1, i);
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binarySearch(int left, int right, int num) {
        while(left < right) {

            if(left == num) {
                left++;
                continue;
            }
            else if(right == num) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];
            if(sum == arr[num]) {
                cnt++;
                break;
            }
            else if(sum < arr[num]) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}
