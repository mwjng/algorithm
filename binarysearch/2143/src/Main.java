import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int n, m;
    static int[] a, b;
    static long total = 0;
    static List<Integer> asum = new ArrayList<>();
    static List<Integer> bsum = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += a[j];
                asum.add(sum);
            }
        }

        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += b[j];
                bsum.add(sum);
            }
        }

        Collections.sort(asum);
        Collections.sort(bsum);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < asum.size(); i++) {
            int num = T - asum.get(i);
            if(hashMap.containsKey(num)) {
                total += hashMap.get(num);
                continue;
            }
            int temp = binarySearch(num);
            int cnt = 0;
            while(temp < bsum.size()) {
                if(bsum.get(temp++) == num) {
                    cnt++;
                }
                else
                    break;
            }
            hashMap.put(num, cnt);
            total += cnt;
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int n) {
        int left = 0;
        int right = bsum.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(bsum.get(mid) >= n) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}
