package fastAndSlowPointers;

import linkedlist.LinkedList;
import linkedlist.LinkedListNode;
import linkedlist.PrintList;

import static java.lang.System.out;

public class CycleDetection {
    public static boolean detectCycle(LinkedListNode head) {
        if (head == null) {
            return false;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] input = { { 2, 4, 6, 8, 10 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            out.print(i + 1 + ".\tInput:");
            out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
