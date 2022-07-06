class Solution {
    public String customSortString(String order, String s) {
        char[] chArray = s.toCharArray();
        HashMap<Character, Integer> charToFreqMap = new HashMap<>();

        for(char ch : chArray){
            charToFreqMap.put(ch, charToFreqMap.getOrDefault(ch,0)+1);
        }

        chArray = order.toCharArray();
        StringBuilder resultString = new StringBuilder();

        for(char ch : chArray){
            if(charToFreqMap.containsKey(ch)){
                int count = charToFreqMap.get(ch);

                while(count-->0){
                    resultString.append(ch);
                }

                charToFreqMap.remove(ch);
            }
        }

        for(Map.Entry<Character, Integer> entry : charToFreqMap.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();

            while(count-->0){
                resultString.append(ch);
            }

        }

        return resultString.toString();
    }
}
