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
    static int v;
    static List<Node>[] list;
    static int max = Integer.MIN_VALUE;
    static boolean[] visit;
    static int maxVertex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        v = Integer.parseInt(br.readLine());
        list = new ArrayList[v+1];

        for(int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            while(true) {
                int child = Integer.parseInt(st.nextToken());
                if(child == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                list[parent].add(new Node(child, dist));
            }
        }

        visit = new boolean[v+1];
        dfs(1, 0);
        visit = new boolean[v+1];
        dfs(maxVertex, 0);

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
        if(max < sum) {
            max = sum;
            maxVertex = num;
        }
    }
}
