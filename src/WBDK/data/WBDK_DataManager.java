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
    
    public WBDK_DataManager(WBDK_DataView initGui, Json_WBDK_FileManager jsonFileManager) throws IOException {
        view = initGui;
        draft = new Draft(initGui);
        //jsonFileManager.loadDraft(draft,"./data/hitters.json");
    }
    public Draft getDraft(){
        return this.draft;
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
        // INITIALIZE THE MLB PAGE
        // INITIALIZE THE FANTASY TEAMS PAGE
        // INITIALIZE THE FANTASY STANDINGS PAGE
        
        ArrayList<String> subjects= new ArrayList();
                subjects.add("car");
                subjects.add("bus");
        
        draft.playersPage.initGUI("TESTING",subjects);
        
        // RELOAD ALL THE PAGES
        draft.playersPage.reloadDraft(draft);
    }
}
