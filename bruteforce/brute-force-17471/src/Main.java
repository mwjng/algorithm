import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer>[] list;
    static List<Integer> temp = new ArrayList<>();
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        list = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1);

        if(res == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx) {
        if(idx > N) {
            if(temp.isEmpty() || temp.size() == N)
                return;
            List<Integer> temp2 = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                if(!temp.contains(i))
                    temp2.add(i);
            }
            if(bfs(temp) && bfs(temp2)) {
                res = Math.min(res, calc());
            }
            return;
        }

        temp.add(idx);
        dfs(idx+1);
        temp.remove(Integer.valueOf(idx));
        dfs(idx+1);
    }

    public static boolean bfs(List<Integer> tmp) {
        boolean[] check = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(tmp.get(0));
        check[tmp.get(0)] = true;
        while(!q.isEmpty()) {
            int vtx = q.poll();
            for(int i = 0; i < list[vtx].size(); i++) {
                int next = list[vtx].get(i);
                if(tmp.contains(next)) {
                    if (!check[next]) {
                        q.offer(next);
                        check[next] = true;
                    }
                }
            }
        }

        for(int i = 0; i < tmp.size(); i++) {
            if(!check[tmp.get(i)])
                return false;
        }

        return true;
    }

    public static int calc() {
        int a = 0;
        int b = 0;
        for(int i = 1; i <= N; i++) {
            if(temp.contains(i))
                a += arr[i];
            else
                b += arr[i];
        }

        return Math.abs(a-b);
    }
}