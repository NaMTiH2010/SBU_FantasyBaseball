/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import WBDK.file.WBDK_FileManager;
import WBDK.gui.DefaultPage_GUI;
import java.util.ArrayList;

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
    
    public WBDK_DataManager(WBDK_DataView initGui) {
        view = initGui;
        draft = new Draft();
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

    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
