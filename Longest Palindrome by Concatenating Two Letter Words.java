class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        int count=0;
        int[] commonCharsFreq = new int[26];

        for(String str : words){

            if(str.charAt(0)==str.charAt(1)){
                commonCharsFreq[str.charAt(0)-'a']++;
                continue;
            }
            String rev = new StringBuilder(str).reverse().toString();
            if(map.containsKey(rev)){
                count+=4;

                if(map.get(rev)==1)
                    map.remove(rev);
                else
                    map.put(rev, map.get(rev)-1);
            }else{

                map.put(str,map.getOrDefault(str,0)+1);
            }

        }

        boolean flag = false;
        for(int i=0;i<26;i++){
            if(commonCharsFreq[i]%2==0){
                count = count + (2*commonCharsFreq[i]);
            }else{
                commonCharsFreq[i]--;
                count = count + (2*commonCharsFreq[i]);
                flag=true;
            }
        }

        return flag?count+2:count;
    }
}
