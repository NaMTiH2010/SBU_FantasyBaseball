/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import WBDK.gui.DraftPageItemDialog;
import WBDK.gui.Draft_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.YesNoCancelDialog;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class DraftPageEditController {
    DraftPageItemDialog dpid;
    MessageDialog messageDialog;
    YesNoCancelDialog yesNoCancelDialog;
    Draft theDraft;
    int i;
    int j;
    String posNeeded;
    Team selectedTeam;
    Player selectedPlayer;
    
    public DraftPageEditController(Stage primaryStage, Draft draft, MessageDialog messageDialog, YesNoCancelDialog yesNoCancelDialog) {
       // sid = new PlayersItemDialog(primaryStage, draft, messageDialog);
       // ftid = new FantasyTeamsItemDialog(primaryStage, draft, messageDialog);
        dpid = new DraftPageItemDialog(primaryStage, draft, messageDialog);
        this.messageDialog = messageDialog;
        this.yesNoCancelDialog = yesNoCancelDialog;
        theDraft = draft;
    }

   
    public void handleAddPlayerSemiAutomatic(Draft_GUI gui){
                selectedTeam = selectTeam();
                selectedPlayer = grabAPlayer(selectedTeam);
                addPlayerToTeam(selectedPlayer,selectedTeam);
                theDraft.updateAvailableList();
                theDraft.findEstimatedValue();
    }
    public void handleAddPlayerAutomatic(){
        
    }
    // FIND A TEAM THAT NEEDS PLAYERS
        private Team selectTeam(){
            // NO TEAMS CREATED YET
            if(theDraft.getTeams().isEmpty()){
                messageDialog.show("You Need To Create a Team");
               return null; 
            }
            
            // IS IT TAXI SQUAD TIME?
            else if(theDraft.isItTaxiTime()){
                for(i=0;i<theDraft.getTeams().size();i++){
                    if(theDraft.getTeams().get(i).getTaxiSquad().size() < 8){
                        return theDraft.getTeams().get(i);
                    }
                }
            }
            
            // GET A TEAM NEEDING PLAYERS ON STARTING LINEUP     
            else{
                for(i=0;i<theDraft.getTeams().size();i++){
                    if(theDraft.getTeams().get(i).getNumPlayersNeeded() > 0)
                        return theDraft.getTeams().get(i);
                }
            }
            System.out.println("How did this happen (autoDraft)");
            return null;
        }
        
        private Player grabAPlayer(Team team){
            Player tempPlayer = new Player();
            tempPlayer.setEstimatedValue(0);
            posNeeded = "";
            // FIND THE TYPE OF PLAYER THE TEAM NEEDS
            if(team.getP_Needed() != 0)
                posNeeded = "P";
            else if(team.getC_Needed() != 0)
                posNeeded = "C";
            else if(team.getF_BaseNeeded() != 0)
                posNeeded = "1B";
            else if(team.getCI_Needed() != 0)
                posNeeded = "CI";
            else if(team.getT_BaseNeeded() != 0)
                posNeeded = "3B";
            else if(team.getS_BaseNeeded() != 0)
                posNeeded = "2B";
            else if(team.getMI_Needed() != 0)
                posNeeded = "MI";
            else if(team.getSS_Needed() != 0)
                posNeeded = "SS";
            else if(team.getOF_Needed() != 0)
                posNeeded = "OF";
            else if(team.getU_Needed() != 0)
                posNeeded = "U";
            else{System.out.println("Mistakes have been made (Choosing pos needed)");}
            
            System.out.println("!!!position needed = "+posNeeded);
            // SEARCH FOR THE BEST PLAYER OF THAT TYPE IN AVAILABLE PLAYERS
            for(i=0;i<theDraft.getAvailablePlayers().size();i++){
                for(j=0;j<theDraft.getAvailablePlayers().get(i).getPositions().length;j++){
                    if(theDraft.getAvailablePlayers().get(i).getPositions()[j].equalsIgnoreCase(posNeeded)){
                        if(theDraft.getAvailablePlayers().get(i).getEstValue() > tempPlayer.getEstValue()){
                            tempPlayer = theDraft.getAvailablePlayers().get(i);
                        }
                    }
                }
            }
          return tempPlayer;  
        }
        private void addPlayerToTeam(Player player, Team team){
            if(theDraft.isItTaxiTime()){
                player.setPickNum(theDraft.getDraftTablePlayers().size()+1);
                player.setFantasyTeam(team.getName());
                player.setSalary("1");
                player.setPickNum(theDraft.getDraftTablePlayers().size());
                player.setContractStatus("X");
                player.setCurrentPosition(posNeeded);
                player.setTaken(true);
                theDraft.getDraftTablePlayers().add(player);
                player.setAvailability(false);
               // player.se
                team.addStartingLineupPlayer(player);
                System.out.println("P needed = "+ team.getP_Needed());
                
            }
            else{
                player.setPickNum(theDraft.getDraftTablePlayers().size()+1);
                player.setFantasyTeam(team.getName());
                player.setSalary("1");
                player.setPickNum(theDraft.getDraftTablePlayers().size());
                player.setContractStatus("S2");
                player.setCurrentPosition(posNeeded);
                player.setTaken(true);
                theDraft.getDraftTablePlayers().add(player);
                player.setAvailability(false);
                team.addStartingLineupPlayer(player);
                System.out.println("P needed = "+ team.getP_Needed());
            }
                
        }
}
