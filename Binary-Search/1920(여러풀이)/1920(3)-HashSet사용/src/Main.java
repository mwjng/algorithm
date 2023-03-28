import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static HashSet<Integer> set = new HashSet<>();
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        num = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            if(set.contains(num[i])) {
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}