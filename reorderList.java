/*
You are given the head of a singly linked-list.
The positions of a linked list of length = 7 for example, can intially be represented as:
[0, 1, 2, 3, 4, 5, 6]

Reorder the nodes of the linked list to be in the following order:
[0, 6, 1, 5, 2, 4, 3]

Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
[0, n-1, 1, n-2, 2, n-3, ...]
You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
*/

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while(tail != null){
            list.add(tail);
            tail = tail.next;
        }
        // this fills the array with nodes.
        // now we need nodes in the order 0, n - 1, 1, n - 2...

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            list.get(left).next = list.get(right);
            left++;

            if (left == right) break;

            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;
    }
}
