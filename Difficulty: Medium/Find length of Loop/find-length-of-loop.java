/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow=head, fast=head;
        int count=0;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                count++; // count the current node
                fast=fast.next; // and hop on to the next node
                while(fast!=slow){
                    count++;
                    fast=fast.next;
                }
                break;
            }
        }
        
        return count;
    }
}