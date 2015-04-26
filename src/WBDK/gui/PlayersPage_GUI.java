/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.WBDK_PropertyType;
import WBDK.controller.FileController;
import WBDK.controller.PlayersEditController;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Players;
import WBDK.data.WBDK_DataView;
import static WBDK.data.WBDK_DataView.CLASS_BORDERED_PANE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class PlayersPage_GUI extends WBDK_DataView {
    // THESE ARE THE CONTROLS FOR THE BASIC SCHEDULE PAGE HEADER INFO
    
    final ToggleGroup group = new ToggleGroup();
    GridPane playersInfoPane;
    Label playersInfoLabel;
    Button add_Button;
    Button remove_Button;
    TextField searchBar;
    Label searchLabel;
    HBox topWorkspaceH1Pane;
    HBox topWorkspaceH2Pane;
    HBox radioButtonHPane;
    RadioButton firstBaseman;
    RadioButton all;
    RadioButton pitchers;
    RadioButton catchers;
    RadioButton secondBase;
    RadioButton thirdBase;
    RadioButton shortstop;
    RadioButton of;
    RadioButton u;
    RadioButton mi;
    RadioButton ci;
    GridPane topGridPane;
   
    // for creating a our Table in Players page
        TableView<Player> playersTable;
        TableColumn firstNameColumn;
        TableColumn positions;
        TableColumn lastNameColumn;
        TableColumn proTeamColumn;
        TableColumn positionsColumn;
        TableColumn yearOfBirthColumn;
        TableColumn r_w_Column;
        TableColumn hr_sv_Column;
        TableColumn rbi_k_Column;
        TableColumn sb_era_Column;
        TableColumn ba_whip_Column;
        TableColumn estimatedValueColumn;
        TableColumn notesColumn;
        
        static final String COL_TEAM_NAME = "Team";
        
        PlayersEditController playerController;
        
        
    
    public PlayersPage_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
        super(initPrimaryStage, initSecondaryStage);
    }
    
    @Override
    public void initGUI(String windowTitle) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        initBottomNavbar();
        
        // INIT THE TOOLBAR
        initFileToolbar();

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        this.initWorkspace();
        
        

        // NOW SETUP THE EVENT HANDLERS
        initEventHandlers();

        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(windowTitle,1);
    }
    
    // CREATES AND SETS UP ALL THE CONTROLS TO GO IN THE APP WORKSPACE
    @Override
    public void initWorkspace() throws IOException {
        // THE WORKSPACE HAS A FEW REGIONS, THIS 
        // IS FOR BASIC COURSE EDITING CONTROLS
      
// THE TOP WORKSPACE HOLDS BOTH THE BASIC COURSE INFO
        // CONTROLS AS WELL AS THE PAGE SELECTION CONTROLS
        
        initTopWorkspace();
        
        // CREATE TABLE FOR PLAYERS
        initPlayerTable();
        
        // THIS HOLDS ALL OUR WORKSPACE COMPONENTS, SO NOW WE MUST
        // ADD THE COMPONENTS WE'VE JUST INITIALIZED
        workspacePane = new BorderPane();
        workspacePane.setTop(topWorkspacePane);
        workspacePane.setCenter(playersTable);
        workspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        
        // AND NOW PUT IT IN THE WORKSPACE
        workspaceScrollPane = new ScrollPane();
        workspaceScrollPane.getStyleClass().add(CLASS_BORDERED_PANE);
        workspaceScrollPane.setContent(workspacePane);
        workspaceScrollPane.setFitToWidth(true);

        // NOTE THAT WE HAVE NOT PUT THE WORKSPACE INTO THE WINDOW,
        // THAT WILL BE DONE WHEN THE USER EITHER CREATES A NEW
        // COURSE OR LOADS AN EXISTING ONE FOR EDITING
        workspaceActivated = false;
    }

    // INITIALIZES THE TOP PORTION OF THE WORKWPACE UI
    private void initTopWorkspace() {
       
        // THE TOP WORKSPACE PANE WILL ONLY DIRECTLY HOLD 2 THINGS, A LABEL
        // AND A SPLIT PANE, WHICH WILL HOLD 2 ADDITIONAL GROUPS OF CONTROLS
        topGridPane = new GridPane();
        topWorkspacePane = new VBox();
        //topWorkspaceH1Pane = new HBox();
        topWorkspaceH2Pane = new HBox();
        radioButtonHPane = new HBox();
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        

        // HERE'S THE LABEL
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.PLAYERS_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        add_Button = initChildButton(topWorkspaceH2Pane, WBDK_PropertyType.ADD_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, true);
        remove_Button = initChildButton(topWorkspaceH2Pane, WBDK_PropertyType.MINUS_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, true);
        searchBar = initGridTextField(topGridPane, 60, "", true, 3, 1, 1, 1);
        searchLabel =  initGridLabel(topGridPane, WBDK_PropertyType.SEARCH_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1);
        topWorkspaceH2Pane.getChildren().add(topGridPane);
        all = initChildRadioButton(radioButtonHPane,"All  ", group);
        catchers = initChildRadioButton(radioButtonHPane,"C  ", group);
        firstBaseman = initChildRadioButton(radioButtonHPane,"1B  ", group);
        ci = initChildRadioButton(radioButtonHPane,"CI  ", group);
        thirdBase = initChildRadioButton(radioButtonHPane,"3B  ", group);
        secondBase = initChildRadioButton(radioButtonHPane,"2B  ", group);
        mi = initChildRadioButton(radioButtonHPane,"MI  ", group);
        shortstop = initChildRadioButton(radioButtonHPane,"SS  ", group);
        of = initChildRadioButton(radioButtonHPane,"OF  ", group);
        u = initChildRadioButton(radioButtonHPane,"U  ", group);
        pitchers = initChildRadioButton(radioButtonHPane,"P  ", group);
        //topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(topWorkspaceH2Pane);
        topWorkspacePane.getChildren().add(radioButtonHPane);

    }
    /*
    // INIT A LABEL AND PUT IT IN A TOOLBAR
    private Label initChildLabel(Pane container, WBDK_PropertyType labelProperty, String styleClass) {
        Label label = initLabel(labelProperty, styleClass);
        container.getChildren().add(label);
        return label;
    }
    // INIT A LABEL AND SET IT'S STYLESHEET CLASS
    private Label initLabel(WBDK_PropertyType labelProperty, String styleClass) {
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String labelText = props.getProperty(labelProperty);
        Label label = new Label(labelText);
        label.getStyleClass().add(styleClass);
        return label;
    }*/
    
    private void initPlayerTable(){
        // SET UP TABLE
        playersTable = new TableView();
        playersTable.setEditable(true);
        // SET UP COLUMNS
        firstNameColumn = new TableColumn("First");
        lastNameColumn = new TableColumn("Last");
        proTeamColumn = new TableColumn("Pro Team");
        positionsColumn = new TableColumn("Positions");
        yearOfBirthColumn = new TableColumn("Year Of Birth");
        r_w_Column = new TableColumn("R/W");
        hr_sv_Column = new TableColumn("HR/SV");
        rbi_k_Column = new TableColumn("RBI/K");
        sb_era_Column = new TableColumn("SB/ERA");
        ba_whip_Column = new TableColumn("BA/WHIP");
        estimatedValueColumn = new TableColumn("Estimated Value");
        notesColumn = new TableColumn("Notes");
       
        
        // AND LINK THE COLUMNS TO THE DATA
        proTeamColumn.setCellValueFactory(new PropertyValueFactory<String, String>("team"));
        
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("lastName"));
        yearOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("yearOfBirth"));
        positionsColumn.setCellValueFactory(new PropertyValueFactory<String, String>("qp"));
        r_w_Column.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("r_w"));
        hr_sv_Column.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("hr_sv"));
        rbi_k_Column.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("rbi_k"));
        sb_era_Column.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("sb_era"));
        ba_whip_Column.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("ba_whip"));
        //estimatedValueColumn.setCellValueFactory(new PropertyValueFactory<String, String>("estimatedValue"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<String, String>("notes"));
       
        notesColumn.setEditable(true);
        
        
        //playersTable.getOnMouseClicked();
        
        // ADD COLUMNS TO TABLE
        playersTable.getColumns().add(firstNameColumn);
        playersTable.getColumns().add(lastNameColumn);
        playersTable.getColumns().add(proTeamColumn);
        playersTable.getColumns().add(positionsColumn);
        playersTable.getColumns().add(yearOfBirthColumn);
        playersTable.getColumns().add(r_w_Column);
        playersTable.getColumns().add(hr_sv_Column);
        playersTable.getColumns().add(rbi_k_Column);
        playersTable.getColumns().add(sb_era_Column);
        playersTable.getColumns().add(ba_whip_Column);
        playersTable.getColumns().add(estimatedValueColumn);
        playersTable.getColumns().add(notesColumn);
        
        playersTable.setItems(getDataManager().getDraft().getAvailablePlayers()); //getPlayers());
        
    }
    
    
    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
    
    
    // INIT ALL THE EVENT HANDLERS
    @Override
    public void initEventHandlers() throws IOException {
        /*
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            //newValue
            System.out.println("THE NEW VALUE IS:  "+newValue);
            dataManager.getDraft().searchIT(newValue);
        });*/
        // RADIO BUTTONS
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (group.getSelectedToggle() != null) {
            
            updateDraftUsingRadioButton(dataManager.getDraft(),group.getSelectedToggle().getUserData().toString());
          //System.out.println(group.getSelectedToggle().getUserData().toString());
        }
      }
    });
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
        
        add_Button.setOnAction(e -> {
            fileController.handleAddPlayerRequest(this);
        });
        remove_Button.setOnAction(e -> {
            fileController.handleRemovePlayerRequest(this);
        });
        
        // BOTTOMTOOLBAR
        draftPage_Button.setOnAction(e -> {
            try {
                fileController.handleDraftPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mlbPage_Button.setOnAction(e -> {
            try {
                fileController.handleMLBPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyTeamsPage_Button.setOnAction(e -> {
            try {
                fileController.handleFantasyTeamsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyStandingsPage_Button.setOnAction(e -> {
            try {
                fileController.handleFantasyStandingsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        playersPage_Button.setOnAction(e -> {
            try {
                fileController.handlePlayersPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // AND NOW THE NOTES ITEM ADDING AND EDITING CONTROLS
        
       /* addScheduleItemButton.setOnAction(e -> {
            scheduleController.handleAddScheduleItemRequest(this);
        });
        removeScheduleItemButton.setOnAction(e -> {
            scheduleController.handleRemoveScheduleItemRequest(this, scheduleItemsTable.getSelectionModel().getSelectedItem());
        });
        */
       
        //notesColumn.getOnEditStart()
        
        // AND NOW THE SCHEDULE ITEMS TABLE
        playersTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                //TablePosition tp;
                 //OPEN UP THE PLAYER EDITOR
                //tp = playersTable.getFocusModel().getFocusedCell();
                
                
                Player si = playersTable.getSelectionModel().getSelectedItem();
               // System.out.println("ANSWER IS: "+tp.getTableColumn().getId());
                playersController = new PlayersEditController(primaryStage, dataManager.getDraft(), messageDialog, yesNoCancelDialog);
                playersController.handleEditPlayerItemRequest(this, si);
                //System.out.println("scheduleItems = "+ si.getDescription());
            }
        });
        
        notesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        notesColumn.setOnEditCommit(
        new EventHandler<CellEditEvent<Player, String>>() {
        public void handle(CellEditEvent<Player, String> t) {
            ((Player) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setNotes(t.getNewValue());
        }

    }
);
        
        //registerTextFieldController(searchBar);
        
    }
    // REGISTER THE EVENT LISTENER FOR A TEXT FIELD
    private void registerTextFieldController(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            draftController.handleDraftChangeRequest(this);
        });
    }
    
    /**
     * This function loads all the values currently in the user interface
     * into the course argument.
     * 
     * @param course The course to be updated using the data from the UI controls.
     */
    public void updateDraftInfo(Draft theDraft) {
        
        /*
        updateDraftUsingRadioButton(theDraft,all);
        updateDraftUsingRadioButton(theDraft,pitchers);
        updateDraftUsingRadioButton(theDraft,catchers);
        updateDraftUsingRadioButton(theDraft,secondBase);
        updateDraftUsingRadioButton(theDraft,thirdBase);
        updateDraftUsingRadioButton(theDraft,shortstop);
        updateDraftUsingRadioButton(theDraft,of);
        updateDraftUsingRadioButton(theDraft,u);
        updateDraftUsingRadioButton(theDraft,mi);
        updateDraftUsingRadioButton(theDraft,ci);
        updateDraftUsingRadioButton(theDraft,firstBaseman);
                */
        //initPlayerTable();
    }

    private void updateDraftUsingRadioButton(Draft tempDraft, String rb) {
       tempDraft.radioButtonSort(rb);
    }
    
}
