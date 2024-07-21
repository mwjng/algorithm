import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        m = Integer.parseInt(br.readLine());
        num = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            if(map.containsKey(num[i])) {
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}