/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.error.ErrorHandler;
import WBDK.gui.PlayersPage_GUI;

/**
 *
 * @author MatthewLuce
 */
public class DraftEditController {
 // WE USE THIS TO MAKE SURE OUR PROGRAMMED UPDATES OF UI
    // VALUES DON'T THEMSELVES TRIGGER EVENTS
    private boolean enabled;
    
     public DraftEditController() {
        enabled = true;
    }

    /**
     * This mutator method lets us enable or disable this controller.
     * 
     * @param enableSetting If false, this controller will not respond to
     * Course editing. If true, it will.
     */
    public void enable(boolean enableSetting) {
        enabled = enableSetting;
    }
    
    /**
     * This controller function is called in response to the user changing
     * course details in the UI. It responds by updating the bound Course
     * object using all the UI values, including the verification of that
     * data.
     * 
     * @param gui The user interface that requested the change.
     */
    public void handleDraftChangeRequest(PlayersPage_GUI gui) {
        if (enabled) {
            try {
                // UPDATE THE COURSE, VERIFYING INPUT VALUES
                gui.updateDraftInfo(gui.getDataManager().getDraft());
                
                // THE COURSE IS NOW DIRTY, MEANING IT'S BEEN 
                // CHANGED SINCE IT WAS LAST SAVED, SO MAKE SURE
                // THE SAVE BUTTON IS ENABLED
                gui.getFileController().markAsEdited(gui);
            } catch (Exception e) {
                // SOMETHING WENT WRONG
                ErrorHandler eH = ErrorHandler.getErrorHandler();
                eH.handleUpdateCourseError();
            }
        }
    }
    
}
