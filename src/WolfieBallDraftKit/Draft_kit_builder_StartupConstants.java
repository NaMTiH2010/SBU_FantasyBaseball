package WolfieBallDraftKit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MatthewLuce
 */
public class Draft_kit_builder_StartupConstants {
    
    // WE NEED THESE CONSTANTS JUST TO GET STARTED
    // LOADING SETTINGS FROM OUR XML FILES
    public static final String PROPERTIES_FILE_NAME = "properties.xml";
    public static final String PROPERTIES_SCHEMA_FILE_NAME = "properties_schema.xsd";    
    public static final String PATH_DATA = "./data/";
    public static final String PATH_COURSES = PATH_DATA + "courses/";
    public static final String PATH_IMAGES = "./images/";
    public static final String PATH_CSS = "csb/css/";
    public static final String PATH_DRAFTS = "drafts/";
    public static final String PATH_BASE = PATH_DRAFTS + "base/";
    public static final String PATH_EMPTY = ".";

    // THESE ARE THE DATA FILES WE WILL LOAD AT STARTUP
    public static final String JSON_FILE_PATH_HITTERS = PATH_DATA + "hitters.json";
    public static final String JSON_FILE_PATH_PITCHERS = PATH_DATA + "pitchers.json";
    
    // ERRO MESSAGE ASSOCIATED WITH PROPERTIES FILE LOADING ERRORS
    public static String PROPERTIES_FILE_ERROR_MESSAGE = "Error Loading properties.xml";

    // ERROR DIALOG CONTROL
    public static String CLOSE_BUTTON_LABEL = "Close";
}
