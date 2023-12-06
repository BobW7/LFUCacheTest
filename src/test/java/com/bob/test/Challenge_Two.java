package com.bob.test;

public class Challenge_Two {


    public static void main(String[] args) {
        int[] testArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode nodeA = initLinkList(testArr);
        nodeA = testChallenge(nodeA);
        while (nodeA != null) {
            System.out.println(nodeA.val);
            nodeA = nodeA.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = dummyHead.next;
            dummyHead.next = next;
        }
        return dummyHead.next;

    }

    public static ListNode testChallenge(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode left = head;
        ListNode pre = head;
        cur = head;
        int times = 0;
        while (times < len / 2) {
            times++;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        cur = reverseList(cur);
        while (left != null) {
            ListNode next1 = left.next;
            ListNode next2 = cur.next;
            left.next = cur;
            cur.next = next1;
            left = next1;
            cur = next2;
        }
        return head;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode initLinkList(int[] vals) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; i < vals.length; i++) {
            ListNode newNode = new ListNode(vals[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummyHead.next;

    }


}
