import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node() {
        this.data = 0;
        this.left = null;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = right;
    }



    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

class BST {
    private Node root;
    private String result;

    public BST() {
        root = null;
        result = "";
    }

    public void addNode(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }
        Node tmp = root;
        Node prev = null;
        while (tmp != null) {
            if (data < tmp.getData()) {
                prev = tmp;
                tmp = tmp.getLeft();
            }
            else if (data > tmp.getData()) {
                prev = tmp;
                tmp = tmp.getRight();
            }
        }
        if (data < prev.getData()) {
            prev.setLeft(node);
        }
        else if (data > prev.getData()) {
            prev.setRight(node);
        }
    }
    public void Solve() {
        Solve(root);
    }

    public void Solve(Node node) {
        if (node == null) return;
        Solve(node.getRight());
        result+= node.getData() + ",";
        Solve(node.getLeft());
    }

    public String getResult() {
        return result;
    }
}

public class ReversingTranversalTree {
    public static void main(String[] args) {
        BST tree = new BST();
        try {
            File myFileRead = new File("reverseTraversing_input.txt");
            Scanner sc = new Scanner(myFileRead);
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) {
                int data = sc.nextInt();
                tree.addNode(data);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }


        tree.Solve();
        //System.out.println(tree.getResult());

        try {
            FileWriter myFileWrite = new FileWriter("reverseTraversing_output.txt");
            String result = tree.getResult();
            String x = result.substring(0, result.length()-1);
            myFileWrite.write(x);
            myFileWrite.flush();
            myFileWrite.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}