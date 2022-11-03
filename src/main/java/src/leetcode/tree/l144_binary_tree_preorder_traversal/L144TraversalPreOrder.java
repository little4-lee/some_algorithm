package leetcode.tree.l144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
import common.TreeUtils;

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
public class L144TraversalPreOrder {

    public List<Integer> preOrderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                list.add(p.val);
                if (p.right != null) stack.push(p.right);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
            }
        }

        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L144TraversalPreOrder().preOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }

}
