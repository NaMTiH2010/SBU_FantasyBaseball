/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.WBDK_PropertyType;
import WBDK.controller.FantasyTeamsEditController;
import WBDK.controller.FileController;
import WBDK.controller.PlayersEditController;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import WBDK.data.WBDK_DataManager;
import WBDK.data.WBDK_DataView;
import static WBDK.data.WBDK_DataView.CLASS_BORDERED_PANE;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_SUBHEADING_LABEL;
import WBDK.file.WBDK_FileManager;
import WBDK.file.WBDK_SiteExporter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class FantasyTeams_GUI extends WBDK_DataView {
    Button addTeamButton;
    Button removeTeamButton;
    Button editTeamButton;
    TextField draftNameTextbox;
    Label draftTextboxLabel;
    Label startingLineUpLabel;
    Label taxiSquadLabel;
    Label teamsComboBoxLabel;
    ComboBox teamsDropDown;
    GridPane topGridPane;
    GridPane topGridPane2; 
    
    // for creating a our Table in Players page
    TableView<Player> startingLineUpTable;
    TableView<Player> taxiSquadTable;
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
    TableColumn setPositionColumn;
    FantasyTeamsEditController teamsController;
    
    public FantasyTeams_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
        super(initPrimaryStage, initSecondaryStage);
    }

    public void initGUI(String windowTitle,Draft draft) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        
        
        initBottomNavbar();
        
        // INIT THE TOOLBAR
        initFileToolbar(false);

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        initWorkspace(draft);
        initFantasyTeamsTablesTable();
        

        // NOW SETUP THE EVENT HANDLERS
        initEventHandlers(draft);

        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(windowTitle,1);
    }
    @Override
    public void initGUI(String windowTitle) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        
        
        initBottomNavbar();
        
        // INIT THE TOOLBAR
        initFileToolbar(false);

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        initWorkspace();
        initFantasyTeamsTablesTable();
        

        // NOW SETUP THE EVENT HANDLERS
        initEventHandlers();

        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(windowTitle,1);
    }
    @Override
    public void initWorkspace() throws IOException {
        // THE WORKSPACE HAS A FEW REGIONS, THIS 
        // IS FOR BASIC COURSE EDITING CONTROLS
      
// THE TOP WORKSPACE HOLDS BOTH THE BASIC COURSE INFO
        // CONTROLS AS WELL AS THE PAGE SELECTION CONTROLS
        
        initTopWorkspace();

        // THIS HOLDS ALL OUR WORKSPACE COMPONENTS, SO NOW WE MUST
        // ADD THE COMPONENTS WE'VE JUST INITIALIZED
        workspacePane = new BorderPane();
        workspacePane.setTop(topWorkspacePane);
        //workspacePane.setCenter();
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
    public void initWorkspace(Draft draft) throws IOException {
        // THE WORKSPACE HAS A FEW REGIONS, THIS 
        // IS FOR BASIC COURSE EDITING CONTROLS
      
// THE TOP WORKSPACE HOLDS BOTH THE BASIC COURSE INFO
        // CONTROLS AS WELL AS THE PAGE SELECTION CONTROLS
        
        initTopWorkspace(draft);

        // THIS HOLDS ALL OUR WORKSPACE COMPONENTS, SO NOW WE MUST
        // ADD THE COMPONENTS WE'VE JUST INITIALIZED
        workspacePane = new BorderPane();
        workspacePane.setTop(topWorkspacePane);
        //workspacePane.setCenter();
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
    
    private void initTopWorkspace() throws IOException {
        topWorkspacePane = new VBox();
        HBox topWorkspaceH1Pane = new HBox();
        HBox topWorkspaceH2Pane = new HBox();
        topGridPane = new GridPane();
        topGridPane2 = new GridPane();
        
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.FANTASY_TEAMS_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        
        
        
        addTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.ADD_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, false);
        removeTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.MINUS_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, false);
        editTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.EDIT_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, false);
        draftTextboxLabel = initGridLabel(topGridPane, WBDK_PropertyType.DRAFT_NAME_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1);
        teamsComboBoxLabel = initGridLabel(topGridPane2, WBDK_PropertyType.SELECT_FANTASY_TEAM_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1); 
        draftNameTextbox = initGridTextField(topGridPane, 30, "", true, 3, 1, 1, 1);
        teamsDropDown = initGridComboBox(topGridPane2, 1, 1, 1, 1);
        teamsDropDown.setValue(getDataManager().getDraft().getDefaultTeam());
        topWorkspaceH1Pane.getChildren().add(topGridPane2);
        teamsDropDown.setItems(getDataManager().getDraft().getTeams());
        
        topWorkspacePane.getChildren().add(topGridPane);
        topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(topWorkspaceH2Pane);
        
        draftNameTextbox.textProperty().addListener((observable, oldValue, newValue) -> {
            //newValue
            System.out.println("THE NEW VALUE IS:  "+newValue);
            dataManager.getDraft().setTitle(newValue);
        });
        
       
    }
    private void initTopWorkspace(Draft draft) throws IOException {
        topWorkspacePane = new VBox();
        HBox topWorkspaceH1Pane = new HBox();
        HBox topWorkspaceH2Pane = new HBox();
        topGridPane = new GridPane();
        topGridPane2 = new GridPane();
        
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.FANTASY_TEAMS_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        
        
        
        addTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.ADD_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, false);
        removeTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.MINUS_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, false);
        editTeamButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.EDIT_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, false);
        draftTextboxLabel = initGridLabel(topGridPane, WBDK_PropertyType.DRAFT_NAME_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1);
        teamsComboBoxLabel = initGridLabel(topGridPane2, WBDK_PropertyType.SELECT_FANTASY_TEAM_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1); 
        draftNameTextbox = initGridTextField(topGridPane, 30, "", true, 3, 1, 1, 1);
        teamsDropDown = initGridComboBox(topGridPane2, 1, 1, 1, 1);
        teamsDropDown.setValue(draft.getDefaultTeam());
        topWorkspaceH1Pane.getChildren().add(topGridPane2);
        teamsDropDown.setItems(draft.getTeams());
        
        topWorkspacePane.getChildren().add(topGridPane);
        topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(topWorkspaceH2Pane);
        
        draftNameTextbox.textProperty().addListener((observable, oldValue, newValue) -> {
            //newValue
            System.out.println("THE NEW VALUE IS:  "+newValue);
            dataManager.getDraft().setTitle(newValue);
        });
        
       
    }
    
    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
        private void initFantasyTeamsTablesTable(){
        // SET UP TABLE
        startingLineUpTable = new TableView();
        taxiSquadTable = new TableView();
        
        // SET UP COLUMNS
        setPositionColumn = new TableColumn("Position");
        
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
        setPositionColumn.setCellValueFactory(new PropertyValueFactory<String, String>("currentPosition"));
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
        startingLineUpTable.getColumns().add(setPositionColumn); 
        startingLineUpTable.getColumns().add(firstNameColumn);
        startingLineUpTable.getColumns().add(lastNameColumn);
        startingLineUpTable.getColumns().add(proTeamColumn);
        startingLineUpTable.getColumns().add(positionsColumn);
        startingLineUpTable.getColumns().add(yearOfBirthColumn);
        startingLineUpTable.getColumns().add(r_w_Column);
        startingLineUpTable.getColumns().add(hr_sv_Column);
        startingLineUpTable.getColumns().add(rbi_k_Column);
        startingLineUpTable.getColumns().add(sb_era_Column);
        startingLineUpTable.getColumns().add(ba_whip_Column);
        startingLineUpTable.getColumns().add(estimatedValueColumn);
        startingLineUpTable.getColumns().add(notesColumn);
        
         //getPlayers());
         startingLineUpLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.STARTING_LINEUP_LABEL, CLASS_SUBHEADING_LABEL);
         startingLineUpTable.setItems(((Team)teamsDropDown.getSelectionModel().getSelectedItem()).getStartingLineup());
         topWorkspacePane.getChildren().add(startingLineUpTable); 
         taxiSquadLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.TAXI_SQUAD_LABEL, CLASS_SUBHEADING_LABEL);
         
         teamsDropDown.setOnAction((event) -> {
             startingLineUpTable.setItems(((Team)teamsDropDown.getSelectionModel().getSelectedItem()).getStartingLineup());
            });
       
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

        // FIRST THE FILE CONTROLS
        fileController = new FileController(messageDialog, yesNoCancelDialog, fileManager, siteExporter);
        teamsController = new FantasyTeamsEditController(primaryStage, dataManager.getDraft(), messageDialog, yesNoCancelDialog);
        
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
        
        addTeamButton.setOnAction(e -> {
            teamsController.handleAddTeamRequest(this);
            //reloadDraft(getDataManager().getDraft());
        });
        removeTeamButton.setOnAction(e -> {
            fileController.handleRemoveTeamRequest(this);
        });
        
        // BOTTOMTOOLBAR
        draftPage_Button.setOnAction(e -> {
            try {
                getDataManager().getDraft().setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleDraftPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mlbPage_Button.setOnAction(e -> {
            try {
                getDataManager().getDraft().setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                
                fileController.handleMLBPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyTeamsPage_Button.setOnAction(e -> {
            try {
                getDataManager().getDraft().setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleFantasyTeamsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyStandingsPage_Button.setOnAction(e -> {
            try {
                getDataManager().getDraft().setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleFantasyStandingsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        playersPage_Button.setOnAction(e -> {
            try {
                getDataManager().getDraft().setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
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
        /*
        // AND NOW THE SCHEDULE ITEMS TABLE
        startingLineUpTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                //TablePosition tp;
                 //OPEN UP THE PLAYER EDITOR
                //tp = playersTable.getFocusModel().getFocusedCell();
                
                
                Player si = startingLineUpTable.getSelectionModel().getSelectedItem();
               // System.out.println("ANSWER IS: "+tp.getTableColumn().getId());
                playersController = new PlayersEditController(primaryStage, dataManager.getDraft(), messageDialog, yesNoCancelDialog);
                playersController.handleEditPlayerItemRequest(this, si);
                //System.out.println("scheduleItems = "+ si.getDescription());
            }
        }); */

        
        //registerTextFieldController(searchBar);
        
    }
         // INIT ALL THE EVENT HANDLERS
    public void initEventHandlers(Draft draft) throws IOException {
        /*
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            //newValue
            System.out.println("THE NEW VALUE IS:  "+newValue);
            dataManager.getDraft().searchIT(newValue);
        });*/

        // FIRST THE FILE CONTROLS
        fileController = new FileController(messageDialog, yesNoCancelDialog, fileManager, siteExporter);
        teamsController = new FantasyTeamsEditController(primaryStage, draft, messageDialog, yesNoCancelDialog);
        
        newDraftButton.setOnAction(e -> {
            fileController.handleNewDraftRequest(this);
        });
        
        loadDraftButton.setOnAction(e -> {
            fileController.handleLoadDraftRequest(this);
        });
        saveDraftButton.setOnAction(e -> {
            fileController.handleSaveDraftRequest(this, draft);
        });/*
        exportSiteButton.setOnAction(e -> {
            fileController.handleExportDraftRequest(this,secondaryStage);
        }); 
        */
        exitButton.setOnAction(e -> {
            fileController.handleExitRequest(this);
        });
        
        addTeamButton.setOnAction(e -> {
            teamsController.handleAddTeamRequest(this);
            //reloadDraft(getDataManager().getDraft());
        });
        removeTeamButton.setOnAction(e -> {
            fileController.handleRemoveTeamRequest(this);
        });
        
        // BOTTOMTOOLBAR
        draftPage_Button.setOnAction(e -> {
            try {
                draft.setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleDraftPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mlbPage_Button.setOnAction(e -> {
            try {
                draft.setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                
                fileController.handleMLBPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyTeamsPage_Button.setOnAction(e -> {
            try {
                draft.setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleFantasyTeamsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fantasyStandingsPage_Button.setOnAction(e -> {
            try {
                draft.setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
                fileController.handleFantasyStandingsPageRequest(this);
            } catch (IOException ex) {
                Logger.getLogger(PlayersPage_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        playersPage_Button.setOnAction(e -> {
            try {
                draft.setDefaultTeam((Team) teamsDropDown.getSelectionModel().getSelectedItem());
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
        /*
        // AND NOW THE SCHEDULE ITEMS TABLE
        startingLineUpTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                //TablePosition tp;
                 //OPEN UP THE PLAYER EDITOR
                //tp = playersTable.getFocusModel().getFocusedCell();
                
                
                Player si = startingLineUpTable.getSelectionModel().getSelectedItem();
               // System.out.println("ANSWER IS: "+tp.getTableColumn().getId());
                playersController = new PlayersEditController(primaryStage, dataManager.getDraft(), messageDialog, yesNoCancelDialog);
                playersController.handleEditPlayerItemRequest(this, si);
                //System.out.println("scheduleItems = "+ si.getDescription());
            }
        }); */

        
        //registerTextFieldController(searchBar);
        
    }
    
    public Player getSelectedPlayerFromTable(){
        return (Player)startingLineUpTable.getSelectionModel().getSelectedItem();
    }
    public Team getSelectedTeam(){
        return (Team) teamsDropDown.getSelectionModel().getSelectedItem();
    }
}
