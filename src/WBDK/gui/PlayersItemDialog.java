/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.data.Draft;
import WBDK.data.Player;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_PROMPT_LABEL;
import static WBDK.data.WBDK_DataView.PRIMARY_STYLE_SHEET;
import static WBDK.gui.YesNoCancelDialog.CANCEL;
import static java.awt.MediaTracker.COMPLETE;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class PlayersItemDialog extends Stage{
    Player playerItem;
    GridPane gridPane;
    Scene dialogScene;
    Label headingLabel;
    Label descriptionLabel;
    TextField descriptionTextField;
    //Label dateLabel;
    //DatePicker datePicker;
    //Label urlLabel;
    //TextField urlTextField;
    Button completeButton;
    Button cancelButton;
    
    String selection;
    public static final String ADD_SCHEDULE_ITEM_TITLE = "Add New Schedule Item";
    
    public PlayersItemDialog(Stage primaryStage, Draft draft, MessageDialog messageDialog) {
     // MAKE THIS DIALOG MODAL, MEANING OTHERS WILL WAIT
        // FOR IT WHEN IT IS DISPLAYED
        initModality(Modality.WINDOW_MODAL);
        initOwner(primaryStage);
        
        // FIRST OUR CONTAINER
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // PUT THE HEADING IN THE GRID, NOTE THAT THE TEXT WILL DEPEND
        // ON WHETHER WE'RE ADDING OR EDITING
        headingLabel = new Label("NOTES");
        headingLabel.getStyleClass().add(CLASS_HEADING_LABEL);
    
        // NOW THE DESCRIPTION 
        descriptionLabel = new Label("Notes: ");
        descriptionLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        descriptionTextField = new TextField();
        descriptionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //StringProperty temp = null;
           // temp.set(newValue);
            playerItem.setNotes(newValue);
        });
        
        
        // AND FINALLY, THE BUTTONS
        completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            PlayersItemDialog.this.selection = sourceButton.getText();
            PlayersItemDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);

        // NOW LET'S ARRANGE THEM ALL AT ONCE
        gridPane.add(headingLabel, 0, 0, 2, 1);
        gridPane.add(descriptionLabel, 0, 1, 1, 1);
        gridPane.add(descriptionTextField, 1, 1, 1, 1);
        gridPane.add(completeButton, 0, 4, 1, 1);
        gridPane.add(cancelButton, 1, 4, 1, 1);

        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
    }

    public Player showEditPlayerItemDialog(Player itemToEdit) {
        // SET THE DIALOG TITLE
        setTitle(ADD_SCHEDULE_ITEM_TITLE);
        
        // RESET THE SCHEDULE ITEM OBJECT WITH DEFAULT VALUES
        playerItem = new Player();
        
        // LOAD THE UI STUFF
        descriptionTextField.setText(playerItem.notesProperty().toString());
        
        
        // AND OPEN IT UP
        this.showAndWait();
        
        return playerItem;
    }

    public boolean wasCompleteSelected() {
        return selection.equals(COMPLETE);
    }

    public Player getPlayerItem() {
        return playerItem;
    }
    
}
