import java.awt.color.ICC_ColorSpace;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int num, dist;
    Node(int num, int dist) {
        this.num = num;
        this.dist=  dist;
    }
}
public class Main {
    static int n;
    static List<Node>[] list;
    static int max = Integer.MIN_VALUE;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, dist));
            list[child].add(new Node(parent, dist));
        }

        for(int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            dfs(i, 0);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int num, int sum) {
        visit[num] = true;
        for(Node node : list[num]) {
            if(!visit[node.num]) {
                dfs(node.num, sum + node.dist);
            }
        }
        max = Math.max(max, sum);
    }
}
