import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from mid
        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test 1
        ListNode head1 = arrayToList(new int[]{-10, -3, 0, 5, 9});
        TreeNode root1 = new Solution().sortedListToBST(head1);
        printLevelOrderWithNulls(root1); // Expected Output: [0, -10, 5, null, -3, null, 9]

        // Test 2: empty list
        ListNode head2 = null;
        TreeNode root2 = new Solution().sortedListToBST(head2);
        printLevelOrderWithNulls(root2); // Expected Output: []
    }

    // Helper to convert array to ListNode
    public static ListNode arrayToList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Print BST in level order including nulls
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

        // Trim trailing nulls
        int i = output.size() - 1;
        while (i >= 0 && output.get(i).equals("null")) {
            i--;
        }

        output = output.subList(0, i + 1);
        System.out.println(output);
    }
}