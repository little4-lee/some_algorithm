package leetcode.tree.l94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.tree.TreeNode;
import leetcode.tree.TreeUtils;

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
public class L94Copy {
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.empty()) {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }

        return list;
    }

    public static void main (String[] args) {
        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);


//        TreeUtils.printTree(node);
        List<Integer> list = new L94Copy().inorderTraversal(node);
        for (int i : list) System.out.print(i + " ");
    }
}
