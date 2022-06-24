class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //main logic is we have to give priority to place the heigher height people first.
        //then placing the smaller height people doesn't matter.
        //also if height's are same, we have to maintain the priority because first one's height is considered by the other.

        //custom sort: first sort on basis of height in descending order, if equal sort on basis of people in front of that person in queue (ascending order).
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                else
                    return b[0]-a[0];
            }
        });

        List<int[]> resultList = new ArrayList<>();
        //iterate through the array, place at their desired K index. If later smaller element with same K value comes, it doesn't matter. It will take that place and rest elements would be shifted to right.
        for(int[] person: people){
            resultList.add(person[1],person);
        }

        //convet list to array.
        return resultList.toArray(new int[people.length][]);

    }
}
