package leetcode.tree.l104_maximum_depth_of_binary_tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import leetcode.tree.TreeNode;

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
public class L104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int level = 0;
        TreeNode p = null;
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.offer(root);
        int curIndex,lastIndex;

        while (!queue.isEmpty()) {
            curIndex = 0;
            lastIndex = queue.size();

            while (curIndex < lastIndex) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                curIndex++;
            }
            level++;
        }

        return level;
    }
}
