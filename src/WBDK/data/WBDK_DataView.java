/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

/**
 * This type represents an abstraction of what our data manager
 * thinks of in regards to our gui. The point is that we can
 * easily decouple these two by using such a narrow interface.
 * 
 * @author Matthew Luce
 */
public interface WBDK_DataView {
    public void reloadCourse(Draft draftToReload);

    public void updateToolbarControls(boolean saved);

    public WBDK_DataManager getDataManager();
}
