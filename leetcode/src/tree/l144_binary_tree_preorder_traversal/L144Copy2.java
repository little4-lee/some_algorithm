package tree.l144_binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;
import tree.TreeUtils;

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
public class L144Copy2 {

    public List<Integer> preOrderTraversal (TreeNode root) {

        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new LinkedList<>();

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                list.add(p.val);
                if (p.right != null) s.push(p.right);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
            }
        }

        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L144Copy2().preOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }
}
