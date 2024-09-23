import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        int T = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] result = new int[T+1];

        for(int t = 1; t <= T; t++)
        {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < N - 2; i++) {
                int left = Math.max(arr[i - 2], arr[i - 1]);
                int right = Math.max(arr[i + 2], arr[i + 1]);
                int max =  Math.max(left, right);

                if (arr[i] > max) {
                    result[t] += arr[i] - max;
                }
            }
        }

        for (int i = 1; i <= T; i++) {
            bw.write("#" + i + " ");
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}