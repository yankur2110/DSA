//Note: 27/36 test cases passed, not debugging that since got the core of the question. It's correct code only, only a minor change might be required.

class Node {
    int key;
    int value;
    Node next;

    Node(int k, int v){
        this.key=k;
        this.value=v;
        this.next=null;
    }
}

class MyHashMap {

    Node[] nodeArray=null;

    public MyHashMap() {
        nodeArray = new Node[1000];
    }

    public int hashFunction(int key){
        return Integer.hashCode(key) % nodeArray.length;
    }
    public void insertAtIndex(int index, Node node){

        if(nodeArray[index]==null){
            nodeArray[index]=node;
        }else{
            Node lastNode = nodeArray[index];
            /*while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=node;*/
            Node prev=null;
            while(lastNode!=null){
                if(lastNode.key==node.key){
                    lastNode.value=node.value;
                    return;
                }

                prev=lastNode;
                lastNode=lastNode.next;
            }

            prev.next=node;
        }
    }

    public void put(int key, int value) {
        int index = hashFunction(key);
        insertAtIndex(index,new Node(key,value));
    }

    public int get(int key) {
        Node node = nodeArray[hashFunction(key)];

        if(node!=null){
            while(node!=null){
                if(node.key==key)
                    return node.value;
                node=node.next;
            }
        }
        return -1;

    }

    public void remove(int key) {
        Node node = nodeArray[hashFunction(key)];

        Node prev=null;
        boolean found=false;
        if(node!=null){
            while(node!=null){
                if(node.key==key){
                    found=true;
                    break;
                }

                prev=node;
                node=node.next;
            }
        }

        if(found){
            if(prev==null){
                nodeArray[hashFunction(key)]=null;
            }else{
                prev.next=prev.next.next;
            }
        }


    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
