import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] check;
    static int[] arr;
    static List<Integer> temp = new ArrayList<>();
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth) {
        if(depth == N) {
            calc(temp);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!check[i]) {
                temp.add(arr[i]);
                check[i] = true;
                dfs(depth+1);
              
                // 동일한 수가 존재할 수 있기 때문에 temp.remove(Integer.valueOf(arr[i])); 하면 안됨
                temp.remove(temp.size()-1);
                check[i] = false;
            }

        }
    }

    public static void calc(List<Integer> temp) {
        int sum = 0;
        for(int i = 0; i < N-1; i++)
            sum += Math.abs(temp.get(i)-temp.get(i+1));
        res = Math.max(res, sum);
    }
}
