package leetcode.tree.l111_minimum_depth_of_binary_tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
public class L111Copy {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int level = 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        int cur,count;
        boolean isStop = false;

        while (!queue.isEmpty() && !isStop) {
            cur = 0;
            count = queue.size();

            while (cur < count) {
                cur++;
                TreeNode p = queue.poll();
                if (p.left == null && p.right == null) {
                    isStop = true;
                    break;
                } else {
                    if (p.left != null) queue.offer(p.left);
                    if (p.right != null) queue.offer(p.right);
                }
            }

            level++;
        }

        return level;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        System.out.println(new L111Copy().minDepth(node));
    }
}
