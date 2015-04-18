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
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
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
    
    public PlayersPage_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
        super(initPrimaryStage, initSecondaryStage);
    }
    
    @Override
    public void initGUI(String windowTitle, ArrayList<String> subjects) throws IOException {
        // INIT THE DIALOGS
        initDialogs();
        
        // INIT THE TOOLBAR
        initFileToolbar();

        // INIT THE CENTER WORKSPACE CONTROLS BUT DON'T ADD THEM
        // TO THE WINDOW YET
        this.initWorkspace(subjects);
        
        initBottomNavbar();

        // NOW SETUP THE EVENT HANDLERS
        initEventHandlers();

        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(windowTitle,1);
    }
    
    // CREATES AND SETS UP ALL THE CONTROLS TO GO IN THE APP WORKSPACE
    private void initWorkspace(ArrayList<String> subjects) throws IOException {
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

    // INITIALIZES THE TOP PORTION OF THE WORKWPACE UI
    private void initTopWorkspace() {
       
        // THE TOP WORKSPACE PANE WILL ONLY DIRECTLY HOLD 2 THINGS, A LABEL
        // AND A SPLIT PANE, WHICH WILL HOLD 2 ADDITIONAL GROUPS OF CONTROLS
        topGridPane = new GridPane();
        topWorkspacePane = new VBox();
        topWorkspaceH1Pane = new HBox();
        topWorkspaceH2Pane = new HBox();
        radioButtonHPane = new HBox();
        topWorkspacePane.getStyleClass().add(CLASS_BORDERED_PANE);

        // HERE'S THE LABEL
        draftHeadingLabel = initChildLabel(topWorkspaceH1Pane, WBDK_PropertyType.COURSE_HEADING_LABEL, CLASS_HEADING_LABEL);
        add_Button = initChildButton(topWorkspaceH2Pane, WBDK_PropertyType.ADD_ICON, WBDK_PropertyType.NEW_COURSE_TOOLTIP, true);
        remove_Button = initChildButton(topWorkspaceH2Pane, WBDK_PropertyType.MINUS_ICON, WBDK_PropertyType.LOAD_COURSE_TOOLTIP, true);
        searchBar = initGridTextField(topGridPane, 60, "", true, 3, 1, 1, 1);
        searchLabel =  initGridLabel(topGridPane, WBDK_PropertyType.ENDING_FRIDAY_LABEL, CLASS_PROMPT_LABEL, 0, 1, 1, 1);
        topWorkspaceH2Pane.getChildren().add(topGridPane);
        all = initChildRadioButton(radioButtonHPane,"All  ");
        catchers = initChildRadioButton(radioButtonHPane,"C  ");
        firstBaseman = initChildRadioButton(radioButtonHPane,"1B  ");
        ci = initChildRadioButton(radioButtonHPane,"CI  ");
        thirdBase = initChildRadioButton(radioButtonHPane,"3B  ");
        secondBase = initChildRadioButton(radioButtonHPane,"2B  ");
        mi = initChildRadioButton(radioButtonHPane,"MI  ");
        shortstop = initChildRadioButton(radioButtonHPane,"SS  ");
        of = initChildRadioButton(radioButtonHPane,"OF  ");
        u = initChildRadioButton(radioButtonHPane,"U  ");
        pitchers = initChildRadioButton(radioButtonHPane,"P  ");
        topWorkspacePane.getChildren().add(topWorkspaceH1Pane);
        topWorkspacePane.getChildren().add(topWorkspaceH2Pane);
        topWorkspacePane.getChildren().add(radioButtonHPane);

    }
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
    }

    public void reloadDraft(Draft draft) {
        if (!workspaceActivated) {
            activateWorkspace();
        }
        
    }
    // INIT A TEXT FIELD AND PUT IT IN A GridPane
    private TextField initGridTextField(GridPane container, int size, String initText, boolean editable, int col, int row, int colSpan, int rowSpan) {
        TextField tf = new TextField();
        tf.setPrefColumnCount(size);
        tf.setText(initText);
        tf.setEditable(editable);
        container.add(tf, col, row, colSpan, rowSpan);
        return tf;
    }
     // INIT A LABEL AND PLACE IT IN A GridPane INIT ITS PROPER PLACE
    private Label initGridLabel(GridPane container, WBDK_PropertyType labelProperty, String styleClass, int col, int row, int colSpan, int rowSpan) {
        Label label = initLabel(labelProperty, styleClass);
        container.add(label, col, row, colSpan, rowSpan);
        return label;
    }
    // INIT A CheckBox AND PUT IT IN A TOOLBAR
    private RadioButton initChildRadioButton(Pane container, String text) {
        RadioButton cB = new RadioButton(text);
        container.getChildren().add(cB);
        return cB;
    }
}
