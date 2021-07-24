class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i: nums)
            map.put(i,map.getOrDefault(i,0)+1);
        
        List<Integer>[] freqArray = new List[nums.length+1];
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(freqArray[freq]==null){
                freqArray[freq]=new ArrayList<>();
            }
            freqArray[freq].add(key);
        }
        
        int[] resultArray = new int[k];
        int index=0;
        
        for(int i=freqArray.length-1;i>=0 && index!=k; i--){
            
            if(freqArray[i]!=null){
                for(int num: freqArray[i]){
                    resultArray[index++]=num;
                }
            }
        }
        
        return resultArray;

    }
}
