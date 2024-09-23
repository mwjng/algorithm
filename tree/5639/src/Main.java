import java.io.*;

class Node {
    int value;
    Node left, right;
    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node head = new Node(Integer.parseInt(br.readLine()), null, null);
        while(true) {
            String str = br.readLine();
            if(str == null || str.equals(""))
                break;
            insert(head, Integer.parseInt(str));
        }

        postOrder(head);
    }

    public static void insert(Node node, int n) {
        if(n < node.value) {
            if(node.left != null) {
                insert(node.left, n);
            }
            else {
                node.left = new Node(n, null, null);
            }
        }
        else {
            if(node.right != null) {
                insert(node.right, n);
            }
            else {
                node.right = new Node(n, null, null);
            }
        }
    }

    public static void postOrder(Node node) {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
