package leetcode.tree.l145_binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
import common.TreeUtils;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 */
public class L145Copy11 {
    public List<Integer> postOrderTraversal (TreeNode root) {
        List<Integer> list = new LinkedList<>();

        TreeNode cur = root;
        TreeNode lastVisited = null;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            // 追踪到最左边的节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                TreeNode inorderNode = stack.peek();
                // 看右节点
                if (inorderNode.right == null || inorderNode.right == lastVisited) {
                    list.add(inorderNode.val);
                    lastVisited = inorderNode;
                    stack.pop();
                } else {
                    cur = inorderNode.right;
                }
            }
        }

        return list;
    }

    public static void main (String[] args) {
        //        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
        //        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L145Copy11().postOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");

    }
}
