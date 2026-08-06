package leetcode.tree.l144_binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
import common.TreeUtils;

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
public class L144Copy8 {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        // 游标
        TreeNode cur = root;
        // stack，暂存右节点
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L144Copy8().preOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }
}
