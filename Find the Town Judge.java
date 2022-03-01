class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1; //handling the corner case.

        HashMap<Integer, List<Integer>> ATrustedByB = new HashMap<>(); //list of people who trust a person.
        HashSet<Integer> hashSet = new HashSet<>(); //list of person who trust someone.

        for(int i=0;i<trust.length;i++){ //populating the map.

            if(ATrustedByB.containsKey(trust[i][1])){
                ATrustedByB.get(trust[i][1]).add(trust[i][0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(trust[i][0]);
                ATrustedByB.put(trust[i][1],list);
            }

            hashSet.add(trust[i][0]);
        }

        for(int i=1;i<=n;i++){ //iterate from 1 -> n, check if the person is trusted by n-1 people and the person doesn't trust anybody.
            if(!hashSet.contains(i)){
                if(ATrustedByB.containsKey(i) && ATrustedByB.get(i).size()==(n-1))
                    return i;
            }
        }

        return -1;

    }
}
