package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if (null == root) return null;

        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (node != null) {
            if (node.left != null) {
                stack.push(node);
            }
        }

        return list;
    }
}
