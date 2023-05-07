import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            check = new boolean[n+1];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if(!check[i]) {
                    List<Integer> temp = new ArrayList<>();
                    find(i, temp);
                }
            }

            sb.append(cnt + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void find(int end, List<Integer> temp) {
        if(check[end])
            return;
        check[end] = true;
        temp.add(end);
        if(!check[arr[end]]) {
            find(arr[end], temp);
        }
        else {
            if(temp.contains(arr[end])) {
                cnt += temp.indexOf(arr[end]);
            }
            else {
                cnt += temp.size();
            }
        }
    }
}
