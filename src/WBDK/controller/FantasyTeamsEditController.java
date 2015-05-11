/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import WBDK.data.WBDK_DataManager;
import WBDK.gui.FantasyTeamsItemDialog;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.YesNoCancelDialog;
import java.io.IOException;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class FantasyTeamsEditController {    
   // PlayersItemDialog sid;
    FantasyTeamsItemDialog ftid;
    MessageDialog messageDialog;
    YesNoCancelDialog yesNoCancelDialog;
    PropertiesManager properties;
    int i;
    int j;

    public FantasyTeamsEditController(Stage primaryStage, Draft draft, MessageDialog messageDialog, YesNoCancelDialog yesNoCancelDialog) {
        //sid = new PlayersItemDialog(primaryStage, draft, messageDialog);
        ftid = new FantasyTeamsItemDialog(primaryStage, draft, messageDialog);
        this.messageDialog = messageDialog;
        this.yesNoCancelDialog = yesNoCancelDialog;
    }

    
     public void handleAddTeamRequest(FantasyTeams_GUI gui) {
       WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        ftid.showAddTeamDialog();
        
        // DID THE USER CONFIRM?
        if (ftid.wasCompleteSelected()) {
            // GET THE LECTURE ITEM
            Team ti = ftid.getFakeTeam();
            
            // AND ADD IT AS A ROW TO THE TABLE
            draft.getTeams().add(ti);
            //System.out.println(draft.getTeams().get(0).getName());
            gui.flipRemoveButton(false);
            gui.flipEditButton(false);
            draft.findEstimatedValue();
        }
        else {
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }
    }
     public void handleEditTeamRequest(FantasyTeams_GUI gui) throws IOException {
       WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        ftid.showEditTeamDialog();
        
        // DID THE USER CONFIRM?
        if (ftid.wasCompleteSelected()) {
            // GET THE LECTURE ITEM
            //Team ti = ftid.getFakeTeam();
            gui.getSelectedTeam().setName(ftid.getNewTeamName());
            gui.getSelectedTeam().setOwner(ftid.getnewOwnerName());
            gui.getDataManager().reset(gui);
        }
        else {
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }
    }
      public void handleEditTeamPlayerItemRequest(FantasyTeams_GUI gui, Player itemToEdit,Team originalTeam) {
     WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        //Player si = new Player();
        String origContract = itemToEdit.getContractStatus();
        String origTeam = itemToEdit.getFantasyTeam();
        Player si = ftid.showEditTeamPlayerItemDialog(itemToEdit);
        
        // DID THE USER CONFIRM?
        if ( ftid.wasCompleteSelected()) {
            
            String playersNewFantasyTeam = si.getFantasyTeam();
            
            // IF THE PLAYER IS NOW BACK IN THE FREE AGENT POOL
            if(playersNewFantasyTeam.equalsIgnoreCase("free agent")){
                System.out.println("case 1 free agent "+ originalTeam.getName());
                // PUT HIM BACK INTO THE FREE AGENT POOL
                for( j = 0; j< draft.getPlayers().size();j++){
                    if(draft.getPlayers().get(j).getFirstName().equalsIgnoreCase(si.getFirstName())
                            && draft.getPlayers().get(j).getLastName().equalsIgnoreCase(si.getLastName()))
                        
                        draft.getPlayers().get(j).setAvailability(true);
                        draft.getPlayers().get(j).setTaken(false);
                }
                // DELETE HIM OFF THE STARTING LINEUP
                for( i=0;i<originalTeam.getStartingLineup().size();i++){
                        if(originalTeam.getStartingLineup().get(i).getFirstName().equalsIgnoreCase(si.getFirstName())){
                            System.out.println("found him");
                            originalTeam.getStartingLineup().remove(i);
                        }
                }
                // DELETE HIM FROM DRAFT TABLE
                for(j=0;j<draft.getDraftTablePlayers().size();j++){
                    if(draft.getDraftTablePlayers().get(j).getFirstName().equalsIgnoreCase(si.getFirstName())
                            && draft.getPlayers().get(j).getLastName().equalsIgnoreCase(si.getLastName())){
                        draft.getDraftTablePlayers().remove(j);
                    }
                }
                
            }
            
            // IF THE PLAYER DID NOT SWITCH TEAMS OR GO TO FREE AGENTS
        else if(playersNewFantasyTeam.equalsIgnoreCase(origTeam)){System.out.println("case 2 same team");}
        
        // IF THE PLAYER SWITCHED TEAMS
        else{
            for( i=0;i<originalTeam.getStartingLineup().size();i++){
                        if(originalTeam.getStartingLineup().get(i).getFirstName().equalsIgnoreCase(si.getFirstName())){
                            System.out.println("found him");
                            originalTeam.getStartingLineup().remove(i);
                        }
        }
        ftid.getFakeTeam().addStartingLineupPlayer(si);
        for( i =0;i<draft.getDraftTablePlayers().size();i++){
            if(si.getFirstName().equalsIgnoreCase(draft.getDraftTablePlayers().get(i).getFirstName()) &&
                    si.getLastName().equalsIgnoreCase(draft.getDraftTablePlayers().get(i).getLastName())){
                draft.getDraftTablePlayers().get(i).setFantasyTeam(si.getFantasyTeam());
            }
                
        }
        }            //System.out.println("What is this teams name: "+ftid.getFakeTeam().getName() +"the fantasy team is "+ playersNewFantasyTeam);
        }
        else {
            System.out.println("THIS SHOULDNT BE HAPPENING");
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }
        // CONTRACT STATUS DID NOT CHANGE
        if(origContract.equalsIgnoreCase(itemToEdit.getContractStatus())){}
        // CONTRACT STATUS WENT FROM S2 TO SOMETHING ELSE
        else if(origContract.equalsIgnoreCase("S2") && !(itemToEdit.getContractStatus().equalsIgnoreCase("S2"))){
            for( i=0;i<draft.getDraftTablePlayers().size();i++){
                if(itemToEdit.getFirstName().equalsIgnoreCase(draft.getDraftTablePlayers().get(i).getFirstName())
                        && itemToEdit.getLastName().equalsIgnoreCase(draft.getDraftTablePlayers().get(i).getLastName()))
                    draft.getDraftTablePlayers().remove(i);
            }
        }
        // CONTRACT STATUS WENT FROM S1 OR X TO S2
        else if(!(origContract.equalsIgnoreCase("S2")) && itemToEdit.getContractStatus().equalsIgnoreCase("S2")){
            draft.getDraftTablePlayers().add(si);
        }
        
        for( i=0;i<draft.getTeams().size();i++){
            if(draft.getTeams().get(i).getName().equalsIgnoreCase("free agent")){
                draft.getTeams().remove(i);
            }
        }
        draft.updateAvailableList();
        //draft.getFantasyTeamsPage();
            //gui.reloadDraft(draft);
    }
     
     
}
