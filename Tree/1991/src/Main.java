import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Node node = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(node, root, left, right);
        }

        preOrder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrder(node);
    }

    public static void insertNode(Node node, char root, char left, char right) {
        if(node.value == root) {
            node.left = (left == '.') ? null : new Node(left, null, null);
            node.right = (right == '.') ? null : new Node(right, null, null);
        }
        else{
            if(node.left != null) {
                insertNode(node.left, root, left, right);
            }
            if(node.right != null) {
                insertNode(node.right, root, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if(node == null)
            return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}