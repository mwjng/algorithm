import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static int x;
    public static boolean[] visited = new boolean[101];
    public static int count = -1;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = bfs(1);
        System.out.println(result);
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            x = q.poll();
            count++;
            for(int value : graph.get(x)) {
                if(!visited[value]) {
                    visited[value] = true;
                    q.offer(value);
                }
            }
        }
        return count;
    }
}