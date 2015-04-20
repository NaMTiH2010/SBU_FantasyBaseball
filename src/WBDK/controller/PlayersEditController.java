/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.WBDK_DataManager;
import WBDK.gui.MessageDialog;
import WBDK.gui.PlayersItemDialog;
import WBDK.gui.PlayersPage_GUI;
import WBDK.gui.YesNoCancelDialog;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class PlayersEditController {
    PlayersItemDialog sid;
    MessageDialog messageDialog;
    YesNoCancelDialog yesNoCancelDialog;

    public PlayersEditController(Stage primaryStage, Draft draft, MessageDialog messageDialog, YesNoCancelDialog yesNoCancelDialog) {
        sid = new PlayersItemDialog(primaryStage, draft, messageDialog);
        this.messageDialog = messageDialog;
        this.yesNoCancelDialog = yesNoCancelDialog;
    }

    public void handleEditPlayerItemRequest(PlayersPage_GUI gui, Player itemToEdit) {
     WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        sid.showEditPlayerItemDialog(itemToEdit);
        // DID THE USER CONFIRM?
        if (sid.wasCompleteSelected()) {
            // UPDATE THE SCHEDULE ITEM
            Player si = sid.getPlayerItem();
            System.out.println(si.notesProperty().toString()+" asdfasdfasdflj;sajflsadjf");
            //itemToEdit.setNotes(si.notesProperty().toString());
             itemToEdit.setNotes(si.getNotes());
        }
        else {
            System.out.println("THIS SHOULDNT BE HAPPENING");
            // THE USER MUST HAVE PRESSED CANCEL, SO
            // WE DO NOTHING
        }        
    }
    
}
