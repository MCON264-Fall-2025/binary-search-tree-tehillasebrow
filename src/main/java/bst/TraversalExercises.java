package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative preorder using Deque as a stack
        // Hint: push root; while stack not empty:
        //   pop node, visit it, then push right child, then left child
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.value);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative inorder
        // Hint: use a pointer 'curr' and a stack:
        //   while (curr != null || !stack.isEmpty()) { ... }
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        if (root == null) return result;
        TreeNode<T> curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.value);
                curr = curr.right;
            }
        }
        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // You may use two stacks, or one stack with a previous-node pointer.
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        Deque<TreeNode<T>> prev = new ArrayDeque<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> curr = stack.pop();
            prev.push(curr);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        while (!prev.isEmpty()) {
            result.add(prev.pop().value);
        }

        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement BFS using a Queue<TreeNode<T>>
        Queue<TreeNode<T>> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> curr = queue.remove();
            result.add(curr.value);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return result;
    }
}

