import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        int[] path = new int[N+1];

        d[1] = 0;
        for(int i = 2; i <= N; i++) {
            if(i % 6 == 0) {
                d[i] = Math.min(Math.min(d[i/3], d[i/2]), d[i-1]) + 1;
                if(d[i] == d[i/3]+1) {
                    path[i] = i/3;
                }
                else if(d[i] == d[i/2]+1) {
                    path[i] = i/2;
                }
                else
                    path[i] = i-1;
            }
            else if(i % 3 == 0) {
                d[i] = Math.min(d[i/3], d[i-1]) + 1;
                if(d[i] == d[i/3]+1) {
                    path[i] = i/3;
                }
                else
                    path[i] = i-1;
            }
            else if(i % 2 == 0) {
                d[i] = Math.min(d[i/2], d[i-1]) + 1;
                if(d[i] == d[i/2]+1) {
                    path[i] = i/2;
                }
                else
                    path[i] = i-1;
            }
            else {
                path[i] = i-1;
                d[i] = d[path[i]] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int temp = N;

        while(temp > 0) {
            sb.append(temp + " ");
            temp = path[temp];
        }

        System.out.println(d[N]);
        System.out.println(sb);

    }
}
