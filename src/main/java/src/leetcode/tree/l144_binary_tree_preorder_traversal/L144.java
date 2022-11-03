package leetcode.tree.l144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.tree.TreeNode;

/**
 * Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 */
public class L144 {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                list.add(p.val);
                if (p.right != null) stack.push(p.right);
                p = p.left;
            }
            if (!stack.isEmpty()) p = stack.pop();
        }

        return list;
    }
}
