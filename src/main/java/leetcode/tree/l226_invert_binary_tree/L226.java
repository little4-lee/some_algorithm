package leetcode.tree.l226_invert_binary_tree;

import java.util.Stack;

import common.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class L226 {
    public TreeNode invertTree (TreeNode root) {
//        doInvertRecursively(root);
        doInvertByLoop(root);
        return root;
    }

    private void doInvertRecursively (TreeNode root) {
        if (root == null) return;

        swapNodes(root);
        doInvertRecursively(root.left);
        doInvertRecursively(root.right);
    }

    private void doInvertByLoop(TreeNode node) {
        TreeNode p = node;
        Stack<TreeNode> stack = new Stack<>();

        //pre-order traversal
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                swapNodes(p);
                if (p.right != null) stack.push(p.right);
                p = p.left;
            }
            if (!stack.isEmpty()) p = stack.pop();
        }
    }

    private void swapNodes (TreeNode root) {
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }

    public static void main (String[] args) {
//        TreeNode node = TreeUtils.array2Tree(4,2,7,1,3,6,9);
//        TreeUtils.printTreeLevel(node);
//        System.out.println();
//        TreeUtils.printTreeLevel(new L226().invertTree(node));
    }

}
