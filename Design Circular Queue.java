class MyCircularQueue {
    final int[] arr;
    int elementsPresent=0;
    int frontIndex=0;
    int rearIndex=-1; //initialized with -1 because, rearIndex is incremented before adding.

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        elementsPresent++;

        rearIndex = (rearIndex+1)%arr.length;
        arr[rearIndex] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        elementsPresent--;

        frontIndex = (frontIndex+1)%arr.length;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[frontIndex];
    }

    public int Rear() {
       return isEmpty() ? -1 : arr[rearIndex];
    }

    public boolean isEmpty() {
        return elementsPresent==0;
    }

    public boolean isFull() {
        return elementsPresent==arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
