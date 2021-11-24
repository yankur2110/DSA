class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> strList = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();
        
        paragraph = paragraph.substring(0,paragraph.length()).toLowerCase();
        paragraph = paragraph.replace(","," ");
        paragraph = paragraph.replace("."," ");
        paragraph = paragraph.replace("!"," ");
        paragraph = paragraph.replace("?"," ");
        paragraph = paragraph.replace("'"," ");
        paragraph = paragraph.replace(";"," ");
        paragraph = paragraph.replace(":"," ");
        
        
        
        String[] paraWords = paragraph.split(" ");
        String result="";
        int maxCount=Integer.MIN_VALUE;
        
        System.out.println(strList);
        
        for(String str : paraWords){
            if(strList.contains(str) || str.equals(""))
                continue;
            
            int count = map.getOrDefault(str,0)+1;
            if(count>=maxCount) {
                result = str;
                maxCount=count;
            }
            map.put(str, count);
        }
        
        return result;
        
    }
}
