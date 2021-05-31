package tree.l104_maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtils;

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
public class L104Copy2 {
    //recursive
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int cur, size;
        TreeNode p = null;
        while (!q.isEmpty()) {
            cur = 0;
            size = q.size();
            level++;
            while (cur < size) {
                p = q.poll();
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
                cur++;
            }
        }

        return level;
    }

    public static void main (String[] args) {
//        TreeNode node = TreeUtils.array2Tree(1);
//        TreeNode node = TreeUtils.array2Tree(1, 2);
//        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        TreeNode node = TreeUtils.array2Tree(1, 2, 3, null, null, 6, 7, null, null, null, null, 12, 13, 14, 15);
        System.out.println(new L104Copy2().maxDepth(node));
    }

}
