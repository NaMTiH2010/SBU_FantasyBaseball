/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.WBDK_PropertyType;
import WBDK.data.Draft;
import WBDK.data.WBDK_DataView;
import static WBDK.data.WBDK_DataView.CLASS_BORDERED_PANE;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import java.io.IOException;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class Draft_GUI extends WBDK_DataView {
    Button playButton;
    Button pauseButton;
    Button starButton;
    TableView draftListTable;
    TableColumn pickNumber;
    TableColumn first;
    TableColumn last;
    TableColumn team;
    TableColumn contract;
    TableColumn salary;
    
    public Draft_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
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
        initWorkspace();
        
        

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
    
    private void initTopWorkspace() {
        topWorkspacePane = new VBox();
        //HBox topWorkspaceH1Pane = new HBox();
        TilePane topWorkspaceH1Pane = new TilePane(Orientation.HORIZONTAL);
        topWorkspaceH1Pane.setHgap(1);
        //topWorkspaceH1Pane.se
        //topWorkspaceH1Pane
        playButton = new Button();
        pauseButton = new Button();
        starButton = new Button();
        
        
        
        starButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.FILLEDSTAR_ICON, WBDK_PropertyType.NEW_DRAFT_TOOLTIP, false);
        playButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.PLAY_ICON, WBDK_PropertyType.NEW_DRAFT_TOOLTIP, false);
        pauseButton = initChildButton(topWorkspaceH1Pane, WBDK_PropertyType.PAUSE_ICON, WBDK_PropertyType.NEW_DRAFT_TOOLTIP, false);
        
        draftListTable = new TableView();
        pickNumber = new TableColumn("Pick#");
        first = new TableColumn("First Name");
        last = new TableColumn("Last Name");
        team = new TableColumn("Team");
        contract = new TableColumn("Contract");
        salary = new TableColumn("Salary ($)");
        
        team.setCellValueFactory(new PropertyValueFactory<String, String>("fantasyTeam"));
        first.setCellValueFactory(new PropertyValueFactory<String, String>("firstName"));
        last.setCellValueFactory(new PropertyValueFactory<String, String>("lastName"));
        contract.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("contractStatus"));
        salary.setCellValueFactory(new PropertyValueFactory<String, String>("salary"));
        
        draftListTable.getColumns().add(pickNumber);
        draftListTable.getColumns().add(first);
        draftListTable.getColumns().add(last);
        draftListTable.getColumns().add(team);
        draftListTable.getColumns().add(contract);
        draftListTable.getColumns().add(salary);
        
       // topWorkspaceH1Pane.getChildren().add(starButton);
        //topWorkspaceH1Pane.getChildren().add(playButton);
        //topWorkspaceH1Pane.getChildren().add(pauseButton);
        
        
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.DRAFT_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(draftListTable);
        
    }
    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
}
