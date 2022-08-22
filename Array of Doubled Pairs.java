class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)==0) continue;

            int val = map.get(key);

            int want = (key>0)?2*key:key/2;

            if(key<0 && key%2!=0 || !map.containsKey(want) || map.get(want)<val){
                return false;
            }else{
                map.put(want, map.get(want)-map.get(key));
            }
        }

        return true;
    }
}
