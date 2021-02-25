package tree;

public class TreeUtils {
    /**
     * @param arr null为空节点
     * @return
     */
    public static TreeNode array2Tree(Integer... arr) {
        if (arr == null || arr.length == 0) return null;

        Integer [] treeArr = new Integer[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            treeArr[i + 1] = arr[i];
        }

        TreeNode root = getNode(treeArr, 1);
        return root;
    }

    private static TreeNode getNode(Integer [] arr, int index) {
        if (index < arr.length) {
            if (arr[index] == null) return null;

            TreeNode node = new TreeNode(arr[index]);
            node.left = getNode(arr, 2 * index);
            node.right = getNode(arr, 2 * index + 1);
            return node;
        }
        return null;
    }

    public static void printTree(TreeNode node) {
        System.out.println(new L144().preOrderTraversal(node));
    }
}
