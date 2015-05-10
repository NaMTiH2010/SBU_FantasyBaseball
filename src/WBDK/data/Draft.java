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
    int i;
    int j;
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
    ObservableList<Player> draftTablePlayers;
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
        
        availablePlayers = FXCollections.observableArrayList();
        draftTablePlayers = FXCollections.observableArrayList();
        teams = FXCollections.observableArrayList();
        contracts = FXCollections.observableArrayList();
        contracts.add("S1");
        contracts.add("S2");
        contracts.add("X");
        defaultTeam = new Team();
       
        title = "DefaultTitle";
        
        for(i=0;i<pitchers.size();i++){
                pitchers.get(i).setRank_w(i+1);
                pitchers.get(i).setRank_sv(i+1);
                pitchers.get(i).setRank_k(i+1);
                pitchers.get(i).setRank_era(i+1);
                pitchers.get(i).setRank_whip(i+1);
                pitchers.get(i).setFinalRank(i+1);
        }
        for(i=0;i<hitters.size();i++){
                hitters.get(i).setRank_r(i+1);
                hitters.get(i).setRank_hr(i+1);
                hitters.get(i).setRank_rbi(i+1);
                hitters.get(i).setRank_sb(i+1);
                hitters.get(i).setRank_ba(i+1);
                hitters.get(i).setFinalRank(i+1);
        }
        rankPlayers();
        initPlayers(players,hitters,pitchers);
        //findEstimatedValue();
        updateAvailableList();
        makeProTeamsList();
        System.out.println("Final Rank of Player 0 "+ players.get(0).getFinalRank());
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
        for( i =0; i<hitters.size();i++){
            players.add(hitters.get(i));
            //System.out.println("Hitter: "+ players.get(i).getQP() );
        }
        for(i =0; i<pitchers.size();i++){
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
        for( i = 0; i < players.size();i++){
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
        
        for( i = 0; i < availablePlayers.size();i++){
            
            ///// newValue is too Long for first and last
            if(newValue.length()>availablePlayers.get(i).getFirstName().length() &&
                    newValue.length()>availablePlayers.get(i).getLastName().length()){
                availablePlayers.get(i).setAvailability(false);
            }
            // new value is too long for first name
            else if(newValue.length()>availablePlayers.get(i).getFirstName().length()){
                for( j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getLastName().charAt(j))){
                        availablePlayers.get(i).setAvailability(false);
                        break;
                    }                
                }
            }
            // newvalue is too long for last name
            else if(newValue.length()>availablePlayers.get(i).getLastName().length()){
                for( j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getFirstName().charAt(j))){
                    availablePlayers.get(i).setAvailability(false);
                    break;
                    }                
                }
            }
            // newvalue is not too long for either
            else{
                for( j = 0; j < newValue.length();j++){
                
                    if(!(newValue.charAt(j)==availablePlayers.get(i).getLastName().charAt(j))){
                        testFirst = false;
                        break;
                    }
                }
                for( j = 0; j < newValue.length();j++){
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
            for( i =1; i < players.size();i++){
                alreadyHave = false;
                for( j =0; j < proTeams.size();j++){
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
        for( i=0; i<players.size();i++){
            players.get(i).calculateValues();
        }
    }*/
    public boolean isItTaxiTime(){
        for( i=0;i<teams.size();i++){
            if(teams.get(i).getTaxiTime() == false){
                return false;
            }
        }
        return true;
    }
    private void rankPlayers(){
        double tempDoubleI =0;
        double tempDoubleJ = 0; 
        boolean changed;
        int tempRank = 0;
        double rankingsI = 0;
        double rankingsJ = 0;
        
        boolean finishedPitchersPart1 = false;
        boolean finishedHittersPart1 = false;
        
        boolean finishedPitchersPart2 = false;
        boolean finishedHittersPart2 = false;
        
        boolean pitBool = false;
       
        
        boolean hitBool = false;
       
        
        /////////////////////////////////////////////// PART 1 ///////////////////////////////////////////////////////////
        while(pitBool == false){
            changed = false;
           // System.out.println("Changed refresh");
            for(i =0; i < pitchers.size()-1;i++){
                for(j=0; j < pitchers.size();j++){
            //PITCHER W
                    if((pitchers.get(i).getR_W() < pitchers.get(j).getR_W()) && (pitchers.get(i).getRank_w() < pitchers.get(j).getRank_w())){
             
                    tempRank = pitchers.get(i).getRank_w();
                    pitchers.get(i).setRank_w(pitchers.get(j).getRank_w());
                    pitchers.get(j).setRank_w(tempRank);
                    changed = true;
                }
            }}
            if(changed == false)
            pitBool = true;
        }
        pitBool = false;
        System.out.println("Got out of Pitbool 1");
        
        while(pitBool == false){
            changed = false;
            //System.out.println("Changed refresh");
        for(i =0;i<pitchers.size();i++){
            for(j=0;j<pitchers.size();j++){
            //PITCHER SV
            if((pitchers.get(i).getHR_SV() < pitchers.get(j).getHR_SV()) && (pitchers.get(i).getRank_sv() < pitchers.get(j).getRank_sv())){
                    /*
                    System.out.println("loop 1 RW rank for I = "+pitchers.get(i).getHR_SV() );
                    System.out.println("loop 1 RW rank for J = "+pitchers.get(j).getHR_SV() );
                    System.out.println("Init loop 1 W rank for I = "+pitchers.get(i).getRank_sv());
                    System.out.println("Init loop 1 W rank for J = "+pitchers.get(j).getRank_sv());
                    */
                    tempRank = pitchers.get(i).getRank_sv();
                    pitchers.get(i).setRank_sv(pitchers.get(j).getRank_sv());
                    pitchers.get(j).setRank_sv(tempRank);
                    changed = true;
                   // System.out.println("Changed  = true loop j = "+ j+" I  = "+ i);
                    /*
                    System.out.println("after loop 1 W rank for I = "+pitchers.get(i).getRank_sv());
                    System.out.println("after loop 1 W rank for J = "+pitchers.get(j).getRank_sv());
                   */
                }}}
        if(changed == false)
            pitBool = true;
        }
        pitBool = false;
        System.out.println("Got out of Pitbool 2");
        
        while(pitBool == false){
            changed = false;
            //System.out.println("Changed refresh");
            for(i =0;i<pitchers.size();i++){
                for(j=0;j<pitchers.size();j++){
            //PITCHER K
                    if((pitchers.get(i).getRBI_K() <pitchers.get(j).getRBI_K()) && (pitchers.get(i).getRank_k() < pitchers.get(j).getRank_k()) ){
                    tempRank = pitchers.get(i).getRank_k();
                    pitchers.get(i).setRank_k (pitchers.get(j).getRank_k());
                    pitchers.get(j).setRank_k(tempRank);
                    changed = true;
                    //System.out.println("Changed  = true loop j = "+ j+" I  = "+ i);
                }}}
            if(changed == false)
                pitBool = true;
        }
        pitBool = false;
        System.out.println("Got out of Pitbool 3");
        while(pitBool == false){
            changed = false;
            System.out.println("Changed refresh");
            for(i =0;i<pitchers.size();i++){
                for(j=0;j<pitchers.size();j++){
            //PITCHER ERA
                    tempDoubleI = Double.parseDouble(pitchers.get(i).getSB_ERA());
                    tempDoubleJ = Double.parseDouble(pitchers.get(j).getSB_ERA());
                    if((tempDoubleI< tempDoubleJ) && (pitchers.get(i).getRank_era() < pitchers.get(j).getRank_era())){
                        tempRank = pitchers.get(i).getRank_era();
                        pitchers.get(i).setRank_era (pitchers.get(j).getRank_era());
                        pitchers.get(j).setRank_era(tempRank);
                            changed = true;
                    //System.out.println("Changed  = true loop j = "+ j+" I  = "+ i);
                }}}
            if(changed == false)
                pitBool = true;
        }
        pitBool = false;
        System.out.println("Got out of Pitbool 4");
        
            while(pitBool == false){
                changed = false;
                //System.out.println("Changed refresh");
                for(i =0;i<pitchers.size();i++){
                    for(j=0;j<pitchers.size();j++){
                //PITCHER WHIP
                        if((pitchers.get(i).getBA_WHIP() < pitchers.get(j).getBA_WHIP()) && (pitchers.get(i).getRank_whip() < pitchers.get(j).getRank_whip()) ){
                            tempRank = pitchers.get(i).getRank_whip();
                            pitchers.get(i).setRank_whip (pitchers.get(j).getRank_whip());
                            pitchers.get(j).setRank_whip(tempRank);
                            changed = true;
                    //System.out.println("Changed  = true loop j = "+ j+" I  = "+ i);
                        }
                    } 
            //System.out.println("Finished J Loop");
                }
            //System.out.println("Finished I Loop changed = "+changed);
                if(changed == false)
                    pitBool = true;
        }
        System.out.println("Finished Pitchers Part 1");
        
        // HITTERS PART !
        while(hitBool == false){
            changed = false;
        for(i =0;i<hitters.size();i++){
            for(j=0;j<hitters.size();j++){
            //HITTER R
                if((hitters.get(i).getR_W()< hitters.get(j).getR_W()) && (hitters.get(i).getRank_r() < hitters.get(j).getRank_r())){
                    tempRank = hitters.get(i).getRank_r();
                    hitters.get(i).setRank_r(hitters.get(j).getRank_r());
                    hitters.get(j).setRank_r(tempRank);
                    changed = true;
                }
            }
        }
        if(changed == false)
                hitBool = true;
        }
        hitBool = false;
        while(hitBool == false){
            changed = false;
            for(i =0;i<hitters.size();i++){
                for(j=0;j<hitters.size();j++){
            //HITTER HR
            if((hitters.get(i).getHR_SV()< hitters.get(j).getHR_SV()) && (hitters.get(i).getRank_hr() < hitters.get(j).getRank_hr())){
                    tempRank = hitters.get(i).getRank_hr();
                    hitters.get(i).setRank_hr(hitters.get(j).getRank_hr());
                    hitters.get(j).setRank_hr(tempRank);
                    changed = true;
                }
                }
            }
            if(changed == false)
                hitBool = true;
        }
        hitBool = false;
        while(hitBool == false){
            changed = false;
            for(i =0;i<hitters.size();i++){
                for(j=0;j<hitters.size();j++){
            //HITTER RBI
            if((hitters.get(i).getRBI_K() < hitters.get(j).getRBI_K()) && (hitters.get(i).getRank_rbi() < hitters.get(j).getRank_rbi()) ){
                    tempRank = hitters.get(i).getRank_rbi();
                    hitters.get(i).setRank_rbi (hitters.get(j).getRank_rbi());
                    hitters.get(j).setRank_rbi(tempRank);
                    changed = true;
                }
                }
            }
            if(changed == false)
                hitBool = true;
        }
        hitBool = false;
        while(hitBool == false){
            changed = false;
            for(i =0;i<hitters.size();i++){
                for(j=0;j<hitters.size();j++){
            //HITTER SB
            tempDoubleI = Double.parseDouble(hitters.get(i).getSB_ERA());
            tempDoubleJ = Double.parseDouble(hitters.get(j).getSB_ERA());

            if((tempDoubleI < tempDoubleJ ) && (hitters.get(i).getRank_sb() < hitters.get(j).getRank_sb())){
                    tempRank = hitters.get(i).getRank_sb();
                    hitters.get(i).setRank_sb (hitters.get(j).getRank_sb());
                    hitters.get(j).setRank_sb(tempRank);
                    changed = true;
                }
                }
            }
            if(changed == false)
                hitBool = true;
        }
        hitBool = false;
        while(hitBool == false){
            changed = false;
            for(i =0;i<hitters.size();i++){
                for(j=0;j<hitters.size();j++){
            //HITTER BA
            if((hitters.get(i).getBA_WHIP() <hitters.get(j).getBA_WHIP()) && (hitters.get(i).getRank_ba() < hitters.get(j).getRank_ba()) ){
                    tempRank = hitters.get(i).getRank_ba();
                    hitters.get(i).setRank_ba (hitters.get(j).getRank_ba());
                    hitters.get(j).setRank_ba(tempRank);
                    changed = true;
                }
            }
            }
            if(changed == false)
                hitBool = true;
        }
        System.out.println("Finished Part 1");
        /////////////////////////////////////////////// PART 2 ///////////////////////////////////////////////////////////
        
        // PART 2 PITCHERS
        while(finishedPitchersPart2 == false){
            changed = false;
            for(i =0;i<pitchers.size();i++){
                for(j=0;j<pitchers.size();j++){
                    rankingsI = ((double)(pitchers.get(i).getRank_w() + pitchers.get(i).getRank_sv() + pitchers.get(i).getRank_k()
                            + pitchers.get(i).getRank_era() + pitchers.get(i).getRank_whip()) / 5.0);
                    rankingsJ = ((double)(pitchers.get(j).getRank_w() + pitchers.get(j).getRank_sv() + pitchers.get(j).getRank_k()
                            + pitchers.get(j).getRank_era() + pitchers.get(j).getRank_whip()) / 5.0);
                    
                    if((rankingsI > rankingsJ) && (pitchers.get(i).getFinalRank() < pitchers.get(j).getFinalRank())){
                        tempRank = pitchers.get(i).getFinalRank();
                        pitchers.get(i).setFinalRank(pitchers.get(j).getFinalRank());
                        pitchers.get(j).setFinalRank(tempRank);
                        changed = true;
                    }
                }
            }
            if(changed == false)
                finishedPitchersPart2 = true;
        }
        // PART 2 HITTERS
        while(finishedHittersPart2 == false){
            changed = false;
            for(i =0;i<hitters.size();i++){
                for(j=0;j<hitters.size();j++){
                    rankingsI = ((double)(hitters.get(i).getRank_r() + hitters.get(i).getRank_hr() + hitters.get(i).getRank_rbi()
                            + hitters.get(i).getRank_sb() + hitters.get(i).getRank_ba()) / 5.0);
                    rankingsJ = ((double)(hitters.get(j).getRank_r() + hitters.get(j).getRank_hr() + hitters.get(j).getRank_rbi()
                            + hitters.get(j).getRank_sb() + hitters.get(j).getRank_ba()) / 5.0);
                            
                    if((rankingsI > rankingsJ) && (hitters.get(i).getFinalRank() < hitters.get(j).getFinalRank())){
                        tempRank = hitters.get(i).getFinalRank();
                        hitters.get(i).setFinalRank(hitters.get(j).getFinalRank());
                        hitters.get(j).setFinalRank(tempRank);
                        changed = true;
                    }
                }
            }
            if(changed == false)
                finishedHittersPart2 = true;
        }
    }
    public void findEstimatedValue(){
        //  GET TOTAL MONEY REMAINING
        double allMoney = 0;
        double totalPitchersNeeded = 0;
        double totalHittersNeeded = 0;
        double medianHitterSalary = 0;
        double medianPitcherSalary = 0;
        double estimatedValue = 0;
        
        for(i=0;i<teams.size();i++){
            allMoney += teams.get(i).getMoneyLeft();
            totalPitchersNeeded += teams.get(i).getP_Needed();
            totalHittersNeeded += teams.get(i).getHittersNeeded();
        }
        // GET TOTAL PITCHERS NEEDED
        // GET TOTAL HITTERS NEEDED
        // GET MEDIAN SALARY (total $ remaining)/(2 * X) 
            medianHitterSalary = (allMoney / (2*totalHittersNeeded));
            medianPitcherSalary = (allMoney / (2* totalPitchersNeeded));
        // CALCULATE EACH PLAYERS ESTIMATED VALUE //median hitter (or pithcher) salary * (X * 2/player rank)
            for(j=0;j<players.size();j++){
                if(players.get(j).getPlayerType().equalsIgnoreCase("pitcher")){
                    /*System.out.println("pitcherSalary = "+ medianPitcherSalary+"\n"
                            + " pitchersNeeded = "+ totalPitchersNeeded+"\n"
                            + "playerRank = "+ players.get(j).getFinalRank());*/
                    estimatedValue = (medianPitcherSalary * (totalPitchersNeeded * 2 / (players.get(j).getFinalRank())));
                    String fixing = String.format("%.2f", estimatedValue);
                    Double fixed = Double.parseDouble(fixing);
                    players.get(j).setEstimatedValue(fixed);
                }
                else{
                    if(players.get(j).getPlayerType().equalsIgnoreCase("hitter")){
                    estimatedValue = (medianHitterSalary * (totalHittersNeeded * 2 / (players.get(j).getFinalRank())));
                    String fixing = String.format("%.2f", estimatedValue);
                    Double fixed = Double.parseDouble(fixing);
                    players.get(j).setEstimatedValue(fixed);
                }
                }
            }
    }

    public ObservableList<Player> getDraftTablePlayers() {
        return draftTablePlayers;
    }
            
            
            
            
     
}
