import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] c = new int[8002];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            c[arr[i] + 4000]++;
        }
        int a = (int)Math.round((double)sum / N);  // 산술평균, 소수점반올림
        sb.append(a).append("\n");

        Arrays.sort(arr);
        int b = arr[(N-1)/2];
        sb.append(b).append("\n");

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < c.length; i++) {
            max = Math.max(max, c[i]);
        }
        for(int i = 0; i < c.length; i++) {
            if(max == c[i]) {
                list.add(i-4000);
            }
        }
        if(list.size() > 1) {
            Collections.sort(list);
            sb.append(list.get(1)).append("\n");
        }
        else {
            sb.append(list.get(0)).append("\n");
        }

        int d = arr[N-1] - arr[0];
        sb.append(d).append("\n");

        System.out.println(sb);
    }
}