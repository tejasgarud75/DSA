package org.example;

import java.util.ArrayList;
import java.util.List;

public class LinkListProblem {

    static final class ListNode {
        int val;
        ListNode next;

        // Default constructor
        public ListNode() {}

        // Constructor with value parameter
        public ListNode(int val) {
            this.val = val;
        }

        // Constructor with both value and next node parameters
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return new int[]{-1, -1};
            }

            ListNode prev = head;
            ListNode curr = head.next;
            ListNode next = curr.next;
            int index = 1;
            List<Integer> criticalPoints = new ArrayList<>();

            while (next != null) {
                if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                    criticalPoints.add(index);
                }

                prev = curr;
                curr = next;
                next = next.next;
                index++;
            }

            if (criticalPoints.size() < 2) {
                return new int[]{-1, -1};
            }

            int minDistance = Integer.MAX_VALUE;
            int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

            for (int i = 1; i < criticalPoints.size(); i++) {
                minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
            }

            return new int[]{minDistance, maxDistance};
        }

        public static void main(String[] args) {
            // Example usage
            ListNode head = new ListNode(1);
            head.next = new ListNode(3);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(5);
            head.next.next.next.next = new ListNode(1);

            Solution solution = new Solution();
            int[] result = solution.nodesBetweenCriticalPoints(head);
            System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [1, 2]
        }
    }
}
