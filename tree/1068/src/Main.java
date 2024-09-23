import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int count = 0;
    static int delete, root;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parent = new int[N];

        for(int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) {
                root = i;
            }
        }

        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);

        countLeaf(root);
        System.out.println(count);
    }

    public static void deleteNode(int n) {
        parent[n] = -2;
        for(int i = 0; i < N; i++) {
            if(parent[i] == n) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int n) {
        boolean isLeaf = true;
        if(parent[n] != -2) {
            for(int i = 0; i < N; i++) {
                if(parent[i] == n) {
                    isLeaf = false;
                    countLeaf(i);
                }
            }
            if(isLeaf) {
                count++;
            }
        }
    }
}
