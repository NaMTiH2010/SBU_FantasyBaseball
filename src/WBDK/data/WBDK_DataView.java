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
import WBDK.controller.PlayersEditController;
import WBDK.file.WBDK_FileManager;
import WBDK.file.WBDK_SiteExporter;
import WBDK.gui.MessageDialog;
import WBDK.gui.YesNoCancelDialog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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
        
    public static final String PRIMARY_STYLE_SHEET = PATH_CSS + "wbdk_style.css";
    public static final String CLASS_BORDERED_PANE = "bordered_pane";
    public static final String CLASS_SUBJECT_PANE = "subject_pane";
    public static final String CLASS_HEADING_LABEL = "heading_label";
    public static final String CLASS_SUBHEADING_LABEL = "subheading_label";
    public static final String CLASS_PROMPT_LABEL = "prompt_label";
    public static final String EMPTY_TEXT = "";
    public static final int LARGE_TEXT_FIELD_LENGTH = 20;
    public static final int SMALL_TEXT_FIELD_LENGTH = 5;
    
    

    // THIS MANAGES ALL OF THE APPLICATION'S DATA
    public WBDK_DataManager dataManager;

    // THIS MANAGES COURSE FILE I/O
   public  WBDK_FileManager fileManager;

    // THIS MANAGES EXPORTING OUR SITE PAGES
   public WBDK_SiteExporter siteExporter;

    // THIS HANDLES INTERACTIONS WITH FILE-RELATED CONTROLS
    public FileController fileController;

    // THIS HANDLES INTERACTIONS WITH COURSE INFO CONTROLS
   public DraftEditController draftController;
    
    // THIS HANDLES REQUESTS TO ADD OR EDIT SCHEDULE STUFF
    public FantasyTeamsEditController scheduleController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT LECTURE STUFF
   public  FantasyStandingsEditController lectureController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT ASSIGNMENT STUFF
   public PlayersAndFantasyTeamsEditController assignmentController;
   
   public PlayersEditController playersController;
    
    //THIS HANDLES REQUESTS TO ADD OR EDIT 

    // THIS IS THE APPLICATION WINDOW
   public Stage primaryStage;
   public Stage secondaryStage;

    // THIS IS THE STAGE'S SCENE GRAPH
   public Scene primaryScene;

    // THIS PANE ORGANIZES THE BIG PICTURE CONTAINERS FOR THE
    // APPLICATION GUI
    public BorderPane wbdkPane;
    
    // THIS IS THE TOP TOOLBAR AND ITS CONTROLS
   public FlowPane fileToolbarPane;
   public FlowPane bottomToolbarPane;
   public Button newDraftButton;
   public Button loadDraftButton;
   public Button saveDraftButton;
   public Button exportSiteButton;
   public Button exitButton;
    
    // BOTTOM BUTTONS FOR NAVBAR
   public Button draftPage_Button;
   public Button mlbPage_Button;
   public Button fantasyTeamsPage_Button;
   public Button fantasyStandingsPage_Button;
   public Button playersPage_Button;

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

    public void initGUI(String windowTitle) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        
        initBottomNavbar();
        
        // INIT THE TOOLBAR
        initFileToolbar();

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        initWorkspace();

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
        newDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.NEW_COURSE_ICON, WBDK_PropertyType.NEW_DRAFT_TOOLTIP, false);
        loadDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.LOAD_COURSE_ICON, WBDK_PropertyType.LOAD_DRAFT_TOOLTIP, false);
        saveDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.SAVE_COURSE_ICON, WBDK_PropertyType.SAVE_DRAFT_TOOLTIP, true);
        exportSiteButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXPORT_PAGE_ICON, WBDK_PropertyType.EXPORT_PAGE_TOOLTIP, true);
        exitButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXIT_ICON, WBDK_PropertyType.EXIT_TOOLTIP, false);
    }
    public void initFileToolbar(boolean saveIt) {
        fileToolbarPane = new FlowPane();

        // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
        // START AS ENABLED (false), WHILE OTHERS DISABLED (true)
        newDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.NEW_COURSE_ICON, WBDK_PropertyType.NEW_DRAFT_TOOLTIP, false);
        loadDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.LOAD_COURSE_ICON, WBDK_PropertyType.LOAD_DRAFT_TOOLTIP, false);
        saveDraftButton = initChildButton(fileToolbarPane, WBDK_PropertyType.SAVE_COURSE_ICON, WBDK_PropertyType.SAVE_DRAFT_TOOLTIP, saveIt);
        exportSiteButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXPORT_PAGE_ICON, WBDK_PropertyType.EXPORT_PAGE_TOOLTIP, true);
        exitButton = initChildButton(fileToolbarPane, WBDK_PropertyType.EXIT_ICON, WBDK_PropertyType.EXIT_TOOLTIP, false);
    }
    
    // CREATES AND SETS UP ALL THE CONTROLS TO GO IN THE APP WORKSPACE
    public void initWorkspace() throws IOException {
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
        
        loadDraftButton.setOnAction(e -> {
            fileController.handleLoadDraftRequest(this);
        });
        saveDraftButton.setOnAction(e -> {
            fileController.handleSaveDraftRequest(this, dataManager.getDraft());
        });/*
        exportSiteButton.setOnAction(e -> {
            fileController.handleExportDraftRequest(this,secondaryStage);
        }); 
        */
        exitButton.setOnAction(e -> {
            fileController.handleExitRequest(this);
        });
        
        // BOTTOMTOOLBAR
        draftPage_Button.setOnAction(e -> {
            try {
                fileController.handleDraftPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(WBDK_DataView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mlbPage_Button.setOnAction(e -> {
            try {
                fileController.handleMLBPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(WBDK_DataView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyTeamsPage_Button.setOnAction(e -> {
            try {
                fileController.handleFantasyTeamsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(WBDK_DataView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyStandingsPage_Button.setOnAction(e -> {
            try {
                fileController.handleFantasyStandingsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(WBDK_DataView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        playersPage_Button.setOnAction(e -> {
            try {
                fileController.handlePlayersPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(WBDK_DataView.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        //System.out.println("Inside initBOTTOMNAVBAR" );
        draftPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.MONEY_ICON, WBDK_PropertyType.DRAFT_PAGE_TOOLTIP, false);
        mlbPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.STAR_ICON, WBDK_PropertyType.MLB_PAGE_TOOLTIP, false);
        fantasyTeamsPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.BASEBALL_ICON, WBDK_PropertyType.FANTASY_TEAMS_PAGE_TOOLTIP, false);
        fantasyStandingsPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.CROWN_ICON, WBDK_PropertyType.FANTASY_STANDINGS_PAGE_TOOLTIP, false);
        playersPage_Button = initChildButton(bottomToolbarPane, WBDK_PropertyType.PAWN_ICON, WBDK_PropertyType.PLAYER_PAGE_TOOLTIP, false);
    
    }
    
    // INIT A LABEL AND PUT IT IN A TOOLBAR
    public Label initChildLabel(Pane container, WBDK_PropertyType labelProperty, String styleClass) {
        Label label = initLabel(labelProperty, styleClass);
        container.getChildren().add(label);
        return label;
    }
    // INIT A LABEL AND SET IT'S STYLESHEET CLASS
    public Label initLabel(WBDK_PropertyType labelProperty, String styleClass) {
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String labelText = props.getProperty(labelProperty);
        Label label = new Label(labelText);
        label.getStyleClass().add(styleClass);
        return label;
    }
    // INIT A TEXT FIELD AND PUT IT IN A GridPane
    public TextField initGridTextField(GridPane container, int size, String initText, boolean editable, int col, int row, int colSpan, int rowSpan) {
        TextField tf = new TextField();
        tf.setPrefColumnCount(size);
        tf.setText(initText);
        tf.setEditable(editable);
        container.add(tf, col, row, colSpan, rowSpan);
        return tf;
    }
     // INIT A LABEL AND PLACE IT IN A GridPane INIT ITS PROPER PLACE
    public Label initGridLabel(GridPane container, WBDK_PropertyType labelProperty, String styleClass, int col, int row, int colSpan, int rowSpan) {
        Label label = initLabel(labelProperty, styleClass);
        container.add(label, col, row, colSpan, rowSpan);
        return label;
    }
    // INIT A CheckBox AND PUT IT IN A TOOLBAR
    public RadioButton initChildRadioButton(Pane container, String text, ToggleGroup group) {
        RadioButton cB = new RadioButton(text);
        cB.setToggleGroup(group);
        cB.setUserData(text);
        container.getChildren().add(cB);
        return cB;
    }
    // INIT A COMBO BOX AND PUT IT IN A GridPane
    public ComboBox initGridComboBox(GridPane container, int col, int row, int colSpan, int rowSpan) throws IOException {
        ComboBox comboBox = new ComboBox();
        container.add(comboBox, col, row, colSpan, rowSpan);
        return comboBox;
    }
    
    ////////////////////////////////////////////////////////////
   
}
