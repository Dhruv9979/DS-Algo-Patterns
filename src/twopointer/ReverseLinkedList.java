package twopointer;

import LinkedList.LinkedList;
import LinkedList.LinkedListNode;
import LinkedList.PrintList;

import static java.lang.System.*;

public class ReverseLinkedList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode left = head;
        LinkedListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {{23, 89, 10, 5, 67, 39, 70, 28}, {34, 53, 6, 95, 38, 28, 17, 63, 16, 76}, {288, 224, 275, 390, 4, 383, 330, 60, 193}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}};

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList();
            inputLinkedList.createLinkedList(inputs[i]);
            out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            out.print("\n\tn = " + n[i]);
            out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n[i]));
            out.println();
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
