class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            String str = list1[i];
            map.put(str,i);
        }

        int minIndexSum=Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            String str = list2[i];

            if(map.containsKey(str)){
                int ind1 = map.get(str);
                if((ind1+i)<minIndexSum){
                    list.clear();
                    list.add(str);
                    minIndexSum=ind1+i;
                }else if(ind1+i==minIndexSum){
                    list.add(str);
                }
            }
        }

        String[] resultArray = new String[list.size()];
        list.toArray(resultArray);
        return resultArray;

    }
}
