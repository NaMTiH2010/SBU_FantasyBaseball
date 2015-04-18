/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import WBDK.WBDK_PropertyType;
import static WBDK.WBDK_StartupConstants.CLOSE_BUTTON_LABEL;
import static WBDK.WBDK_StartupConstants.PATH_CSS;
import static WBDK.WBDK_StartupConstants.PATH_IMAGES;
import WBDK.controller.DraftEditController;
import WBDK.controller.FantasyStandingsEditController;
import WBDK.controller.FantasyTeamsEditController;
import WBDK.controller.FileController;
import WBDK.controller.PlayersAndFantasyTeamsEditController;
import WBDK.file.WBDK_FileManager;
import WBDK.file.WBDK_SiteExporter;
import WBDK.gui.MessageDialog;
import WBDK.gui.YesNoCancelDialog;
import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 * This type represents an abstraction of what our data manager
 * thinks of in regards to our gui. The point is that we can
 * easily decouple these two by using such a narrow interface.
 * 
 * @author Matthew Luce
 */
public abstract class WBDK_DataView {
        
    static final String PRIMARY_STYLE_SHEET = PATH_CSS + "wbdk_style.css";
   public static final String CLASS_BORDERED_PANE = "bordered_pane";
    static final String CLASS_SUBJECT_PANE = "subject_pane";
    public static final String CLASS_HEADING_LABEL = "heading_label";
    static final String CLASS_SUBHEADING_LABEL = "subheading_label";
    public static final String CLASS_PROMPT_LABEL = "prompt_label";
    static final String EMPTY_TEXT = "";
    static final int LARGE_TEXT_FIELD_LENGTH = 20;
    static final int SMALL_TEXT_FIELD_LENGTH = 5;
    
    

    // THIS MANAGES ALL OF THE APPLICATION'S DATA
    WBDK_DataManager dataManager;

    // THIS MANAGES COURSE FILE I/O
    WBDK_FileManager fileManager;

    // THIS MANAGES EXPORTING OUR SITE PAGES
    WBDK_SiteExporter siteExporter;

    // THIS HANDLES INTERACTIONS WITH FILE-RELATED CONTROLS
    FileController fileController;

    // THIS HANDLES INTERACTIONS WITH COURSE INFO CONTROLS
    DraftEditController draftController;
    
    // THIS HANDLES REQUESTS TO ADD OR EDIT SCHEDULE STUFF
    FantasyTeamsEditController scheduleController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT LECTURE STUFF
    FantasyStandingsEditController lectureController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT ASSIGNMENT STUFF
    PlayersAndFantasyTeamsEditController assignmentController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT 

    // THIS IS THE APPLICATION WINDOW
    Stage primaryStage;
    Stage secondaryStage;

    // THIS IS THE STAGE'S SCENE GRAPH
    Scene primaryScene;

    // THIS PANE ORGANIZES THE BIG PICTURE CONTAINERS FOR THE
    // APPLICATION GUI
    public BorderPane wbdkPane;
    
    // THIS IS THE TOP TOOLBAR AND ITS CONTROLS
    FlowPane fileToolbarPane;
    FlowPane bottomToolbarPane;
    Button newDraftButton;
    Button loadDraftButton;
    Button saveDraftButton;
    Button exportSiteButton;
    Button exitButton;
    
    // BOTTOM BUTTONS FOR NAVBAR
    Button draftPage_Button;
    Button mlbPage_Button;
    Button fantasyTeamsPage_Button;
    Button fantasyStandingsPage_Button;
    Button playersPage_Button;

    // WE'LL ORGANIZE OUR WORKSPACE COMPONENTS USING A BORDER PANE
    public BorderPane workspacePane;
    public boolean workspaceActivated;
    
    // WE'LL PUT THE WORKSPACE INSIDE A SCROLL PANE
    public ScrollPane workspaceScrollPane;

