package interview.langzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Main
 * @Author: elon
 * @CreateDate: 2023/2/3 21:58
 * @Description:
 */

class TreeNode<T> {
    public TreeNode<T> parent;
    public TreeNode<T> leftChild;
    public TreeNode<T> rightChild;
    public T value;

    public TreeNode(T value) {
        this.value = value;
    }
}

class Solution {
    public TreeNode<Integer> generateTree(int n) {
        if (n == 0) return null;
        TreeNode<Integer> root = new TreeNode<>(0);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < n; i++) {
            int levelCount = queue.size();
            int cur = 0;
            while (cur < levelCount) {
                TreeNode<Integer> node = queue.poll();
                TreeNode<Integer> leftChild = new TreeNode<>(2 * node.value + 1);
                leftChild.parent = node;
                node.leftChild = leftChild;
                queue.offer(leftChild);

                TreeNode<Integer> rightChild = new TreeNode<>(2 * node.value + 2);
                rightChild.parent = node;
                node.rightChild = rightChild;
                queue.offer(rightChild);
                cur++;
            }
        }
        return root;
    }
}

class Test {
    public static void test() {
        Solution solution = new Solution();
        solution.generateTree(0);
        solution.generateTree(1);
        solution.generateTree(4);
    }

    public static void main(String[] args) {
        test();
    }
}
