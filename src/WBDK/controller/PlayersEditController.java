/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.WBDK_DataManager;
import WBDK.gui.FantasyTeamsItemDialog;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.PlayersItemDialog;
import WBDK.gui.PlayersPage_GUI;
import WBDK.gui.YesNoCancelDialog;
import java.io.IOException;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class PlayersEditController {
    PlayersItemDialog sid;
    FantasyTeamsItemDialog ftid;
    MessageDialog messageDialog;
    YesNoCancelDialog yesNoCancelDialog;

    public PlayersEditController(Stage primaryStage, Draft draft, MessageDialog messageDialog, YesNoCancelDialog yesNoCancelDialog) {
        sid = new PlayersItemDialog(primaryStage, draft, messageDialog);
        ftid = new FantasyTeamsItemDialog(primaryStage, draft, messageDialog);
        this.messageDialog = messageDialog;
        this.yesNoCancelDialog = yesNoCancelDialog;
    }

    public void handleEditPlayerItemRequest(PlayersPage_GUI gui, Player itemToEdit) {
     WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        //Player si = new Player();
        Player si = sid.showEditPlayerItemDialog(itemToEdit);
        
        // DID THE USER CONFIRM?
        if ( sid.wasCompleteSelected()) {
            // UPDATE THE SCHEDULE ITEM
            
            //si = sid.getPlayerItem();
            
            sid.getFakeTeam().addStartingLineupPlayer(si);
            itemToEdit.setTaken(true);
            draft.updateAvailableList();
            System.out.println("What is this teams name: "+ftid.getFakeTeam().getName());
            System.out.println("What is this teams name: "+sid.getFakeTeam().getName());
        }
        else {
            System.out.println("THIS SHOULDNT BE HAPPENING");
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }        
    }

    public void handleAddPlayerRequest(PlayersPage_GUI gui) {
       WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        sid.showAddPlayerDialog();
        
        // DID THE USER CONFIRM?
        if (sid.wasCompleteSelected()) {
            // GET THE LECTURE ITEM
            
            Player si = new Player();
            si = sid.getPlayerItem();
            // AND ADD IT AS A ROW TO THE TABLE
            draft.getPlayers().add(si);
            draft.updateAvailableList();
        }
        else {
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }
    }
    
    
}
