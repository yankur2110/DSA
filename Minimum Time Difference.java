class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesFormat = new ArrayList<>();
        for(String time : timePoints){
            int hour = Integer.valueOf(time.substring(0,2));
            int minute = Integer.valueOf(time.substring(3));

            minutesFormat.add(hour*60 + minute);
        }

        Collections.sort(minutesFormat);

        int prev= minutesFormat.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<minutesFormat.size();i++){
            int diff = minutesFormat.get(i)-prev;
            min =Math.min(diff, min);
            prev=minutesFormat.get(i);
        }


        return Math.min(min, 1440+minutesFormat.get(0)-prev);
    }
}
