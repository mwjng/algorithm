import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] d;
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        d = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[idx].add(val);
            d[val]++;
        }

        topologicalSort();

        for(int i = 0; i < res.size(); i++) {
            bw.write(res.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(d[i] == 0) {
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()) {
            int temp = pq.poll();
            res.add(temp);
            for(int i = 0; i < list[temp].size(); i++) {
                int id = list[temp].get(i);
                d[id]--;
                if(d[id] == 0) {
                    pq.offer(id);
                }
            }
        }
    }
}
