class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        //sort the array so that we can know the max beauty we can get in that price.
        Arrays.sort(items, (a,b)-> a[0]-b[0]);

        //we will store the queries distinct values in a treemap and we will calculate max beauty we can get in that each of that price.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: queries){
            map.put(i,0);
        }
        int max=0, itemIndex=0, amountWeHave=0;
        int totalItems = items.length;

        //start populating max beauty for each query.
        for(int key : map.keySet()){
            amountWeHave =key;

            //iterate the array till the time we have more amount in query. I've called it as 'amountWeHave' as it sounds more relatable.
            while(itemIndex<totalItems && items[itemIndex][0]<=amountWeHave){
                max=Math.max(max, items[itemIndex][1]);
                itemIndex++;
            }
            //once we have found the max beauty under that price, put it into the map.
            map.put(key, max);
        }

        //now we have max beauty for each price. Start putting it in-place.
        for(int i=0;i<queries.length;i++){
            queries[i]=map.get(queries[i]);
        }

        //return the result.
        return queries;
    }
}
