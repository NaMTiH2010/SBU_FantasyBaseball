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
public class FantasyStandings_GUI extends WBDK_DataView {
    TableView fantStandTable;
    TableColumn teamNameColumn;
    TableColumn playersNeededColumn;
    TableColumn moneyLeftColumn;
    TableColumn costPerPlayerColumn;
    TableColumn r_Column;
    TableColumn hr_Column;
    TableColumn rbi_Column;
    TableColumn sb_Column;
    TableColumn ba_Column;
    TableColumn w_Column;
    TableColumn sv_Column;
    TableColumn k_Column;
    TableColumn era_Column;
    TableColumn whip_Column;
    TableColumn totalPointsColumn;
    public FantasyStandings_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
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
        
        if(getDataManager().getDraft().getTeams().size() != 0){
            for(int i =0; i < getDataManager().getDraft().getTeams().size();i++){
                getDataManager().getDraft().getTeams().get(i).computeTotals();
                System.out.println("WORKING INITTTOP");
            }
        }
        topWorkspacePane = new VBox();
        HBox topWorkspaceH1Pane = new HBox();
        
        fantStandTable = new TableView();
        
        teamNameColumn = new TableColumn("Team Name");
        playersNeededColumn = new TableColumn("Players Needed");
        moneyLeftColumn = new TableColumn("($)Left");
        costPerPlayerColumn = new TableColumn("($)PP");
        r_Column = new TableColumn("R");
        hr_Column = new TableColumn("HR");
        rbi_Column = new TableColumn("RBI");
        sb_Column = new TableColumn("SB");
        ba_Column = new TableColumn("BA");
        w_Column = new TableColumn("W");
        sv_Column = new TableColumn("SV");
        k_Column = new TableColumn("K");
        era_Column = new TableColumn("ERA");
        whip_Column = new TableColumn("WHIP");
        totalPointsColumn = new TableColumn("Total Points");
        
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        playersNeededColumn.setCellValueFactory(new PropertyValueFactory<>("numPlayersNeeded"));
        moneyLeftColumn.setCellValueFactory(new PropertyValueFactory<>("moneyLeft"));
        costPerPlayerColumn.setCellValueFactory(new PropertyValueFactory<>("costPP"));
        r_Column.setCellValueFactory(new PropertyValueFactory<>("total_R"));
        hr_Column.setCellValueFactory(new PropertyValueFactory<>("total_HR"));
        rbi_Column.setCellValueFactory(new PropertyValueFactory<>("total_RBI"));
        sb_Column.setCellValueFactory(new PropertyValueFactory<>("total_SB"));
        ba_Column.setCellValueFactory(new PropertyValueFactory<>("total_BA"));
        w_Column.setCellValueFactory(new PropertyValueFactory<>("total_W"));
        sv_Column.setCellValueFactory(new PropertyValueFactory<>("total_SV"));
        k_Column.setCellValueFactory(new PropertyValueFactory<>("total_K"));
        era_Column.setCellValueFactory(new PropertyValueFactory<>("total_ERA"));
        whip_Column.setCellValueFactory(new PropertyValueFactory<>("total_WHIP"));
        totalPointsColumn.setCellValueFactory(new PropertyValueFactory<String, String>("totalPoints"));
        
        
        fantStandTable.getColumns().add(teamNameColumn);
        fantStandTable.getColumns().add(playersNeededColumn);
        fantStandTable.getColumns().add(moneyLeftColumn);
        fantStandTable.getColumns().add(costPerPlayerColumn);
        fantStandTable.getColumns().add(r_Column);
        fantStandTable.getColumns().add(hr_Column);
        fantStandTable.getColumns().add(rbi_Column);
        fantStandTable.getColumns().add(sb_Column);
        fantStandTable.getColumns().add(ba_Column);
        fantStandTable.getColumns().add(w_Column);
        fantStandTable.getColumns().add(sv_Column);
        fantStandTable.getColumns().add(k_Column);
        fantStandTable.getColumns().add(era_Column);
        fantStandTable.getColumns().add(whip_Column);
        fantStandTable.getColumns().add(totalPointsColumn);
        
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);
        draftHeadingLabel = initChildLabel(topWorkspacePane, WBDK_PropertyType.FANTASY_STANDINGS_PAGE_HEADING_LABEL, CLASS_HEADING_LABEL);
        topWorkspacePane.getChildren().add(fantStandTable);
        fantStandTable.setItems(getDataManager().getDraft().getTeams());
    }
    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
}
