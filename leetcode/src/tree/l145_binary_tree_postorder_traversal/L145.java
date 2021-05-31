package tree.l145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

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
public class L145 {
    public List<Integer> postOrderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        TreeNode p = root;
        TreeNode lastVisit = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            if (p.right == null || p.right == lastVisit) {
                stack.pop();
                list.add(p.val);
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }

        return list;
    }
}
