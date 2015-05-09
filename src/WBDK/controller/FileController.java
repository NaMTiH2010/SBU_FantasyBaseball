/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.controller;

import WBDK.data.Draft;
import WBDK.data.WBDK_DataManager;
import WBDK.data.WBDK_DataView;
import WBDK.error.ErrorHandler;
import WBDK.file.WBDK_FileManager;
import WBDK.file.WBDK_SiteExporter;
import WBDK.gui.DefaultPage_GUI;
import WBDK.gui.MessageDialog;
import WBDK.gui.YesNoCancelDialog;
import static WBDK.WBDK_PropertyType.COURSE_SAVED_MESSAGE;
import static WBDK.WBDK_PropertyType.NEW_COURSE_CREATED_MESSAGE;
import static WBDK.WBDK_PropertyType.NEW_DRAFT_CREATED_MESSAGE;
import static WBDK.WBDK_PropertyType.SAVE_UNSAVED_WORK_MESSAGE;
import static WBDK.WBDK_StartupConstants.PATH_DRAFTS;
import WBDK.data.Team;
import WBDK.gui.FantasyTeams_GUI;
import WBDK.gui.PlayersPage_GUI;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class FileController {

    // WE WANT TO KEEP TRACK OF WHEN SOMETHING HAS NOT BEEN SAVED
    private boolean saved;

    // THIS GUY KNOWS HOW TO READ AND WRITE COURSE DATA
    private final WBDK_FileManager draftIO;

    // THIS GUY KNOWS HOW TO EXPORT COURSE SCHEDULE PAGES
    private final WBDK_SiteExporter exporter;

    // THIS WILL PROVIDE FEEDBACK TO THE USER WHEN SOMETHING GOES WRONG
    ErrorHandler errorHandler;
    
    // THIS WILL PROVIDE FEEDBACK TO THE USER AFTER
    // WORK BY THIS CLASS HAS COMPLETED
    MessageDialog messageDialog;
    
    // AND WE'LL USE THIS TO ASK YES/NO/CANCEL QUESTIONS
    YesNoCancelDialog yesNoCancelDialog;
    
    // WE'LL USE THIS TO GET OUR VERIFICATION FEEDBACK
    PropertiesManager properties;

    /**
     * This default constructor starts the program without a course file being
     * edited.
     *
     * @param initMessageDialog
     * @param initYesNoCancelDialog
     * @param initDraftIO
     * @param initExporter The object that will be exporting courses to Web
     * sites.
     */
    public FileController(
            MessageDialog initMessageDialog,
            YesNoCancelDialog initYesNoCancelDialog,
            WBDK_FileManager initDraftIO,
            WBDK_SiteExporter initExporter) {
        // NOTHING YET
        saved = true;
        
        // KEEP THESE GUYS FOR LATER
        draftIO = initDraftIO;
        exporter = initExporter;
        
        // BE READY FOR ERRORS
        errorHandler = ErrorHandler.getErrorHandler();
        
        // AND GET READY TO PROVIDE FEEDBACK
        messageDialog = initMessageDialog;
        yesNoCancelDialog = initYesNoCancelDialog;
        properties = PropertiesManager.getPropertiesManager();
    }
    
    /**
     * This method marks the appropriate variable such that we know
     * that the current Course has been edited since it's been saved.
     * The UI is then updated to reflect this.
     * 
     * @param gui The user interface editing the Course.
     */
    public void markAsEdited(WBDK_DataView gui) {
        // THE Course OBJECT IS NOW DIRTY
        saved = false;
        
        // LET THE UI KNOW
        gui.updateToolbarControls(saved);
    }

    /**
     * This method starts the process of editing a new Course. If a course is
     * already being edited, it will prompt the user to save it first.
     * 
     * @param gui The user interface editing the Course.
     */
    public void handleNewDraftRequest(WBDK_DataView gui) {
        try {
            // WE MAY HAVE TO SAVE CURRENT WORK
            boolean continueToMakeNew = true;
            if (!saved) {
                // THE USER CAN OPT OUT HERE WITH A CANCEL
                continueToMakeNew = promptToSave(gui);
            }

            // IF THE USER REALLY WANTS TO MAKE A NEW COURSE
            if (continueToMakeNew) {
                // RESET THE DATA, WHICH SHOULD TRIGGER A RESET OF THE UI
                WBDK_DataManager dataManager = gui.getDataManager();
                dataManager.reset(gui);
                saved = false;

                // REFRESH THE GUI, WHICH WILL ENABLE AND DISABLE
                // THE APPROPRIATE CONTROLS
                gui.updateToolbarControls(saved);

                // TELL THE USER THE COURSE HAS BEEN CREATED
                messageDialog.show(properties.getProperty(NEW_DRAFT_CREATED_MESSAGE));
            }
        } catch (IOException ioe) {
            // SOMETHING WENT WRONG, PROVIDE FEEDBACK
            errorHandler.handleNewCourseError();
        }
    }
    public void handleMLBPageRequest(WBDK_DataView gui) throws IOException{
                WBDK_DataManager dataManager = gui.getDataManager();
                //dataManager.reset(gui);
                //gui.updateToolbarControls(saved);
                dataManager.getDraft().getMLB_Page().initGUI("WolfieBall Draft Kit");
                dataManager.getDraft().getMLB_Page().reloadDraft(dataManager.getDraft());
    }
    public void handleFantasyTeamsPageRequest(WBDK_DataView gui) throws IOException {
                WBDK_DataManager dataManager = gui.getDataManager();
                //dataManager.reset(gui);
                //gui.updateToolbarControls(saved);
                dataManager.getDraft().getFantasyTeamsPage().initGUI("WolfieBall Draft Kit");
                dataManager.getDraft().getFantasyTeamsPage().reloadDraft(dataManager.getDraft());
    }
    public void handlePlayersPageRequest(WBDK_DataView gui) throws IOException {
                WBDK_DataManager dataManager = gui.getDataManager();
                //dataManager.reset(gui);
                //gui.updateToolbarControls(saved);
                dataManager.getDraft().getPlayersPage().initGUI("WolfieBall Draft Kit");
                dataManager.getDraft().getPlayersPage().reloadDraft(dataManager.getDraft());
    }
    public void handleFantasyStandingsPageRequest(WBDK_DataView gui) throws IOException {
                WBDK_DataManager dataManager = gui.getDataManager();
                //dataManager.reset(gui);
                //gui.updateToolbarControls(saved);
                dataManager.getDraft().getFantasyStandingsPage().initGUI("WolfieBall Draft Kit");
                dataManager.getDraft().getFantasyStandingsPage().reloadDraft(dataManager.getDraft());
    }
    
    public void handleDraftPageRequest(WBDK_DataView gui) throws IOException {
                WBDK_DataManager dataManager = gui.getDataManager();
                //dataManager.reset(gui);
                //gui.updateToolbarControls(saved);
                dataManager.getDraft().getDraftPage().initGUI("WolfieBall Draft Kit");
                dataManager.getDraft().getDraftPage().reloadDraft(dataManager.getDraft());
    }
    /**
     * This method will exit the application, making sure the user doesn't lose
     * any data first.
     * 
     * @param gui
     */
    public void handleExitRequest(WBDK_DataView gui) {
        try {
            // WE MAY HAVE TO SAVE CURRENT WORK
            boolean continueToExit = true;
            if (!saved) {
                // THE USER CAN OPT OUT HERE
                continueToExit = promptToSave(gui);
            }

            // IF THE USER REALLY WANTS TO EXIT THE APP
            if (continueToExit) {
                // EXIT THE APPLICATION
                System.exit(0);
            }
        } catch (IOException ioe) {
            ErrorHandler eH = ErrorHandler.getErrorHandler();
            eH.handleExitError();
        }
    }
    
    /**
     * This helper method verifies that the user really wants to save their
     * unsaved work, which they might not want to do. Note that it could be used
     * in multiple contexts before doing other actions, like creating a new
     * Course, or opening another Course. Note that the user will be
     * presented with 3 options: YES, NO, and CANCEL. YES means the user wants
     * to save their work and continue the other action (we return true to
     * denote this), NO means don't save the work but continue with the other
     * action (true is returned), CANCEL means don't save the work and don't
     * continue with the other action (false is returned).
     *
     * @return true if the user presses the YES option to save, true if the user
     * presses the NO option to not save, false if the user presses the CANCEL
     * option to not continue.
     */
    private boolean promptToSave(WBDK_DataView gui) throws IOException {
        // PROMPT THE USER TO SAVE UNSAVED WORK
        yesNoCancelDialog.show(properties.getProperty(SAVE_UNSAVED_WORK_MESSAGE));
        
        // AND NOW GET THE USER'S SELECTION
        String selection = yesNoCancelDialog.getSelection();

        // IF THE USER SAID YES, THEN SAVE BEFORE MOVING ON
        if (selection.equals(YesNoCancelDialog.YES)) {
            // SAVE THE COURSE
            WBDK_DataManager dataManager = gui.getDataManager();
            draftIO.saveDraft(dataManager.getDraft());
            saved = true;
            
             // RESET THE DATA, WHICH SHOULD TRIGGER A RESET OF THE UI
                //WBDK_DataManager dataManager = gui.getDataManager();
                dataManager.reset(gui);
                //saved = false;

                // REFRESH THE GUI, WHICH WILL ENABLE AND DISABLE
                // THE APPROPRIATE CONTROLS
                gui.updateToolbarControls(saved);
            
        } // IF THE USER SAID CANCEL, THEN WE'LL TELL WHOEVER
        // CALLED THIS THAT THE USER IS NOT INTERESTED ANYMORE
        else if (selection.equals(YesNoCancelDialog.CANCEL)) {
            return false;
        }

        // IF THE USER SAID NO, WE JUST GO ON WITHOUT SAVING
        // BUT FOR BOTH YES AND NO WE DO WHATEVER THE USER
        // HAD IN MIND IN THE FIRST PLACE
        return true;
    }


    /**
     * This mutator method marks the file as not saved, which means that when
     * the user wants to do a file-type operation, we should prompt the user to
     * save current work first. Note that this method should be called any time
     * the course is changed in some way.
     */
    public void markFileAsNotSaved() {
        saved = false;
    }

    /**
     * Accessor method for checking to see if the current course has been saved
     * since it was last edited.
     *
     * @return true if the current course is saved to the file, false otherwise.
     */
    public boolean isSaved() {
        return saved;
    }

    

    public void handleRemovePlayerRequest(PlayersPage_GUI aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void handleAddTeamRequest(FantasyTeams_GUI aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void handleSaveDraftRequest(WBDK_DataView gui, Draft draft) {
        try {
            
            // SAVE IT TO A FILE
            draftIO.saveDraft(draft);

            // MARK IT AS SAVED
            saved = true;

            // TELL THE USER THE FILE HAS BEEN SAVED
            messageDialog.show(properties.getProperty(COURSE_SAVED_MESSAGE));

            // AND REFRESH THE GUI, WHICH WILL ENABLE AND DISABLE
            // THE APPROPRIATE CONTROLS
            gui.updateToolbarControls(saved);
        } catch (IOException ioe) {
            errorHandler.handleSaveCourseError();
        }
    }

    public void handleLoadDraftRequest(WBDK_DataView gui) {
        try {
            // WE MAY HAVE TO SAVE CURRENT WORK
            boolean continueToOpen = true;
            if (!saved) {
                // THE USER CAN OPT OUT HERE WITH A CANCEL
                continueToOpen = promptToSave(gui);
            }

            // IF THE USER REALLY WANTS TO OPEN A Course
            if (continueToOpen) {
                // GO AHEAD AND PROCEED LOADING A Course
                promptToOpen(gui);
            }
        } catch (IOException ioe) {
            // SOMETHING WENT WRONG
            errorHandler.handleLoadCourseError();
        }
    }

    
     /**
     * This helper method asks the user for a file to open. The user-selected
     * file is then loaded and the GUI updated. Note that if the user cancels
     * the open process, nothing is done. If an error occurs loading the file, a
     * message is displayed, but nothing changes.
     */
    private void promptToOpen(WBDK_DataView gui) {
        // AND NOW ASK THE USER FOR THE COURSE TO OPEN
        FileChooser draftFileChooser = new FileChooser();
        draftFileChooser.setInitialDirectory(new File(PATH_DRAFTS));
        File selectedFile = draftFileChooser.showOpenDialog(gui.getWindow());

        // ONLY OPEN A NEW FILE IF THE USER SAYS OK
        if (selectedFile != null) {
            try {
                Draft draftToLoad = gui.getDataManager().getDraft();
                draftIO.loadDraft(draftToLoad, selectedFile.getAbsolutePath());
                
                gui.reloadDraft(draftToLoad);
                saved = true;
                gui.getDataManager().reset(gui);
                
            } catch (Exception e) {
                System.out.println("FAIL?");
                ErrorHandler eH = ErrorHandler.getErrorHandler();
                eH.handleLoadCourseError();
            }
        }
    }
    public void handleRemoveTeamRequest(FantasyTeams_GUI gui) throws IOException{
        WBDK_DataManager cdm = gui.getDataManager();
        Draft draft = cdm.getDraft();
        //Player player = gui.getSelectedPlayerFromTable();
        Team team = gui.getSelectedTeam();
        //ftid.showRemoveTeamDialog();
        yesNoCancelDialog.show("Delete this Team?");
        
        // AND NOW GET THE USER'S SELECTION
        String selection = yesNoCancelDialog.getSelection();

        // IF THE USER SAID YES, THEN SAVE BEFORE MOVING ON
        if (selection.equals(YesNoCancelDialog.YES)) {
            if(team.getName().equals("")){}
            else{
 
            for(int i=0;i<team.getStartingLineup().size();i++){
                team.getStartingLineup().get(i).setAvailability(true);
                team.getStartingLineup().get(i).setTaken(false);
                    //team.getStartingLineup().remove(i);
                }
            for(int i=0;i<draft.getTeams().size();i++){
                if(draft.getTeams().get(i).getName().equals(team.getName()))
                    draft.getTeams().remove(i);
            }
            
            if(draft.getTeams().isEmpty()){
                gui.flipRemoveButton(true);
                gui.flipEditButton(true);
            }
            draft.updateAvailableList();
            gui.getDataManager().reset(gui);
        }
            
        }
     }
}
