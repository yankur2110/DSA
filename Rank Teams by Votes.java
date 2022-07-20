class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> countOfRatingsForEachRankForATeam = new HashMap<>();
        int totalTeams = votes[0].length();

        for(String vote: votes){
            //ith rank voted by a voter.
            //so, in map.. we will increment the number of votes for that rank for the team.
            for(int i=0;i<totalTeams;i++){
                char ithTeamByUser = vote.charAt(i);
                countOfRatingsForEachRankForATeam.putIfAbsent(ithTeamByUser, new int[totalTeams]);
                countOfRatingsForEachRankForATeam.get(ithTeamByUser)[i]++;
            }
        }

        //now do the sorting with comparator.
        List<Character> listOfTeams  = new ArrayList<>(countOfRatingsForEachRankForATeam.keySet());

        Collections.sort(listOfTeams, (a,b) -> {
            for(int i = 0; i < totalTeams; i++){
              if(countOfRatingsForEachRankForATeam.get(a)[i] != countOfRatingsForEachRankForATeam.get(b)[i]){
                return countOfRatingsForEachRankForATeam.get(b)[i] - countOfRatingsForEachRankForATeam.get(a)[i];
              }
            }
            return a - b;
          });

     //append the teams to result.
      StringBuilder sb = new StringBuilder();
      for(char c : listOfTeams){
        sb.append(c);
      }
      return sb.toString();

    }
}
