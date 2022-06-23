class MyQueue {

    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        //whenever new element is coming, pop all the elements of mainStack and push to the  tempStack.
        //then push the new element to mainStack.
        //then push all the elements of tempStack to main stack.
        while(!mainStack.isEmpty()){
            tempStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while(!tempStack.isEmpty()){
            mainStack.push(tempStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
