class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); //sort people on basis of weight so that two pointer can be applied.
        int start=0, end=people.length-1, count=0;

        while(start<=end){
            //if boat can carry lightest and the heaviest, fine.. let them sit.
            if(people[start]+people[end]<=limit){
                start++;end--;
            }else{ //otherwise let the heaviest person sit.
                end--;
            }
            count++; //increment the boat count.
        }
        return count;
    }
}
