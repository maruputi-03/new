import java.util.*;

public class Binary{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        printLevelOrderWithNulls(root);
    }

    // Method to print level order traversal including nulls
    public static void printLevelOrderWithNulls(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                output.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                output.add("null");
            }
        }

        // Remove trailing nulls for cleaner output
        int i = output.size() - 1;
        while (i >= 0 && output.get(i).equals("null")) {
            i--;
        }

        output = output.subList(0, i + 1);

        System.out.println(output);
    }
}

// TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Solution class
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}