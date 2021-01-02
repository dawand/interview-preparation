import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelAverage {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(getAvergaes(root));

    }

    private static List<Double> getAvergaes(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove(0);
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            double average = sum / count;
            result.add(average);
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
