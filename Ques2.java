// Q2. Given the root of a binary tree, check if it is a complete binary tree or not. A complete binary 
// tree is a binary tree in which every level, except possibly the last, is filled, and all nodes are as far 
// left as possible.
// Output:
// Complete Binary Tree
// Output: Not a Complete Binary Tree

import java.util.ArrayDeque;
import java.util.Queue;

// A class to store a binary tree node
class Node {
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

class Ques2 {
    // Function to check if a given binary tree is complete or not
    public static boolean isComplete(Node root) {
        // return if the tree is empty
        if (root == null) {
            return true;
        }

        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // to store the current node
        Node front;

        // flag to mark the end of full nodes
        boolean flag = false;

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node
            front = queue.poll();

            // if we have encountered a non-full node before and the current node
            // is not a leaf, a tree cannot be complete
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }

            // if the left child is empty and the right child exists,
            // a tree cannot be complete
            if (front.left == null && front.right != null) {
                return false;
            }

            // if the left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }

            // if the right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (isComplete(root)) {
            System.out.println("Complete binary tree");
        } else {
            System.out.println("Not a complete binary tree");
        }
    }
}
