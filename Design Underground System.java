class UndergroundSystem {

    HashMap<Integer, Pair<String, Integer>> checkInMap; //check-in details of user... UserId: {source, leaveTime}.
    HashMap<String, Pair<Integer, Integer>> routeDetailsTillNowMap; //route details.. RoutName: {totalTime, totatCount}.

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeDetailsTillNowMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String dest, int t) {
        Pair<String,Integer> checkInDetailsOfUser = checkInMap.get(id);
        String source = checkInDetailsOfUser.getKey();
        int timeForJourney = t-checkInDetailsOfUser.getValue();

        checkInMap.remove(id); //we don't need it now. It's redundant hence remove.

        String route = source+"_"+dest;
        Pair<Integer, Integer> existing_details = routeDetailsTillNowMap.getOrDefault(route, new Pair(0,0));

        routeDetailsTillNowMap.put(route, new Pair(existing_details.getKey()+timeForJourney, existing_details.getValue()+1));

    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> routeDetails = routeDetailsTillNowMap.get(startStation+"_"+endStation);

        return (double) routeDetails.getKey()/routeDetails.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
