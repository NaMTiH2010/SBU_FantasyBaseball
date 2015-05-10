/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class DraftPageItemDialog {
    Draft theDraft;
    MessageDialog messageDialog;
    int i;
    int j;
    String posNeeded;

    public DraftPageItemDialog(Stage primaryStage, Draft draft, MessageDialog messageDialog) {
        theDraft = draft;
        this.messageDialog = messageDialog;
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
                player.setFantasyTeam(team.getName());
                player.setSalary("1");
                player.setPickNum(theDraft.getDraftTablePlayers().size());
                player.setContractStatus("X");
                player.setCurrentPosition(posNeeded);
                team.addStartingLineupPlayer(player);
                
            }
            else{
                player.setFantasyTeam(team.getName());
                player.setSalary("1");
                player.setPickNum(theDraft.getDraftTablePlayers().size());
                player.setContractStatus("S2");
                player.setCurrentPosition(posNeeded);
                team.addStartingLineupPlayer(player);
            }
                
        }
}
