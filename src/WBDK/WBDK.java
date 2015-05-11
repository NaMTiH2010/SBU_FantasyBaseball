package WBDK;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static WBDK.WBDK_PropertyType.PROP_APP_TITLE;
import static WBDK.WBDK_StartupConstants.JSON_FILE_PATH_HITTERS;
import static WBDK.WBDK_StartupConstants.JSON_FILE_PATH_PITCHERS;
import static WBDK.WBDK_StartupConstants.PATH_BASE;
import static WBDK.WBDK_StartupConstants.PATH_DATA;
import static WBDK.WBDK_StartupConstants.PATH_DRAFTS;
import static WBDK.WBDK_StartupConstants.PROPERTIES_FILE_NAME;
import static WBDK.WBDK_StartupConstants.PROPERTIES_SCHEMA_FILE_NAME;
import WBDK.data.Player;
import WBDK.data.WBDK_DataManager;
import WBDK.data.Team;
import WBDK.error.ErrorHandler;
import WBDK.file.WBDK_SiteExporter;
import WBDK.file.Json_WBDK_FileManager;
import WBDK.gui.DefaultPage_GUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;
import xml_utilities.InvalidXMLFileFormatException;

/**
 *
 * @author MatthewLuce
 */
public class WBDK extends Application {// ITEMS FOR THE PROGESS BAR
    ProgressBar bar;
    ProgressIndicator indicator;
    Button button;
    Label processLabel;
    int numTasks = 0;
    ReentrantLock progressLock;
    
    // THIS IS THE FULL USER INTERFACE, WHICH WILL BE INITIALIZED
    // AFTER THE PROPERTIES FILE IS LOADED
   DefaultPage_GUI gui;

    /**
     * This is where our Application begins its initialization, it will
     * create the GUI and initialize all of its components.
     * 
     * @param primaryStage This application's window.
     */
    @Override
    public void start(Stage primaryStage) {
        Stage secondaryStage = new Stage();
        // LET'S START BY GIVING THE PRIMARY STAGE TO OUR ERROR HANDLER
        ErrorHandler eH = ErrorHandler.getErrorHandler();
        eH.initMessageDialog(primaryStage);
        
        // LOAD APP SETTINGS INTO THE GUI AND START IT UP
        boolean success = loadProperties();
        if (success) {
            PropertiesManager props = PropertiesManager.getPropertiesManager();
            String appTitle = props.getProperty(PROP_APP_TITLE);
            try {                
                // WE WILL SAVE OUR COURSE DATA USING THE JSON FILE
                // FORMAT SO WE'LL LET THIS OBJECT DO THIS FOR US
                Json_WBDK_FileManager jsonFileManager = new Json_WBDK_FileManager();
                
                // AND THIS ONE WILL DO THE COURSE WEB PAGE EXPORTING
                WBDK_SiteExporter exporter = new WBDK_SiteExporter(PATH_BASE, PATH_DRAFTS);
                
                //Player player = jsonFileManager.loadPlayer(JSON_FILE_PATH_HITTERS);
                
                //System.out.println(player.getLastName()+" "+player.getFirstName());
                ObservableList<Player> jsonHitters = jsonFileManager.loadTheHitters(JSON_FILE_PATH_HITTERS);
                ObservableList<Player> jsonPitchers = jsonFileManager.loadThePitchers(JSON_FILE_PATH_PITCHERS);
                //Team teamA = new Team();
                ArrayList<String> subjects= new ArrayList();
                subjects.add("car");
                subjects.add("bus");
                        //jsonFileManager.loadHitters(JSON_FILE_PATH_HITTERS);
                                
                // AND NOW GIVE ALL OF THIS STUFF TO THE GUI
                // INITIALIZE THE USER INTERFACE COMPONENTS
                gui = new DefaultPage_GUI(primaryStage,secondaryStage);
                gui.setFileManager(jsonFileManager);
                gui.setSiteExporter(exporter);
                
                // CONSTRUCT THE DATA MANAGER AND GIVE IT TO THE GUI
                WBDK_DataManager dataManager = new WBDK_DataManager(gui, jsonHitters,jsonPitchers); 
                gui.setDataManager(dataManager);

                // FINALLY, START UP THE USER INTERFACE WINDOW AFTER ALL
                // REMAINING INITIALIZATION
                gui.initGUI(appTitle);                
            }
            catch(IOException ioe) {
                eH = ErrorHandler.getErrorHandler();
                eH.handlePropertiesFileError();
            }
        }
    }
    
    /**
     * Loads this application's properties file, which has a number of settings
     * for initializing the user interface.
     * 
     * @return true if the properties file was loaded successfully, false otherwise.
     */
    public boolean loadProperties() {
        try {
            // LOAD THE SETTINGS FOR STARTING THE APP
            PropertiesManager props = PropertiesManager.getPropertiesManager();
            props.addProperty(PropertiesManager.DATA_PATH_PROPERTY, PATH_DATA);
            props.loadProperties(PROPERTIES_FILE_NAME, PROPERTIES_SCHEMA_FILE_NAME);
            return true;
       } catch (InvalidXMLFileFormatException ixmlffe) {
            // SOMETHING WENT WRONG INITIALIZING THE XML FILE
            ErrorHandler eH = ErrorHandler.getErrorHandler();
            eH.handlePropertiesFileError();
            return false;
        }        
    }

    /**
     * This is where program execution begins. Since this is a JavaFX app
     * it will simply call launch, which gets JavaFX rolling, resulting in
     * sending the properly initialized Stage (i.e. window) to our start
     * method in this class.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }
    
}


