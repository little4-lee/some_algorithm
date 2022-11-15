package leetcode.tree.l102_binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import common.TreeNode;
import common.TreeUtils;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class L102Copy {

    public List<List<Integer>> levelOrder (TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        int cur,count;

        while (!queue.isEmpty()) {
            cur = 0;
            count = queue.size();
            List<Integer> innerList = new LinkedList<>();
            list.add(innerList);

            while (cur < count) {
                cur++;
                TreeNode p = queue.poll();
                innerList.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
        }

        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        List<List<Integer>> list = new L102Copy().levelOrder(node);

        for (List<Integer> l : list) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
