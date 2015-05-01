/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import WBDK.file.Json_WBDK_FileManager;
import WBDK.file.WBDK_FileManager;
import WBDK.gui.DefaultPage_GUI;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class WBDK_DataManager {
    
    // THIS IS THE COURSE BEING EDITED
    Draft draft;
    
    // THIS IS THE UI, WHICH MUST BE UPDATED
    // WHENEVER OUR MODEL'S DATA CHANGES
    WBDK_DataView view;
    
    // THIS HELPS US LOAD THINGS FOR OUR COURSE
    WBDK_FileManager fileManager;
    
    public WBDK_DataManager(WBDK_DataView initGui, ObservableList<Player> hitterArray,ObservableList<Player> pitcherArray) throws IOException {
        view = initGui;
        draft = new Draft(initGui, hitterArray,pitcherArray);
        
        //jsonFileManager.loadDraft(draft,"./data/hitters.json");
    }
    public Draft getDraft(){
        return this.draft;
    }
    public void setDraft(Draft draft){
        this.draft = draft;
    }
    
    /**
      * Accessor method for getting the file manager, which knows how
      * to read and write course data from/to files.
     */
    public WBDK_FileManager getFileManager() {
        return fileManager;
    } 

    public void reset(WBDK_DataView gui) throws IOException {
        // INITIALIZE THE PLAYERS PAGE 
        draft.playersPage.setDataManager(gui.getDataManager());
        draft.playersPage.setFileManager(gui.getCourseFileManager());
        draft.playersPage.setSiteExporter(gui.getSiteExporter());
        // INITIALIZE THE DRAFT PAGE
        draft.draftPage.setDataManager(gui.getDataManager());
        draft.draftPage.setFileManager(gui.getCourseFileManager());
        draft.draftPage.setSiteExporter(gui.getSiteExporter());
        // INITIALIZE THE MLB PAGE
        draft.mlb_Page.setDataManager(gui.getDataManager());
        draft.mlb_Page.setFileManager(gui.getCourseFileManager());
        draft.mlb_Page.setSiteExporter(gui.getSiteExporter());
        // INITIALIZE THE FANTASY TEAMS PAGE
        draft.fantasyTeamsPage.setDataManager(gui.getDataManager());
        draft.fantasyTeamsPage.setFileManager(gui.getCourseFileManager());
        draft.fantasyTeamsPage.setSiteExporter(gui.getSiteExporter());
        // INITIALIZE THE FANTASY STANDINGS PAGE
        draft.fantasyStandingsPage.setDataManager(gui.getDataManager());
        draft.fantasyStandingsPage.setFileManager(gui.getCourseFileManager());
        draft.fantasyStandingsPage.setSiteExporter(gui.getSiteExporter());
        
        
        
        draft.fantasyTeamsPage.initGUI("WolfieBall Draft Kit");
        
        // RELOAD ALL THE PAGES
        draft.fantasyTeamsPage.reloadDraft(draft);
    }
}
