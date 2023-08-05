package LinkedList;

import static java.lang.System.*;

public class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head)
    {
        LinkedListNode temp = head;

        while (temp != null) {
            out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        out.print(" → null ");
    }
}
