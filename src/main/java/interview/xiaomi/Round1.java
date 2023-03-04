package interview.xiaomi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Title
 * 二叉树层序遍历
 * Question description
 * 给定一个二叉树，返回二叉树的层序遍历结果。从左到右，一层一层
 */
public class Round1 {
   public static void main(String[] args) {
      test();
   }

   private static void test() {
      TreeNode node = getSampleNode();
      List<List<Integer>> levels = traversalInLevel(node);
      for (List<Integer> level : levels) {
         for (Integer i : level) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }

   private static TreeNode getSampleNode() {
      TreeNode root = new TreeNode(1);
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      for (int i = 0; i < 3; i++) {
         int count = queue.size();
         int cur = 0;
         while (cur < count) {
            TreeNode node = queue.poll();
            TreeNode left = new TreeNode(i * cur + 1);
            TreeNode right = new TreeNode(i * cur + 2);
            node.left = left;
            node.right = right;
            queue.offer(left);
            queue.offer(right);
            cur++;
         }
      }
      return root;
   }

   private static List<List<Integer>> traversalInLevel(TreeNode root) {
      if (root == null) return null;
      List<List<Integer>> levels = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         //count of current level
         int count = queue.size();
         int cur = 0;
         List<Integer> level = new ArrayList<>(count);

         while (cur < count) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            level.add(node.val);
            cur++;
         }
         levels.add(level);
      }

      return levels;
   }


}

class TreeNode {
   public TreeNode left;
   public TreeNode right;
   public int val;

   public TreeNode(int val) {
      this.val = val;
   }
}




