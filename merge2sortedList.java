/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
The new list should be made up of nodes from list1 and list2.
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        If one list is empty, the merged result is just the other list and to
        Prevents null pointer errors later.
        */
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode head;//start of the merged list
        ListNode pt1 = list1;// pointer traversing list1
        ListNode pt2 = list2;// pointer traversing list2
        ListNode tail;// tail pointer of merged list (used to build it)

        // Now we need to choose the smallest head
        if (pt1.val < pt2.val) {
            head = pt1;
            pt1 = pt1.next;
        } else {
            head = pt2;
            pt2 = pt2.next;
        }        

        tail = head;// will always point to the last node in the merged list which 
        // head right now

        while (pt1 != null && pt2 != null) {
            if (pt1.val < pt2.val) {
                tail.next = pt1;
                pt1 = pt1.next;
            } else {
                tail.next = pt2;
                pt2 = pt2.next;
            }
            tail = tail.next; // the tail ndoe is moved only as it is traversing
        }

        // Now attach remaining node of list1
        while (pt1 != null) {
            tail.next = pt1;    
            pt1 = pt1.next;
            tail = tail.next;
        }

        // Now attach remaining node of list2
        while (pt2 != null) {
            tail.next = pt2;
            pt2 = pt2.next;
            tail = tail.next;
        }

        return head;
    }
}
