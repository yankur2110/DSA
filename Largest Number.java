class Solution {
    public String largestNumber(int[] nums) {
        
        String[] strArray = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strArray[i]=Integer.toString(nums[i]);
        }
        
        Arrays.sort(strArray, new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); 
		    }
        });
        
        //to handle case, when input integer array has all elements as 0.
        if(strArray[0].charAt(0)=='0')
            return "0";
        
        String returnStr="";
        
        for(String str: strArray){
            returnStr+=str;
        }
        
        return returnStr;
    }
}