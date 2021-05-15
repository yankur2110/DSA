//MY SOLUTION

class Solution {
    
    //Doubly LinkedList Structure.
    class DoublyLinkedList{
        String val;
        DoublyLinkedList next;
        DoublyLinkedList prev;
        
        DoublyLinkedList(String val){
            this.val=val;
            next=null;
            prev=null;
        }    
    }
    
    //Head and Tail of DoublyLinkedList.
    DoublyLinkedList head, tail = null;
    
    //Constructing DoublyLinkedList
    void addNode(String val){
        DoublyLinkedList Node = new DoublyLinkedList(val);
        if(head==null){
            head = Node;
            tail = Node;
        }else{
            tail.next = Node;
            Node.prev=tail;
            tail=Node;
        }
    }
    
    public int evalRPN(String[] tokens) {
        List<String> symbolList = new ArrayList<>();
        symbolList.add("+");
        symbolList.add("-");
        symbolList.add("*");
        symbolList.add("/");
        
        for(int i=0; i<tokens.length; i++){
            addNode(tokens[i]);
        }
        
        return computeDoublyLinkedList(symbolList, head);     
    }
    
    public int computeDoublyLinkedList(List<String> symbolList, DoublyLinkedList head){
        
        DoublyLinkedList ptr = head;
        int value=0;
        
        while(ptr!=null){
            
            if(symbolList.contains(ptr.val)){
                DoublyLinkedList prev1 = ptr.prev;
                DoublyLinkedList prev2 = prev1.prev;
                //compute the result
                
                switch(ptr.val){
                    case "+":
                        value = Integer.parseInt(prev2.val)+Integer.parseInt(prev1.val);
                        break;
                    case "-":
                        value = Integer.parseInt(prev2.val)-Integer.parseInt(prev1.val);
                        break;
                    case "*":
                        value = Integer.parseInt(prev2.val)*Integer.parseInt(prev1.val);
                        break;
                    case "/":
                        value = Integer.parseInt(prev2.val)/Integer.parseInt(prev1.val);
                        break;
                }
                
                prev2.val=String.valueOf(value);
                
                //relynk
                prev2.next=ptr.next;
                if(ptr.next!=null){
                    ptr.next.prev=prev2;
                }
            }
            
            ptr=ptr.next;
        }
        
        return Integer.parseInt(head.val);
    }
    
    
}

// EFFICIENT SOLUTION USING STACK

class Solution {
    public int evalRPN(String[] s) {
        Stack<Integer> stk=new Stack<Integer>();
        for(int i=0;i<s.length;i++)
        {
             if(s[i].equals("+"))
             {
               stk.push(stk.pop()+stk.pop());
             }
            else if(s[i].equals("-"))
             {
                stk.push(-stk.pop()+stk.pop());
             }
            else if(s[i].equals("*"))
             {
                stk.push(stk.pop()*stk.pop());
             }
            else if(s[i].equals("/"))
            {
                 int no= stk.pop();
                 stk.push(stk.pop()/no);
            }
            else
            {
                stk.push(Integer.parseInt(s[i]));
            }
        }
        return stk.pop();
    }
}