package tree.l102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.TreeNode;
import tree.TreeUtils;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class L102BTTraversalLevel {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> levels = new ArrayList<>();

        int cur, count;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            cur = 0;
            count = queue.size();
            List<Integer> level = new ArrayList<>();
            while (cur < count) {
                cur++;
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levels.add(level);
        }

        return levels;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        List<List<Integer>> list = new L102BTTraversalLevel().levelOrder(node);

        for (List<Integer> l :  list) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
