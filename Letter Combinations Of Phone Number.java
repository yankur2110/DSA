class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> permutation_list = new LinkedList<String>();
        if(digits.length()<1)
            return permutation_list;
        String[] char_map = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        permutation_list.add(""); //added to keep first permutation length zero.
        
        for(int i=0;i<digits.length();i++){
/* logic is we keeps on appending all the permutations of charmap[i] to values already present in result_array whose length is i-1...&& removing permutation of length i-1 one by one*/
            
            int index = Character.getNumericValue(digits.charAt(i));
            while(permutation_list.peek().length()!=(i+1)){
                String temp = permutation_list.remove();
                for(char eachChar : char_map[index].toCharArray()){ /*to convert string into charArray so that for-each can be applied*/
                    permutation_list.add(temp+eachChar);
                }
            }
            
            
        }
        
        return permutation_list;
    }
}