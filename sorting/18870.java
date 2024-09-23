import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] copy = arr.clone();
        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for(int tmp : copy) {
            if(!map.containsKey(tmp)) {
                map.put(tmp, idx++);
            }
        }

        for(int i : arr) {
            bw.write(map.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}