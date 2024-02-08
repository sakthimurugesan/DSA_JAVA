import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static private class Node {
        int data;
        Node right = null;
        Node left = null;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    private Node root = null;


    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    private void printPreoder(Node root) {
        if (root == null) {

            return;
        }
        System.out.print(root.data + " ");
        printPreoder(root.left);
        printPreoder(root.right);
    }

    private void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    private void printInder(Node root) {
        if (root == null) {

            return;
        }
        printInder(root.left);
        System.out.print(root.data + " ");
        printInder(root.right);
    }

    void inOrder() {
        printInder(root);
        System.out.println();
    }

    void preOrder() {
        printPreoder(root);
        System.out.println();
    }

    void postOrder() {
        printPostorder(root);
        System.out.println();
    }

    private int getMin(Node root) {
        if (root.left == null)
            return root.data;
        return getMin(root.left);
    }

    int getMin() {
        return getMin(root);
    }

    private int getMax(Node root) {
        if (root.right == null)
            return root.data;
        return getMax(root.right);
    }

    int getMax() {
        return getMax(root);
    }


    private boolean search(Node root, int data) {
        if (root != null) {
            if (root.data == data) {
                System.out.println("Found");
                return true;
            } else if (data < root.data) {
                return search(root.left, data);
            } else {
                return search(root.right, data);
            }
        }
        return false;
    }

    boolean search(int data) {
        return search(root, data);
    }

    private Node delMin(Node root) {
        if (root == null)
            return root;
        else if (root.left==null) {
            return root.right;
        }

        root.left=delMin(root.left);
        return root;
    }

    void deleteMin() {
        root = delMin(root);
    }

    private Node delMax(Node root)
    {
        if (root==null)return root;
        else if(root.right==null)
        {
            return root.left;
        }
        root.right=delMax(root.right);
        return root;
    }
    void deleteMax() {
        root=delMax(root);
    }

    void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if (root == null)
            return root;
        else if (data > root.data) {
            root.right = delete(root.right, data);

        } else if (data<root.data){
            root.left = delete(root.left, data);

        }
        else {
            //case 1 and case 2
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // case 3

            Node InorderSuccessor = inorderSuccessor(root.right);
            root.data = InorderSuccessor.data;
            root.right = delete(root.right, InorderSuccessor.data);

        }
        return root;
    }

    private Node inorderSuccessor(Node root)

    {
        while (root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    int depth()
    {
        int depth = 0;

        Queue<Node> q = new LinkedList<>();

        // Pushing first level element along with null
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();

            if (temp == null) {
                depth++;
            }

            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            else if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return depth;
    }

    private int height(Node root)
    {
        if(root==null)
            return 0;
        else
        {
            int left= height(root.left);
            int right= height(root.right);

            return Math.max(left,right)+1;
        }

    }

    private Node findNode(Node root,int data)
    {
        if(root==null)return root;

        if(root.data==data)return root;
        else if (data>root.data) {
            return findNode(root.right,data);

        }
        else
        {
            return findNode(root.left,data);
        }
    }

    int height(int data)
    {
        return height(findNode(root,data));
    }


}
