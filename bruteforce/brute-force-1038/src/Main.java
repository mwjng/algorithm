import java.io.*;
import java.util.*;

public class Main {
    static List<Long> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);

        Collections.sort(arr);

        if(N >= arr.size())
            bw.write(-1 + "");
        else
            bw.write(arr.get(N) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, long num, int depth) {
        for(int i = idx; i < 10; i++) {
            long tmp = num + (long)Math.pow(10, depth)*i;
            arr.add(tmp);
            dfs(i+1, tmp, depth+1);
        }
    }
}
