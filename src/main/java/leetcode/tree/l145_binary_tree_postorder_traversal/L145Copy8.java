package leetcode.tree.l145_binary_tree_postorder_traversal;

import java.sql.ClientInfoStatus;
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
public class L145Copy8 {
    public List<Integer> postOrderTraversal (TreeNode root) {
        List<Integer> list = new LinkedList<>();

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = null;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.peek();
                if (temp.right == null || temp.right == lastVisit) {
                    //pop it
                    list.add(temp.val);
                    stack.pop();
                    lastVisit = temp;
                } else {
                    p = temp.right;
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
        List<Integer> list = new L145Copy8().postOrderTraversal(node);
        for (int i : list) System.out.print(i + " ");

    }
}
