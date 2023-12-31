package Models;


import java.io.*;
import java.util.*;

import Models.GameModel;

/**
 * La clase UsersHistory representa el historial de los juegos de los usuarios.
 */
public class UsersHistory {
    private ArrayList<GameModel> records;

    /**
     * Constructor de UsersHistory.
     * Inicializa un nuevo historial de usuarios cargando los datos existentes.
     */
    public UsersHistory() {
    	this.records = loadData();
    }
    
    /**
     * Guarda un nuevo registro de juego en el historial.
     *
     * @param game El modelo de juego a guardar.
     */
    public void saveNewRecord(GameModel game) {    	
    	Map<String, String> data = new HashMap<>();
        data.put("gameId", game.getGameId());
        data.put("totalScore", Integer.toString(game.getTotalScore()));
        data.put("totalMovements", Integer.toString(game.getTotalMovements()));
        data.put("totalFruits", Integer.toString(game.getTotalFruits()));
        data.put("maxLevel", Integer.toString(game.getMaxLevel()));
        data.put("snakeSkin", game.getSnakeSkin());
        data.put("userNickName", game.getUserNickName());    	
    	
        File file = new File("game-records.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating file: " + e);
            }
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            out.println(data.toString());
        } catch (IOException e) {
            System.err.println(e);
        }
        
        records = this.loadData();
    }
    
    /**
     * Carga los datos del historial de usuarios desde el archivo de registros del juego.
     *
     * @return Una lista de modelos de juego que representan los registros del juego.
     */
    public ArrayList<GameModel> loadData() {
        ArrayList<GameModel> newRecord = new ArrayList<>();
        
        File file = new File("game-records.txt");
        if (file.length() == 0) {
            System.out.println("the file has no game records");
            return newRecord;
        }
        
        try (BufferedReader in = new BufferedReader(new FileReader("game-records.txt"))) {
            String line;
            
            while ((line = in.readLine()) != null) {
                String[] data = line.substring(1, line.length() - 1).split(", ");
                
                Map<String, String> map = new HashMap<>();
                
                for (String pair : data) {
                    if (pair.contains("=")) {
                        String[] keyValue = pair.split("=");
                        map.put(keyValue[0], keyValue[1]);
                    } else {
                        System.out.println("Not Valid Format: " + pair);
                    }
                }
                GameModel game = new GameModel();
                game.setGameId(map.get("gameId"));
                game.setTotalScore(Integer.parseInt(map.get("totalScore")));
                game.setTotalMovements(Integer.parseInt(map.get("totalMovements")));
                game.setTotalFruits(Integer.parseInt(map.get("totalFruits")));
                game.setMaxLevel(Integer.parseInt(map.get("maxLevel")));
                game.setSnakeSkin(map.get("snakeSkin"));
                game.setUserNickName(map.get("userNickName"));
                newRecord.add(game);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return newRecord;
    }    
    
    /**
     * Lee e imprime los registros del historial de usuarios.
     */
    public void readRecords() {
    	for (GameModel juego : records) {
    	    System.out.println("\nGame id: " + juego.getGameId());
    	    System.out.println("Nickname: " + juego.getUserNickName());
    	    System.out.println("Total Score: " + juego.getTotalScore());
    	    System.out.println("Total Movements: " + juego.getTotalMovements());
    	    System.out.println("Total Fruits: " + juego.getTotalFruits());
    	    System.out.println("Max Level: " + juego.getMaxLevel());
    	    System.out.println("Snake Skin: " + juego.getSnakeSkin());
    	}
    }

    /**
     * Obtiene los registros del historial de usuarios.
     *
     * @return Una lista de modelos de juego que representan los registros del juego.
     */
    public ArrayList<GameModel> getRecord() {
		return records;
	}
}