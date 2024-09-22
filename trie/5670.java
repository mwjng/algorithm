import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        Map<Character, Node> childNode = new HashMap<>();
        boolean isEnd;
    }

    static int N;
    static Node root;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String first;
        while ((first = br.readLine()) != null) {
            N = Integer.parseInt(first);
            arr = new String[N];
            root = new Node();
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
                insert(arr[i]);
            }
            double sum = 0;
            for (String s : arr) sum += search(s);
            sb.append(String.format("%.2f", sum/N)).append("\n");
        }
        System.out.print(sb);
    }

    static void insert(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            node = node.childNode.computeIfAbsent(str.charAt(i), k -> new Node());
        }
        node.isEnd = true;
    }

    static int search(String str) {
        int cnt = 1;
        Node node = root;
        node = node.childNode.get(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (node.childNode.size() == 1 && !node.isEnd) cnt--;
            node = node.childNode.get(str.charAt(i));
            cnt++;
        }
        return cnt;
    }
}