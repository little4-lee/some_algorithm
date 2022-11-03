package leetcode.tree.l104_maximum_depth_of_binary_tree;

import leetcode.tree.TreeNode;
import leetcode.tree.TreeUtils;

/**
 * Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class L104Copy {
    //recursive
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        System.out.println(new L104Copy().maxDepth(node));
    }

}
