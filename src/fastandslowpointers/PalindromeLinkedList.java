package fastandslowpointers;

import linkedlist.LinkedList;
import linkedlist.LinkedListNode;
import linkedlist.PrintList;

import static java.lang.System.out;
import static linkedlist.LinkedListReversal.reverseLinkedList;

public class PalindromeLinkedList {
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode middle = getMiddle(head);
        LinkedListNode reverseListNode = reverseLinkedList(middle);
        LinkedListNode start = head;
        while (start != null && reverseListNode != null) {
            if (start.data == reverseListNode.data) {
                start = start.next;
                reverseListNode = reverseListNode.next;
            } else return false;
        }
        return true;
    }

    public static LinkedListNode getMiddle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {

        int[][] input = {
                {2, 4, 6, 4, 2},
                {0, 3, 5, 5, 0},
                {9, 27, 4, 4, 27, 9},
                {5, 4, 7, 9, 4, 5},
                {5, 10, 15, 20, 15, 10, 5}
        };

        for (int i = 0; i < input.length; i++) {
            out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if (result) {
                out.println("Yes");
            } else {
                out.println("No");
            }
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
