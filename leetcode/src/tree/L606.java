package tree;

/**
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * <p>
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class L606 {

//    recursion method
    public String tree2str(TreeNode node) {
        if (node == null) return "";
        StringBuilder builder = new StringBuilder();
        node2str(node, builder);
        return builder.toString();
    }

    private void node2str (TreeNode node, StringBuilder builder) {
        if (node == null) return;
        builder.append(node.val);
        if (node.left != null || node.right != null) {
            //left
            builder.append("(");
            if (node.left != null) node2str(node.left, builder);
            builder.append(")");
            //right
            if (node.right != null) {
                builder.append("(");
                if (node.right != null) node2str(node.right, builder);
                builder.append(")");
            }
        }
    }


    public static void main (String[] args) {
        String log1 = new L606().tree2str(TreeUtils.array2Tree(1, 2, 3, 4, 5, null, null, 8));
        String log2 = new L606().tree2str(TreeUtils.array2Tree(1, 2, 3, 4));
        String log3 = new L606().tree2str(TreeUtils.array2Tree(1, 2, 3, null, 4));
        String log4 = new L606().tree2str(TreeUtils.array2Tree(1));
        System.out.println(log1);
        System.out.println(log2);
        System.out.println(log3);
        System.out.println(log4);
    }
}
