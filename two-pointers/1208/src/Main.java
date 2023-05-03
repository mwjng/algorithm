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

        Collections.sort(list1);
        Collections.sort(list2);

        calc();

        if(S == 0) {
           cnt--;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calc() {
        int leftPointer = 0;
        int rightPointer = list2.size() - 1;
        while(leftPointer < list1.size() && rightPointer >= 0) {
            int leftSum = list1.get(leftPointer);
            int rightSum = list2.get(rightPointer);
            long leftCnt = 0;
            long rightCnt = 0;
            if(leftSum + rightSum == S) {
                while(leftPointer < list1.size() && list1.get(leftPointer) == leftSum) {
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && list2.get(rightPointer) == rightSum) {
                    rightCnt++;
                    rightPointer--;
                }
                cnt += leftCnt * rightCnt;
            }
            else if(leftSum + rightSum > S) {
                rightPointer--;
            }
            else {
                leftPointer++;
            }
        }
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
