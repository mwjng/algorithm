import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static long cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N/2, 0, list1);
        dfs(N/2, N, 0, list2);

        Collections.sort(list2);

        for(int i = 0; i < list1.size(); i++) {
            cnt += upper(list2, S - list1.get(i)) - lower(list2, S - list1.get(i));
        }

        if(S == 0) {
           cnt--;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int lower(List<Integer> list, int n) {
        int left = 0;
        int right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= n)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    public static int upper(List<Integer> list, int n) {
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

    public static void dfs(int start, int end, int sum, List<Integer> list) {
        if(start == end) {
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum + arr[start], list);
        dfs(start+1, end, sum, list);
    }
}
