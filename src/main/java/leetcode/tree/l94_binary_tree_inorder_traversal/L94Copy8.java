package leetcode.tree.l94_binary_tree_inorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
import common.TreeUtils;

/**
 * Binary Tree Inorder Traversal
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 */
public class L94Copy8 {
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> list = new LinkedList<>();

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode inorderNode = stack.pop();
                list.add(inorderNode.val);
                if (inorderNode.right != null) {
                    cur = inorderNode.right;
                }
            }
        }

        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(1, 2, 3, 4, null, 6, null, null, 9);


//        TreeUtils.printTree(node);
        List<Integer> list = new L94Copy8().inorderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }
}
