package leetcode.tree.l94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

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
public class L94 {
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }

        return list;
    }
}
