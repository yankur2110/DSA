class Solution {
    
    /* logic is to sort the individual string in each loop, traverse one by one -> put in map -> and to list whichever reqd
for ref: https://www.youtube.com/watch?v=ptgykfAEax8
*/
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        List<String> tempList = null;
        int index =0;
        
        for(int i=0;i<strs.length;i++){
            
            String tempStr = strs[i];
            char[] tempCharArray = tempStr.toCharArray();
            Arrays.sort(tempCharArray);
            tempStr = new String(tempCharArray);
            
            if(hashMap.get(tempStr)!=null){
                result.get(hashMap.get(tempStr)).add(strs[i]);
                
            }else{
                tempList = new ArrayList<String>();
                tempList.add(strs[i]);
                result.add(tempList);
                hashMap.put(tempStr,index);
                index++;
            }
            
            
            
        }
        
        return result;
        
    }
}