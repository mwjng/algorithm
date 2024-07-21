import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list, arr;
    static int[] time, degree, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        arr = new ArrayList[N+1];
        time = new int[N+1];
        degree = new int[N+1];
        res = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1)
                    break;
                list[num].add(i);
                arr[i].add(num);
                degree[i]++;
            }
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(res[i] + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void topologySort() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(degree[i] == 0) {
                q.offer(new int[] {i, time[i]});
            }
        }

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            res[temp[0]] = temp[1];
            for(int i = 0; i < list[temp[0]].size(); i++) {
                degree[list[temp[0]].get(i)]--;
                if(degree[list[temp[0]].get(i)] == 0) {
                    int max = 0;
                    for(int j = 0; j < arr[list[temp[0]].get(i)].size(); j++) {
                        max = Math.max(max, res[arr[list[temp[0]].get(i)].get(j)]);
                    }
                    q.offer(new int[] {list[temp[0]].get(i), max + time[list[temp[0]].get(i)]});
                }
            }
        }
    }
}
