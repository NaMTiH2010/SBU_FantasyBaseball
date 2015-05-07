/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import static WBDK.WBDK_PropertyType.SAVE_UNSAVED_WORK_MESSAGE;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import WBDK.data.WBDK_DataManager;
import WBDK.data.WBDK_DataView;
import WBDK.gui.FantasyTeamsItemDialog;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.PlayersItemDialog;
import WBDK.gui.PlayersPage_GUI;
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
        Player si = ftid.showEditTeamPlayerItemDialog(itemToEdit);
        
        // DID THE USER CONFIRM?
        if ( ftid.wasCompleteSelected()) {
            // UPDATE THE SCHEDULE ITEM
                        
            String playersNewFantasyTeam = si.getFantasyTeam();
            

            if(playersNewFantasyTeam.equalsIgnoreCase("free agent")){
                System.out.println("case 1 free agent "+ originalTeam.getName());
                for(int j = 0; j< draft.getPlayers().size();j++){
                    if(draft.getPlayers().get(j).getFirstName().equalsIgnoreCase(si.getFirstName())
                            && draft.getPlayers().get(j).getFirstName().equalsIgnoreCase(si.getFirstName()))
                        
                        draft.getPlayers().get(j).setAvailability(true);
                        draft.getPlayers().get(j).setTaken(false);
                }
                
                for(int i=0;i<originalTeam.getStartingLineup().size();i++){
                    //if(draft.getTeams().get(i).getName().equalsIgnoreCase(ftid.getOrigTeam())){
                    //for(int j=0;j<draft.getTeams().get(i).getStartingLineup().size();j++){
                        if(originalTeam.getStartingLineup().get(i).getFirstName().equalsIgnoreCase(si.getFirstName())){
                            System.out.println("found him");
                            originalTeam.getStartingLineup().remove(i);
                        }
                    //}
                //}
            }
        }
        else if(playersNewFantasyTeam.equalsIgnoreCase(ftid.getOrigTeam())){
            System.out.println("case 2 same team");
        }
        else{
            for(int i=0;i<originalTeam.getStartingLineup().size();i++){
                    //if(draft.getTeams().get(i).getName().equalsIgnoreCase(ftid.getOrigTeam())){
                    //for(int j=0;j<draft.getTeams().get(i).getStartingLineup().size();j++){
                        if(originalTeam.getStartingLineup().get(i).getFirstName().equalsIgnoreCase(si.getFirstName())){
                            System.out.println("found him");
                            originalTeam.getStartingLineup().remove(i);
                        }
            ftid.getFakeTeam().addStartingLineupPlayer(si);
        }
        
            //si = sid.getPlayerItem();
            
            
            //itemToEdit.setTaken(true);
            
        }
            for(int i=0;i<draft.getTeams().size();i++){
            if(draft.getTeams().get(i).getName().equalsIgnoreCase("free agent")){
                draft.getTeams().remove(i);
            }
        }
            draft.updateAvailableList();
            System.out.println("What is this teams name: "+ftid.getFakeTeam().getName() +"the fantasy team is "+ playersNewFantasyTeam);
        }
        else {
            System.out.println("THIS SHOULDNT BE HAPPENING");
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }        
    }
     
     
}
