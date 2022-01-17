class FreqStack {
    int maxFreq=0;
    Map<Integer, Stack<Integer>> freqToNumbersMap;
    Map<Integer, Integer> numFreqMap;

    public FreqStack() {
        freqToNumbersMap = new HashMap<>();
        numFreqMap = new HashMap<>();

    }

    public void push(int val) {
        int newFreqOfVal = numFreqMap.getOrDefault(val,0)+1;
        maxFreq = Math.max(newFreqOfVal, maxFreq);
        numFreqMap.put(val,newFreqOfVal);

        if(!freqToNumbersMap.containsKey(newFreqOfVal)){
            freqToNumbersMap.put(newFreqOfVal, new Stack());
        }

        freqToNumbersMap.get(newFreqOfVal).add(val);
    }

    public int pop() {
        int val = freqToNumbersMap.get(maxFreq).pop();
        numFreqMap.put(val, maxFreq-1);
        if(freqToNumbersMap.get(maxFreq).size()==0)
            maxFreq--;
        return val;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
