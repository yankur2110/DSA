class StockSpanner {

    Stack<int[]> stack = null; //simple Stack<Integer> would not work here since it's not a simple monotonous stack problem but a monotonous stack of monotonous stack problem.
    //we are using int[], it would have 2 elements. First would be the current price and second would the stock span i.e., all consecutive stocks having price <= current stock price.

    public StockSpanner() {
        stack  = new Stack<>(); //intialize the stack.
    }

    public int next(int price) {
        int res=1;
        while(!stack.isEmpty() && price>=stack.peek()[0]){ //keep on clubbing the elements till the time stack elements i.e., previous stock prices are <=price. Note previous stock prices would already be clubbed.
            res+=stack.pop()[1]; //keep on adding the clubbed stock number.
        }
        stack.push(new int[]{price, res}); //add the current price and the respective stock span.
        return res; //return result.
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
