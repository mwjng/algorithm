import java.io.*;
import java.util.*;

class Bridge {
    int end, weight;
    Bridge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class Main {
    static int N, M;
    static List<Bridge>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        int rw = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Bridge(end, weight));
            list[end].add(new Bridge(start, weight));
            rw = Math.max(rw, weight);
        }

        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken()) - 1;
        int right = Integer.parseInt(st.nextToken()) - 1;

        int lw = 0;
        int res = 0;

        while(lw <= rw) {
            int mid = (lw + rw) / 2;
            if(bfs(left, right, mid)) {
                res = mid;
                lw = mid + 1;
            }
            else {
                rw = mid - 1;
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bfs(int left, int right, int weight) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[N];
        q.offer(left);
        check[left] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == right)
                return true;
            for(int i = 0; i < list[temp].size(); i++) {
                Bridge bridge = list[temp].get(i);
                if(!check[bridge.end]) {
                    if (bridge.weight >= weight) {
                        q.offer(bridge.end);
                        check[bridge.end] = true;
                    }
                }
            }
        }

        return false;
    }
}
