/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node tempNode1 = head;
        Node head2 = null;
        Node tempNode2 = head2;
        
        HashMap<Node,Node> hashMap = new HashMap<Node,Node>();
        
        while(head!=null){
            if(head2==null){
                head2=new Node(head.val);
                tempNode2 = head2;
            }else{  
                tempNode2.next = new Node(head.val);
                tempNode2=tempNode2.next;
            }
            hashMap.put(head,tempNode2);
            head=head.next;
        }
        
        head=tempNode1;
        tempNode2=head2;
        while(head!=null){
            tempNode2.random = hashMap.get(head.random);
            head=head.next;
            tempNode2=tempNode2.next;
        }
        
        return head2;
    }
}