package leetcode.tree;

import java.util.Stack;

public class TreeTraversal {
    private void preOrderTraversal (TreeNode root) {
        TreeNode index = root;
        Stack<TreeNode> stack = new Stack<>();

        while (index != null || !stack.isEmpty()) {
            while (index != null) {
                System.out.print(index.val + " ");
                if (index.right != null) stack.push(index.right);
                index = index.left;
            }

            if (!stack.isEmpty()) {
                index = stack.pop();
            }
        }
        System.out.println();
    }

    private void inOrderTraversal (TreeNode root) {
        TreeNode t = root;
        Stack<TreeNode> s = new Stack<>();

        while (t != null || !s.isEmpty()) {
            while (t != null) {
                s.push(t);
                t = t.left;
            }
            if (!s.isEmpty()) {
                TreeNode temp = s.pop();
                System.out.print(temp.val + " ");
                t = temp.right;
            }
        }
        System.out.println();
    }

    private void postOrderTraversal (TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();
        TreeNode lastVisit = null;

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            p = s.peek();
            if (p.right == null || p.right == lastVisit) {
                s.pop();
                System.out.print(p.val + " ");
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }
    }

    public static void main (String[] args) {
        TreeNode root = TreeUtils.array2Tree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TreeTraversal traversal = new TreeTraversal();
        traversal.preOrderTraversal(root);
        traversal.inOrderTraversal(root);
        traversal.postOrderTraversal(root);
    }
}
