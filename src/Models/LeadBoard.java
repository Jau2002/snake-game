package Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LeadBoard {
    private ArrayList<GameModel> users;
    private ArrayList<GameModel> bestScores;
    

    public LeadBoard() {
        users = new ArrayList<>();
        bestScores = new ArrayList<>();
    }

    public void AddScore(GameModel Scores) {
        int Score = GameModel;

       
        for (int i = 0; i < bestScores.size(); i++) {
            if (Score > TotalScore.get(i)) {
            
                bestScores.add(i, Score);
                users.add(i, user);

              
                if (bestScores.size() > 5) {
                    bestScores.remove(5);
                    users.remove(5);
                }

                return;  
            }
        }

       
        if (bestScores.size() < 5) {
            bestScores.add(Score);
            users.add(user);
        }
    }

    public ArrayList<GameModel> getUserNickName() {
        return users;
    }

    public ArrayList<Integer> getBestScores() {
        return bestScores;
    }
    public void CrearArchivoBestScores(String BestPlayers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BestPlayers))) {
            
            for (int i = 0; i < users.size(); i++) {
                GameModel user = users.get(i);
                int bestScore = bestScores.get(i);

              
                String linea = "Nickname: " + user.getUserNickName() + ", BestScore: " + bestScore;

              
                writer.write(linea);
                writer.newLine();  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 

}
