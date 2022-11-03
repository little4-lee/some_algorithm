package leetcode.tree.l107_binary_tree_level_order_traversal_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import leetcode.tree.TreeNode;
import leetcode.tree.TreeUtils;

/**
 * 107. Binary Tree Level Order Traversal II
 * Easy
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class L107 {
    //recursive
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> list = new LinkedList<>();
//        levelOrderBottomInternal(root, 0, list);
//        Collections.reverse(list);
//        return list;
//    }
//
//    private void levelOrderBottomInternal (TreeNode root, int depth, List<List<Integer>> list) {
//        if (root == null) return;
//
//        if (depth >= list.size()) list.add(depth, new LinkedList<>());
//
//        List<Integer> inner = list.get(depth);
//        inner.add(root.val);
//
//        levelOrderBottomInternal(root.left, depth + 1, list);
//        levelOrderBottomInternal(root.right, depth + 1, list);
//    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        int cur, count;

        while (!queue.isEmpty()) {
            cur = 0;
            count = queue.size();
            List<Integer> inner = new LinkedList<>();
            list.add(inner);

            while (cur < count) {
                cur++;
                TreeNode p = queue.poll();
                inner.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
        }

        Collections.reverse(list);

        return list;
    }


    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        List<List<Integer>> list = new L107().levelOrderBottom(node);

        for (List<Integer> l : list) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }

}
