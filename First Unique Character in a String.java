class Solution {
    public int firstUniqChar(String s) {
        
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                if(map.get(ch)!=Integer.MIN_VALUE)
                    list.remove(map.get(ch));
                map.put(ch,Integer.MIN_VALUE);
                
            }else{
                map.put(ch,i);
                list.add(i);
            }
        }
        
        if(list.size()==0)
            return -1;
        return list.get(0);
    }
}
