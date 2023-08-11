package fastandslowpointers;

import linkedlist.LinkedList;
import linkedlist.LinkedListNode;
import linkedlist.PrintList;

import static java.lang.System.out;

public class MiddleOfLinkedList {
    public static LinkedListNode middleNode(LinkedListNode head) {
        if (head.next == null) {
            return head;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};

        for (int i = 0; i < input.length; i++) {
            out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            out.print(".\tInput linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            out.print("\tMiddle of the linked list is:  ");
            out.println(middleNode(list.head).data);
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
