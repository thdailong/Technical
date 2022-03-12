import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int data;
    private int count;
    private Node left;
    private Node right;

    public Node() {
        this.data = 0;
        this.count = 0;
        this.left = null;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
        this.count = 1;
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

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
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
            else if (data == tmp.getData()) {
                tmp.setCount(tmp.getCount()+1);
                return;
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
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            for (int i = 1; i <= x.getCount(); ++i) {
                result+=x.getData()+",";
            }
            if (x.getLeft() != null) {
                queue.add(x.getLeft());
            }
            if (x.getRight() != null) {
                queue.add(x.getRight());
            }
        }
    }

    public String getResult() {
        return result;
    }
}

public class duplicate {
    public static void main(String[] args) {
        BST tree = new BST();
        try {
            File myFileRead = new File("duplicate_input.txt");
            Scanner sc = new Scanner(myFileRead);
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) {
                int data = sc.nextInt();
                //System.out.println(data);
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
            FileWriter myFileWrite = new FileWriter("duplicate_output.txt");
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