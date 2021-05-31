package tree.l102_binary_tree_level_order_traversal;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import linkedlist.ListNode;
import tree.TreeNode;
import tree.TreeUtils;

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
public class L102Copy2 {

    public List<List<Integer>> levelOrder (TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int cur, size;

        List<List<Integer>> listContainer = new ArrayList<>();
        while (!queue.isEmpty()) {
            cur = 0;
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (cur < size) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
                cur++;
            }
            listContainer.add(list);
        }

        return listContainer;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        TreeNode node1 = TreeUtils.array2Tree(null);
        TreeNode node2 = TreeUtils.array2Tree(1);
        TreeNode node3 = TreeUtils.array2Tree();
        L102Copy2 l = new L102Copy2();
        printList(l.levelOrder(node));
        printList(l.levelOrder(node1));
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
