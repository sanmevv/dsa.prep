import java.util.*;

public class binaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            // System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            // System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    /*
     * public static void levelOrder(Node root) {
     * if(root == null){
     * return;
     * }
     * Queue<Node> q = new LinkedList<>();
     * q.add(root);
     * q.add(null);
     * 
     * while (!q.isEmpty()) {
     * Node currNode = q.remove();
     * if (currNode == null) {
     * System.out.println();
     * if (q.isEmpty()) {
     * break;
     * } else {
     * q.add(null);
     * }
     * } else {
     * System.out.print(currNode.data + " ");
     * if (currNode.left != null) {
     * q.add(currNode.left);
     * }
     * if (currNode.right != null) {
     * q.add(currNode.right);
     * }
     * }
     * }
     * }
     */
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = count(root.left);
        int rightNodes = count(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightBT(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightBT(root.left);
        int rightHeight = heightBT(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println("      ");
        inorder(root);
        System.out.println("      ");
        postorder(root);
        System.out.println("      ");
        // levelOrder(root);
        System.out.println(count(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heightBT(root));

    }

}
