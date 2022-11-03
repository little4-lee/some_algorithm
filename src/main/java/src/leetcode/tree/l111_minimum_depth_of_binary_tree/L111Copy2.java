package leetcode.tree.l111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.TreeNode;
import leetcode.tree.TreeUtils;

/**
 * Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
public class L111Copy2 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode p = null;
        int cur, size;
        while (!q.isEmpty()) {
            level++;
            cur = 0;
            size = q.size();
            while (cur < size) {
                p = q.poll();
                if (p.left == null && p.right == null) return level;
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);

                cur++;
            }
        }

        return level;
    }

    public static void main (String[] args) {
//        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
//        TreeNode node = TreeUtils.array2Tree(1);
//        TreeNode node = TreeUtils.array2Tree(1, 2);
        TreeNode node = TreeUtils.array2Tree(1, 2, 3, null, null, 6, 7, null, null, null, null, 12, 13, 14, 15);
        System.out.println(new L111Copy2().minDepth(node));
    }
}
