import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long C;
    static long[] arr;
    static long res = 0;
    static List<Long> list1 = new ArrayList<>();
    static List<Long> list2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        dfs(0, N/2, 0, list1);
        dfs(N/2, N, 0, list2);

        Collections.sort(list2);

        for(int i = 0; i < list1.size(); i++) {
            res += binarySearch( C - list1.get(i), list2);
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
    public static long binarySearch(long n, List<Long> list) {
        int left = 0;
        int right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) > n)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    public static void dfs(int start, int end, long sum, List<Long> list) {
        if(start == end) {
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum + arr[start], list);
        dfs(start+1, end, sum, list);
    }
}
