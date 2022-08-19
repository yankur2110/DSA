class Solution {
    public int[] decode(int[] encoded) {
        int totalXor=0;
        int n=encoded.length+1;

        for(int i=1;i<=n;i++){
            totalXor = totalXor^i;
        }

        int xorExceptFirst=0;
        for(int i=1;i<encoded.length;i+=2){
            xorExceptFirst = xorExceptFirst^encoded[i];
        }

        int[] result = new int[n];
        result[0]=totalXor^xorExceptFirst;

        for(int i=1;i<n;i++){
            result[i]=result[i-1]^encoded[i-1];
        }

        return result;
    }
}