    // WE'LL PUT THIS IN THE TOP OF THE WORKSPACE, IT WILL
    // HOLD TWO OTHER PANES FULL OF CONTROLS AS WELL AS A LABEL
    public VBox topWorkspacePane;
    public Label draftHeadingLabel;
    public SplitPane topWorkspaceSplitPane;

    // HERE ARE OUR DIALOGS
    public MessageDialog messageDialog;
    public YesNoCancelDialog yesNoCancelDialog;
    

    public WBDK_DataView(Stage initPrimaryStage, Stage initSecondaryStage) {
        primaryStage = initPrimaryStage;
        secondaryStage = initSecondaryStage;
    }

    public WBDK_DataManager getDataManager() {
        return dataManager;
    }

    /**
     * Accessor method for the file controller.
     *
     * @return The FileController used by this UI.
     */
    public FileController getFileController() {
        return fileController;
    }
    
    /**
     * Accessor method for the course file manager.
     *
     * @return The CourseFileManager used by this UI.
     */
    public WBDK_FileManager getCourseFileManager() {
        return fileManager;
    }

    /**
     * Accessor method for the site exporter.
     *
     * @return The CourseSiteExporter used by this UI.
     */
    public WBDK_SiteExporter getSiteExporter() {
        return siteExporter;
    }

    /**
     * Accessor method for the window (i.e. stage).
     *
     * @return The window (i.e. Stage) used by this UI.
     */
    public Stage getWindow() {
        return primaryStage;
    }
    
    public MessageDialog getMessageDialog() {
        return messageDialog;
    }
    
    public YesNoCancelDialog getYesNoCancelDialog() {
        return yesNoCancelDialog;
    }
    public void setFileManager(WBDK_FileManager jsonFileManager) {
        this.fileManager = jsonFileManager;
    }

    public void setSiteExporter(WBDK_SiteExporter exporter) {
        siteExporter = exporter;
    }

    public void setDataManager(WBDK_DataManager dataManager) {
        this.dataManager = dataManager;    }

    public void initGUI(String windowTitle, ArrayList<String> subjects) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        // INIT THE TOOLBAR
        initFileToolbar();

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        initWorkspace(subjects);

