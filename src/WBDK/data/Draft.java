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
    Team defaultTeam;
    ObservableList<String> contracts;
    ObservableList<Player> hitters;
    ObservableList<Player> pitchers;
    ObservableList<Player> players;
    ObservableList<Player> availablePlayers;
    ObservableList<Team> teams;
    ObservableList<String> proTeams;
    
    public Draft(WBDK_DataView tempGUI,ObservableList<Player> hitterArray,ObservableList<Player> pitcherArray){
        playersPage = new PlayersPage_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        draftPage = new Draft_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        fantasyStandingsPage = new FantasyStandings_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        fantasyTeamsPage = new FantasyTeams_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        mlb_Page = new MLB_GUI(tempGUI.primaryStage,tempGUI.secondaryStage);
        hitters = hitterArray;
        pitchers = pitcherArray;
        players = FXCollections.observableArrayList();
        initPlayers(players,hitters,pitchers);
        availablePlayers = FXCollections.observableArrayList();
        teams = FXCollections.observableArrayList();
        contracts = FXCollections.observableArrayList();
        contracts.add("S1");
        contracts.add("S2");
        contracts.add("X");
        defaultTeam = new Team();
        updateAvailableList();
        makeProTeamsList();
        title = "DefaultTitle";
        
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
    public String getTitle(){
        return title;
    }
    public void loadPlayers(){
        
    }
    public ObservableList<Player> getHitters(){
        return hitters;
    }
    public ObservableList<Player> getPitchers(){
        return pitchers;
    }
    public ObservableList<Team> getTeams(){
        return teams;
    }
    public ObservableList<Player> getPlayers(){
        return players;
    }

    private void initPlayers(ObservableList<Player> players,ObservableList<Player> hitters, ObservableList<Player> pitchers) {
        for(int i =0; i<hitters.size();i++){
            players.add(hitters.get(i));
            //System.out.println("Hitter: "+ players.get(i).getQP() );
        }
        for(int i =0; i<pitchers.size();i++){
                players.add(pitchers.get(i));
            }
    }
   
    public PlayersPage_GUI getPlayersPage(){
        return playersPage;
    }
    public Draft_GUI getDraftPage(){
        return draftPage;
    }
    public FantasyStandings_GUI getFantasyStandingsPage(){
        return fantasyStandingsPage;
    }
    public FantasyTeams_GUI getFantasyTeamsPage(){
        return fantasyTeamsPage;
    }
    public MLB_GUI getMLB_Page(){
        return mlb_Page;
    }
    //ObservableList
    public void radioButtonSort(String rb){
        
        int i,j;
        // RESET ALL THE PLAYERS TO AVAILABLE
        for(i =0;i<players.size();i++){
            players.get(i).setAvailability(true);
        }
        boolean test = false;
        ObservableList sorted = FXCollections.observableArrayList();
         
        if(rb.equalsIgnoreCase("All  ")){
            for(i = 0;i<players.size();i++){
                players.get(i).setAvailability(true);
            }
        }
        else if(rb.equals("P  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("hitter")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        players.get(i).setAvailability(true);
                    }
                }
        }
        else if(rb.equals("C  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("C")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                    
                }
        }
        else if(rb.equals("2B  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("2B")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else if(rb.equals("3B  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("3B")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else if(rb.equals("SS  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("SS")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else if(rb.equals("OF  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("OF")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else if(rb.equals("U  ")){
            System.out.println("rb EQUALS "+rb+"  "+rb.compareToIgnoreCase("U  "));
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    /*else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("U")){
                                System.out.println("Player EQUALS "+players.get(i).getPositions()[j]+"  "+players.get(i).getPositions()[j].compareToIgnoreCase("U"));
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }*/
                }
        }
        else if(rb.equals("MI  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("2B") || players.get(i).getPositions()[j].equals("SS")){
                                test = true;
                            }
                        }
                        if(test == true){
                            players.get(i).setAvailability(true);
                        }
                        else{
                            players.get(i).setAvailability(false);
                        }
                    }
                }
        }
        else if(rb.equalsIgnoreCase("CI  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("1B") || players.get(i).getPositions()[j].equals("3B")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else if(rb.equals("1B  ")){
                for(i = 0;i<players.size();i++){
                    if(players.get(i).getPlayerType().equalsIgnoreCase("pitcher")){
                        players.get(i).setAvailability(false);
                    }
                    else{
                        
                        test = false;
                        for(j=0;j<players.get(i).getPositions().length;j++){
                            if(players.get(i).getPositions()[j].equals("1B")){
                                test = true;
                            }
                        }
                        if(test == true)
                            players.get(i).setAvailability(true);
                        else
                            players.get(i).setAvailability(false);
                    }
                }
        }
        else{
            //for(i = 0;i<players.size();i++){
              //  players.get(i).setAvailability(false);
            //}
            System.out.println("NOT SUPPOSE TO HAPPEN AVAIL PLAYERS");
        }
        
        //return sorted;
        updateAvailableList();
    }
    public void updateAvailableList(){
        availablePlayers.clear();
        for(int i = 0; i < players.size();i++){
            if(players.get(i).getAvailability()==true && players.get(i).getTaken()== false)
            availablePlayers.add(players.get(i));
        }
    }
    public ObservableList<Player> getAvailablePlayers(){
        //System.out.println(" the players array is size: "+players.size()+ " the available array is size "+ availablePlayers.size());
        return availablePlayers;
    }

    public void searchIT(String newValue) {
        boolean testFirst = false;
        boolean testLast = false;
        
        for(int i = 0; i < availablePlayers.size();i++){
            
            ///// newValue is too Long for first and last
            if(newValue.length()>availablePlayers.get(i).getFirstName().length() &&
                    newValue.length()>availablePlayers.get(i).getLastName().length()){
                availablePlayers.get(i).setAvailability(false);
            }
            // new value is too long for first name
            else if(newValue.length()>availablePlayers.get(i).getFirstName().length()){
                for(int j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getLastName().charAt(j))){
                        availablePlayers.get(i).setAvailability(false);
                        break;
                    }                
                }
            }
            // newvalue is too long for last name
            else if(newValue.length()>availablePlayers.get(i).getLastName().length()){
                for(int j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getFirstName().charAt(j))){
                    availablePlayers.get(i).setAvailability(false);
                    break;
                    }                
                }
            }
            // newvalue is not too long for either
            else{
                for(int j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getLastName().charAt(j))){
                        testFirst = false;
                        break;
                    }
                }
                for(int j = 0; j < newValue.length();j++){
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getFirstName().charAt(j))){
                        testLast = false;
                        break;
                    }
                }
                    if(testFirst==false || testLast==false){
                        availablePlayers.get(i).setAvailability(false);
                    }
                
                
                }
             
        }
        updateAvailableList();
    }
    public void setPlayers(ObservableList<Player> players){
        this.players = players;
    }
    public void setTeams(ObservableList<Team> teams){
        this.teams = teams;
    }
    public void setAvailablePlayers(ObservableList<Player> availablePlayers){
        this.availablePlayers = availablePlayers;
    }
    public void setDefaultTeam(Team defaultTeam){
        this.defaultTeam = defaultTeam;
    }
    public Team getDefaultTeam(){
        return defaultTeam;
    }

    private void makeProTeamsList() {
        proTeams = FXCollections.observableArrayList();
        proTeams.add(players.get(0).getTeam());
        boolean alreadyHave;
            for(int i =1; i < players.size();i++){
                alreadyHave = false;
                for(int j =0; j < proTeams.size();j++){
                    if(players.get(i).getTeam().equalsIgnoreCase(proTeams.get(j))){
                        alreadyHave = true;
                        break;
                    }
                }
                if(alreadyHave == false)
                        proTeams.add(players.get(i).getTeam());
            }
        
        System.out.println("Players size = "+ players.size()+" Pro Teams size = "+proTeams.size());
    }
    public ObservableList<String> getProTeams(){
        return proTeams;
    }
    public ObservableList<String> getContracts(){
        return contracts;
    }
    /*
    public void calculatePlayerValues() {
        for(int i=0; i<players.size();i++){
            players.get(i).calculateValues();
        }
    }*/
    public boolean isItTaxiTime(){
        for(int i=0;i<teams.size();i++){
            if(teams.get(i).getTaxiTime() == false){
                return false;
            }
        }
        return true;
    }
}
