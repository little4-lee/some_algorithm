package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class L145Copy {
    public List<Integer> postorderTraversal (TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode p = root;
        TreeNode lastVisit = null;
        Stack<TreeNode> s = new Stack<>();

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.peek();

            if (p.right == null || p.right == lastVisit) {
                s.pop();
                list.add(p.val);
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }
        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6);

        //        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


        //        TreeUtils.printTree(node);
        List<Integer> list = new L145Copy().postorderTraversal(node);
        for (int i : list) System.out.print(i + " ");

    }
}