        // NOW SETUP THE EVENT HANDLERS
        initEventHandlers();

        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(windowTitle);
    }
    
    /**
     * When called this function puts the workspace into the window,
     * revealing the controls for editing a Course.
     */
    public void activateWorkspace() {
        if (!workspaceActivated) {
            // PUT THE WORKSPACE IN THE GUI
            wbdkPane.setCenter(workspaceScrollPane);
            workspaceActivated = true;
        }
    }
    
    /**
     * This function takes all of the data out of the courseToReload 
     * argument and loads its values into the user interface controls.
     * 
     * @param courseToReload The Course whose data we'll load into the GUI.
     
    public void reloadDraft(Draft DraftToReload) {
        // FIRST ACTIVATE THE WORKSPACE IF NECESSARY
        if (!workspaceActivated) {
            activateWorkspace();
        }

        // WE DON'T WANT TO RESPOND TO EVENTS FORCED BY
        // OUR INITIALIZATION SELECTIONS
        draftController.enable(false);

        // FIRST LOAD ALL THE BASIC COURSE INFO
        courseSubjectComboBox.setValue(courseToReload.getSubject());
        courseNumberTextField.setText("" + courseToReload.getNumber());
        courseSemesterComboBox.setValue(courseToReload.getSemester());
        courseYearComboBox.setValue(courseToReload.getYear());
        courseTitleTextField.setText(courseToReload.getTitle());
        instructorNameTextField.setText(courseToReload.getInstructor().getName());
        instructorURLTextField.setText(courseToReload.getInstructor().getHomepageURL());
        indexPageCheckBox.setSelected(courseToReload.hasCoursePage(CoursePage.INDEX));
        syllabusPageCheckBox.setSelected(courseToReload.hasCoursePage(CoursePage.SYLLABUS));
        schedulePageCheckBox.setSelected(courseToReload.hasCoursePage(CoursePage.SCHEDULE));
        hwsPageCheckBox.setSelected(courseToReload.hasCoursePage(CoursePage.HWS));
        projectsPageCheckBox.setSelected(courseToReload.hasCoursePage(CoursePage.PROJECTS));

        // NOW WE DO WANT TO RESPOND WHEN THE USER INTERACTS WITH OUR CONTROLS
        draftController.enable(true);
    }*/
    
    /**
     * This method is used to activate/deactivate toolbar buttons when
     * they can and cannot be used so as to provide foolproof design.
     * 
     * @param saved Describes whether the loaded Course has been saved or not.
     */
    public void updateToolbarControls(boolean saved) {
        // THIS TOGGLES WITH WHETHER THE CURRENT COURSE
        // HAS BEEN SAVED OR NOT
        saveDraftButton.setDisable(saved);

        // ALL THE OTHER BUTTONS ARE ALWAYS ENABLED
        // ONCE EDITING THAT FIRST COURSE BEGINS
        loadDraftButton.setDisable(false);
        exportSiteButton.setDisable(false);

        // NOTE THAT THE NEW, LOAD, AND EXIT BUTTONS
        // ARE NEVER DISABLED SO WE NEVER HAVE TO TOUCH THEM
    }
    
    public void initDialogs() {
        messageDialog = new MessageDialog(primaryStage, CLOSE_BUTTON_LABEL);
        yesNoCancelDialog = new YesNoCancelDialog(primaryStage);
    }
    
    /**
     * This function initializes all the buttons in the toolbar at the top of
     * the application window. These are related to file management.
     */
    public void initFileToolbar() {
        fileToolbarPane = new FlowPane();

        // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
        // START AS ENABLED (false), WHILE OTHERS DISABLED (true)
        newDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.NEW_COURSE_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, false);
        loadDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.LOAD_COURSE_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, true);
        saveDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.SAVE_COURSE_ICON, WBDK_PropertyType.SAVE_COURSE_TOOLTIP, true);
        exportSiteButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXPORT_PAGE_ICON, WBDK_PropertyType.EXPORT_PAGE_TOOLTIP, true);
        exitButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXIT_ICON, WBDK_PropertyType.EXIT_TOOLTIP, false);
    }
    
    // CREATES AND SETS UP ALL THE CONTROLS TO GO IN THE APP WORKSPACE
    private void initWorkspace(ArrayList<String> subjects) throws IOException {
        // THE WORKSPACE HAS A FEW REGIONS, THIS 
        // IS FOR BASIC COURSE EDITING CONTROLS
      
        // THIS HOLDS ALL OUR WORKSPACE COMPONENTS, SO NOW WE MUST
        // ADD THE COMPONENTS WE'VE JUST INITIALIZED
        workspacePane = new BorderPane();
        workspacePane.setTop(topWorkspacePane);
        workspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        
        // AND NOW PUT IT IN THE WORKSPACE
        workspaceScrollPane = new ScrollPane();
        workspaceScrollPane.setContent(workspacePane);
        workspaceScrollPane.setFitToWidth(true);

        // NOTE THAT WE HAVE NOT PUT THE WORKSPACE INTO THE WINDOW,
        // THAT WILL BE DONE WHEN THE USER EITHER CREATES A NEW
        // COURSE OR LOADS AN EXISTING ONE FOR EDITING
        workspaceActivated = false;
    }
    // INITIALIZE THE WINDOW (i.e. STAGE) PUTTING ALL THE CONTROLS
    // THERE EXCEPT THE WORKSPACE, WHICH WILL BE ADDED THE FIRST
    // TIME A NEW Course IS CREATED OR LOADED
    public void initWindow(String windowTitle) {
        // SET THE WINDOW TITLE
        primaryStage.setTitle(windowTitle);

        // GET THE SIZE OF THE SCREEN
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // AND USE IT TO SIZE THE WINDOW
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        // ADD THE TOOLBAR ONLY, NOTE THAT THE WORKSPACE
        // HAS BEEN CONSTRUCTED, BUT WON'T BE ADDED UNTIL
        // THE USER STARTS EDITING A COURSE
        wbdkPane = new BorderPane();
        wbdkPane.setTop(fileToolbarPane);
        primaryScene = new Scene(wbdkPane);

        // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
        // WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
        primaryScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        //secondaryStage.show();
    }
    // INITIALIZE THE WINDOW (i.e. STAGE) PUTTING ALL THE CONTROLS
    // THERE EXCEPT THE WORKSPACE, WHICH WILL BE ADDED THE FIRST
    // TIME A NEW Course IS CREATED OR LOADED
    public void initWindow(String windowTitle, int num) {
        // SET THE WINDOW TITLE
        primaryStage.setTitle(windowTitle);

        // GET THE SIZE OF THE SCREEN
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // AND USE IT TO SIZE THE WINDOW
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        // ADD THE TOOLBAR ONLY, NOTE THAT THE WORKSPACE
        // HAS BEEN CONSTRUCTED, BUT WON'T BE ADDED UNTIL
        // THE USER STARTS EDITING A COURSE
        wbdkPane = new BorderPane();
        wbdkPane.setTop(fileToolbarPane);
        wbdkPane.setBottom(bottomToolbarPane);
        primaryScene = new Scene(wbdkPane);

        // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
        // WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
        primaryScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        //secondaryStage.show();
    }
    // INIT ALL THE EVENT HANDLERS
    public void initEventHandlers() throws IOException {
        // FIRST THE FILE CONTROLS
        fileController = new FileController(messageDialog, yesNoCancelDialog, fileManager, siteExporter);
        newDraftButton.setOnAction(e -> {
            fileController.handleNewDraftRequest(this);
        });
        /*
        loadDraftButton.setOnAction(e -> {
            fileController.handleLoadDraftRequest(this);
        });
        saveDraftButton.setOnAction(e -> {
            fileController.handleSaveDraftRequest(this, dataManager.getDraft());
        });
        exportSiteButton.setOnAction(e -> {
            fileController.handleExportDraftRequest(this,secondaryStage);
        }); 
        */
        exitButton.setOnAction(e -> {
            fileController.handleExitRequest(this);
        });
    }      

     // INIT A BUTTON AND ADD IT TO A CONTAINER IN A TOOLBAR
    public Button initChildButton(Pane toolbar, WBDK_PropertyType icon, WBDK_PropertyType tooltip, boolean disabled) {
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String imagePath = "file:" + PATH_IMAGES + props.getProperty(icon.toString());
        Image buttonImage = new Image(imagePath);
        Button button = new Button();
        button.setDisable(disabled);
        button.setGraphic(new ImageView(buttonImage));
        Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
        button.setTooltip(buttonTooltip);
        toolbar.getChildren().add(button);
        return button;
    }

  
    public void reloadCourse(Draft draftToReload) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void initBottomNavbar(){ 
        bottomToolbarPane = new FlowPane();

        // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
        // START AS ENABLED (false), WHILE OTHERS DISABLED (true)
        draftPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.NEW_COURSE_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, false);
        mlbPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.LOAD_COURSE_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, true);
        fantasyTeamsPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.SAVE_COURSE_ICON, WBDK_PropertyType.SAVE_COURSE_TOOLTIP, true);
        fantasyStandingsPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.EXPORT_PAGE_ICON, WBDK_PropertyType.EXPORT_PAGE_TOOLTIP, true);
        playersPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.EXIT_ICON, WBDK_PropertyType.EXIT_TOOLTIP, false);
    
    }
    
    
    
    ////////////////////////////////////////////////////////////
   
}
