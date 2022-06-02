/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        helper(head); //this method does the main job of flatening.
        return head; //head would always be the same.
    }

    public Node helper(Node childStart){
        Node temp = childStart; //the current node.
        Node nextTemp = null; //next of current node. It is saved temporarily because we will change the next of current node point to it's child.
        Node prev = null, childsLast = null; //prev would be used to return the last node of flattened list. ChildsLast : the prev returned from a helper method would be stored in this. This will then link itself with nextTemp.

        while(temp!=null){ //iterate the whole list.

            if(temp.child!=null){ //if the node has a child.
                nextTemp = temp.next; //saved so that the returned last node can link to it.
                temp.next= temp.child; //flattening i.e., point current next to child and make temp.child as null.
                temp.child=null;
                temp.next.prev=temp; //make child point to current.
                childsLast=helper(temp.next); //helper method takes the child as argument and return the last node of flattened list starting from child.
                childsLast.next=nextTemp;

                if(nextTemp!=null) //to avoid NPE.
                    nextTemp.prev=childsLast;
            }

            //this is same even if node doesn't have a child i.e., just go to next element.
            prev=temp;
            temp=temp.next;
        }

        return prev; //return the last node of flattened list.
    }
}
