/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import WBDK.gui.Draft_GUI;
import WBDK.gui.FantasyStandings_GUI;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.MLB_GUI;
import WBDK.gui.PlayersPage_GUI;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class Draft {
    String title;
    PlayersPage_GUI playersPage;
    Draft_GUI draftPage;
    FantasyStandings_GUI fantasyStandingsPage;
    FantasyTeams_GUI fantasyTeamsPage;
    MLB_GUI mlb_Page;
    Player player;
    ObservableList<Player> hitters;
    ObservableList<Player> pitchers;
    ObservableList<Player> players;
    
    public Draft(WBDK_DataView tempGUI,ObservableList<Player> hitterArray,ObservableList<Player> pitcherArray){
        playersPage = new PlayersPage_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        draftPage = new Draft_GUI();
        fantasyStandingsPage = new FantasyStandings_GUI();
        fantasyTeamsPage = new FantasyTeams_GUI();
        mlb_Page = new MLB_GUI();
        hitters = hitterArray;
        pitchers = pitcherArray;
        players = FXCollections.observableArrayList();
        initPlayers(players,hitters,pitchers);
    }
    
    public void removePlayer(){
        
    }
    public void addPlayer(){
        
    }
   // public ObservableList getPlayers(){
     //  return players;
    //}
    public void resetPlayers(){
        
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void loadPlayers(){
        
    }
    public ObservableList<Player> getHitters(){
        return hitters;
    }
    public ObservableList<Player> getPlayers(){
        return players;
    }

    private void initPlayers(ObservableList<Player> players,ObservableList<Player> hitters, ObservableList<Player> pitchers) {
        for(int i =0; i<hitters.size();i++){
            players.add(hitters.get(i));
        }
        for(int i =0; i<pitchers.size();i++){
                players.add(pitchers.get(i));
            }
    }
    
}
