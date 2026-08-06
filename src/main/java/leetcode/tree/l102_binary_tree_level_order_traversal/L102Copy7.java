package leetcode.tree.l102_binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class L102Copy7 {

    public List<List<Integer>> levelOrder (TreeNode root) {
        // 边界检查
        if (root == null) {
            return null;
        }

        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 这一层循环每次都产出一层
            List<Integer> levelList = new LinkedList<>();
            int cur = 0;
            int levelSize = queue.size();
            while (cur < levelSize) {
                // 每次处理一个节点
                cur++;
                TreeNode temp = queue.poll();
                if (temp != null) {
                    levelList.add(temp.val);
                }
                if (temp != null && temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp != null && temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            list.add(levelList);
        }
        return  list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
//        TreeNode node1 = TreeUtils.array2Tree(null);
        TreeNode node2 = TreeUtils.array2Tree(1);
        TreeNode node3 = TreeUtils.array2Tree();
        L102Copy7 l = new L102Copy7();
        printList(l.levelOrder(node));
//        printList(l.levelOrder(node1));
        printList(l.levelOrder(node2));
        printList(l.levelOrder(node3));
    }

    private static void printList (List<List<Integer>> list) {
        if (list == null) {
            System.out.println("null list");
            return;
        }

        if (list.size() == 0) {
            System.out.println("empty list");
            return;
        }

        for (List<Integer> l : list) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
