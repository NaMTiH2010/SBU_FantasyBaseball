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
import WBDK.data.WBDK_DataView;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.PlayersItemDialog;
import WBDK.gui.PlayersPage_GUI;
import WBDK.gui.YesNoCancelDialog;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class FantasyTeamsEditController {    
    PlayersItemDialog sid;
    MessageDialog messageDialog;
    YesNoCancelDialog yesNoCancelDialog;

    public FantasyTeamsEditController(Stage primaryStage, Draft draft, MessageDialog messageDialog, YesNoCancelDialog yesNoCancelDialog) {
        sid = new PlayersItemDialog(primaryStage, draft, messageDialog);
        this.messageDialog = messageDialog;
        this.yesNoCancelDialog = yesNoCancelDialog;
    }

    
     public void handleAddTeamRequest(WBDK_DataView gui) {
       WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        sid.showAddTeamDialog();
        
        // DID THE USER CONFIRM?
        if (sid.wasCompleteSelected()) {
            // GET THE LECTURE ITEM
            Team ti = sid.getFakeTeam();
            
            // AND ADD IT AS A ROW TO THE TABLE
            draft.getTeams().add(ti);
            //System.out.println(draft.getTeams().get(0).getName());
        }
        else {
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }
    }
}
