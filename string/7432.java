import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        TreeMap<String, Node> childNode = new TreeMap<>();
        boolean isEnd;
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\\\");
            insert(input);
        }
        dfs(root, "");
        System.out.println(sb);
    }

    static void dfs(Node node, String str) {
        for (String key : node.childNode.keySet()) {
            sb.append(str + key + "\n");
            dfs(node.childNode.get(key), str + " ");
        }
    }

    static void insert(String[] arr) {
        Node node = root;
        for (int i = 0; i < arr.length; i++) {
            node = node.childNode.computeIfAbsent(arr[i], k -> new Node());
        }
        node.isEnd = true;
    }
}