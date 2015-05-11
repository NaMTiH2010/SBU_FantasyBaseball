/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.WBDK_PropertyType;
import WBDK.data.Draft;
import WBDK.data.MLB_Team;
import WBDK.data.Player;
import WBDK.data.WBDK_DataView;
import static WBDK.data.WBDK_DataView.CLASS_BORDERED_PANE;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class MLB_GUI extends WBDK_DataView {
    TableColumn firstNameCol;
    TableColumn lastNameCol;
    TableColumn positionsCol;
    TableView<Player> mlbTable;
    Label selectTeamLabel;
    ComboBox mlb_comboBox;
    ObservableList<Player> mlbProTeamList;
    
    public MLB_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
        super(initPrimaryStage, initSecondaryStage);
        mlbProTeamList = FXCollections.observableArrayList();
        
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
        HBox topWorkspaceH1Pane = new HBox();
        selectTeamLabel = new Label("Select Pro Team: ");
        mlb_comboBox = new ComboBox();
        firstNameCol = new TableColumn("First");
        lastNameCol = new TableColumn("Last");
        positionsCol = new TableColumn("Positions");
        mlbTable = new TableView(); 
       
        ObservableList<String> teamChoices = FXCollections.observableArrayList();
        for (MLB_Team s : MLB_Team.values()) {
            teamChoices.add(s.toString());
        }
        mlb_comboBox.setItems(teamChoices);
        mlb_comboBox.setValue(teamChoices.get(0));
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory<String, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<String, String>("lastName"));
        positionsCol.setCellValueFactory(new PropertyValueFactory<String, String>("qp"));
        mlbTable.getColumns().add(firstNameCol);
        mlbTable.getColumns().add(lastNameCol);
        mlbTable.getColumns().add(positionsCol);
        
        mlbProTeamList.clear();
        for(int i =0; i < getDataManager().getDraft().getPlayers().size();i++){
            if(getDataManager().getDraft().getPlayers().get(i).getTeam().equalsIgnoreCase("atl"))
                mlbProTeamList.add(getDataManager().getDraft().getPlayers().get(i));
        }
        //FilteredList<Player> filteredData = new FilteredList<>(mlbProTeamList, p -> true);
        //SortedList<Player> sortedData = new SortedList<>(filteredData);
        //sortedData.comparatorProperty().bind(mlbTable.comparatorProperty());
        //mlbTable.setItems(sortedData);
        
        mlbProTeamList.sort(null);
        mlbTable.setItems(mlbProTeamList);
        
        mlb_comboBox.setOnAction((event) -> {
            System.out.print(mlb_comboBox.getSelectionModel().getSelectedItem().toString());
            mlbProTeamList.clear();
            for(int i =0; i < getDataManager().getDraft().getPlayers().size();i++){
                if(getDataManager().getDraft().getPlayers().get(i).getTeam().equalsIgnoreCase(
                        mlb_comboBox.getSelectionModel().getSelectedItem().toString()))
                    mlbProTeamList.add(getDataManager().getDraft().getPlayers().get(i));
            }
            mlbProTeamList.sort(null);
            });
                
        //VBox topWorkspaceV1Pane = new VBox();
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.MLB_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        topWorkspaceH1Pane.getChildren().add(selectTeamLabel);
        topWorkspaceH1Pane.getChildren().add(mlb_comboBox);
        topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(mlbTable);
    }
    @Override
    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
    
}
