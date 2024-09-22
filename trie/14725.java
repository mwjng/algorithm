import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        TreeMap<String, Node> childNode = new TreeMap<>();
    }

    static Node node = new Node();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] arr = new String[K];
            for (int j = 0; j < K; j++) {
                arr[j] = st.nextToken();
            }
            insert(arr);
        }
        search(node, 1);
        System.out.print(sb);
    }

    static void insert(String[] arr) {
        Node root = node;
        for (int i = 0; i < arr.length; i++) {
            root = root.childNode.computeIfAbsent(arr[i], (k) -> new Node());
        }
    }

    static void search(Node node, int depth) {
        if(node.childNode.isEmpty()) return;
        for (String str : node.childNode.keySet()) {
            for (int i = 1; i < depth; i++) {
                sb.append("--");
            }
            sb.append(str + "\n");
            search(node.childNode.get(str), depth+1);
        }
    }
}