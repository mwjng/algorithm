import java.io.*;
import java.util.*;

public class Main {
    static long min = Long.MAX_VALUE;
    static int N;
    static boolean check;
    static long[] arr;
    static long res1, res2, res3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N-2; i++) {
            binarySearch(i+1, N-1, arr[i]);
            if(check)
                break;
        }

        bw.write(res1 + " " + res2 + " " + res3 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binarySearch(int left, int right, long num) {
        while(left < right) {
            long sum = num + arr[left] + arr[right];
            long tmp = Math.abs(sum);

            if(min > tmp) {
                min = tmp;
                res1 = num;
                res2 = arr[left];
                res3 = arr[right];
            }

            if(sum < 0) left++;
            else if(sum > 0) right--;
            else {
                check = true;
                break;
            }
        }
    }
}
