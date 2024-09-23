import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int idx = binarySearch();

        int sum = 0;
        boolean[] check = new boolean[N];
        int cnt = arr.size() - 1;

        for(int i = 0; i+1 < idx; i+=2) {
            sum += arr.get(i)*arr.get(i+1);
            check[i] = check[i+1] = true;
        }

        if(arr.get(idx) == 0 && idx > 0) {
            if(!check[idx-1]) {
                check[idx] = check[idx-1] = true;
            }
        }

        while(cnt > 0 && arr.get(cnt-1) > 1) {
            sum += arr.get(cnt)*arr.get(cnt-1);
            check[cnt] = check[cnt-1] = true;
            cnt -= 2;
        }

        for(int i = 0; i < arr.size(); i++) {
            if(!check[i])
                sum += arr.get(i);
        }


        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch() {
        int left = 0;
        int right = arr.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr.get(mid) >= 0) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}
