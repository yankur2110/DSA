class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set firstOccurence = new HashSet(), secondOccurence = new HashSet();

        for (int i = 0; i + 9 < s.length(); i++) {
            String tenCharString = s.substring(i, i + 10); //check the 10character string starting from current index.
            if (!firstOccurence.add(tenCharString)) //hashset.add returns false if it is not present in the hashset.
                secondOccurence.add(tenCharString);
        }
        return new ArrayList(secondOccurence); //convert set to arraylist.
    }
}
