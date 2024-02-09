import static java.lang.Math.max;

public class AVL {
    static private class Node
    {
        Node left=null;
        Node right=null;

        int data;
        int height;
        Node(int data)
        {
            this.data=data;
            height=-1;
        }
        Node(){}
    }

    private Node root=null;

    AVL(int data)
    {
        root=new Node(data);
    }
    AVL(){}

    int heightOfNode(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return heightOfNode(N.left) - heightOfNode(N.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(heightOfNode(y.left), heightOfNode(y.right)) + 1;
        x.height = max(heightOfNode(x.left), heightOfNode(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(heightOfNode(x.left), heightOfNode(x.right)) + 1;
        y.height = max(heightOfNode(y.left), heightOfNode(y.right)) + 1;

        // Return new root
        return y;
    }


    private Node insert(Node root,int data)
    {
        if(root==null)
        {
            root=new Node(data);

        }

            if(data>root.data)
            {
                root.right=insert(root.right,data);

            }
            else {
                root.left=insert(root.left,data);

            }
        root.height = 1 + max(heightOfNode(root.left),
                heightOfNode(root.right));
        int balance = getBalance(root);
        

        // If this root becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && data < root.left.data)
            return rightRotate(root);

        // Right Right Case 
        if (balance < -1 && data > root.right.data)
            return leftRotate(root);

        // Left Right Case 
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case 
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        /* return the (unchanged) root pointer */
        
        return root;

    }

    void insert(int data)
    {
        root=insert(root,data);
    }
}
