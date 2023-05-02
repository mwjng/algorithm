import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] arr;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for(int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            check = false;

            for(int i = 0; i < n-1; i++) {
                if(arr[i+1].startsWith(arr[i])) {
                    check = true;
                    break;
                }
            }

            if(!check)
                bw.write("YES" + "\n");
            else
                bw.write("NO" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
