package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UsersHistory {
    private ArrayList<GameModel> record;
    private ArrayList<GameModel> leadBoard;

    public UsersHistory() {
        record = new ArrayList<>();
        leadBoard = new ArrayList<>();
    }
    

    public ArrayList<GameModel> getRecord() {
		return record;
	}


	public void AddRecordItem( GameModel record) {
		this.record.add(record);
		
	}


	public ArrayList<GameModel> getLeadBoard() {
		return leadBoard;
	}


	public void AddLeadBoardItem(GameModel leadBoard) {
		this.leadBoard.add(leadBoard);
		
	}


	public ArrayList<GameModel> getRecords() {
        return record;
    }

    public void addScoreToRecord(GameModel puntaje) {
        this.record.add(puntaje);
        
    }

    public ArrayList<GameModel> getUserNickName() {
        return record;
    }

    public  ArrayList<GameModel> AddBestScore(GameModel score) {
    	Arrays.sort(record, Collections.reverseOrder());
                for (GameModel scores : getRecord()) {
            
               
                }
            }
        

       

        return mejoresPuntajes;
    }
}