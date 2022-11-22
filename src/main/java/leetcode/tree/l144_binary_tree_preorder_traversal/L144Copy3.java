package leetcode.tree.l144_binary_tree_preorder_traversal;

import common.TreeNode;
import common.TreeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 */
public class L144Copy3 {

    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) return null;

        List<Integer> list = new LinkedList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

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

    public static void main(String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L144Copy3().preOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }
}
