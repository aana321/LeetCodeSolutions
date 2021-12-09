import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public int HOME_TEAM_WON = 1;
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions,ArrayList<Integer> results){
        String currentBestTeam = "";
        Map<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);
        for(int i=0; i<competitions.size(); i++){
            ArrayList<String> competition = competitions.get(i);
            int result = results.get(i);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;

            updateScores(winningTeam, 3, scores);

            if(scores.get(winningTeam) > scores.get(currentBestTeam)){
                currentBestTeam = winningTeam;
            }

        }

        return currentBestTeam;


    }

    private void updateScores(String team, int points, Map<String, Integer> scores) {
        if(!scores.containsKey(team)){
            scores.put(team, 0);
        }else{
            scores.put(team, scores.get(team) + points);
        }

    }


}
