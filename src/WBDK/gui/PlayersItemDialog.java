/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import static WBDK.WBDK_StartupConstants.PATH_IMAGES;
import WBDK.data.Draft;
import WBDK.data.Player;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_PROMPT_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_SUBHEADING_LABEL;
import static WBDK.data.WBDK_DataView.PRIMARY_STYLE_SHEET;
import static WBDK.gui.YesNoCancelDialog.CANCEL;
import java.io.File;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class PlayersItemDialog extends Stage{
    public static final String COMPLETE = "Complete";
    Player playerItem;
    GridPane gridPane;
    Scene dialogScene;
    Label headingLabel;
    Label descriptionLabel;
    Label ft_Label;
    Label pos_Label;
    Label contract_Label;
    TextField descriptionTextField;
    //Label dateLabel;
    //DatePicker datePicker;
    //Label urlLabel;
    //TextField urlTextField;
    Button completeButton;
    Button cancelButton;
    ComboBox ft_ComboBox;
    ComboBox pos_ComboBox;
    ComboBox contract_ComboBox;
    HBox ft_HBox;
    HBox pos_HBox;
    HBox contract_HBox;
    Image image;
    Image image2;
    String selection;
    Label playerPosLabel;
    Label playerNameLabel;
    public static final String EDIT_PLAYER_TITLE = "Edit Player";
    
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
        headingLabel = new Label("Player Details");
        headingLabel.getStyleClass().add(CLASS_SUBHEADING_LABEL);
    
        
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

        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
    }

    public Player showEditPlayerItemDialog(Player itemToEdit) {
        // NOW THE DESCRIPTION 
        descriptionLabel = new Label("Salary: ");
       // descriptionLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        
        playerNameLabel = new Label();
        playerPosLabel = new Label();
        
        descriptionTextField = new TextField();
        descriptionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //StringProperty temp = null;
           // temp.set(newValue);
            playerItem.setNotes(newValue);
        });
        
        
        
        // SET UP THE FANTASY HBOX
        ft_Label = new Label("Fantasy Team: ");
        ft_ComboBox = new ComboBox();
        
        // SET UP THE CONTRACT HBOX
        contract_Label = new Label("Contract: ");
        contract_ComboBox = new ComboBox();
        
        // SET UP THE POSITION HBOX
        pos_Label = new Label("Fantasy Team: ");
        pos_ComboBox = new ComboBox();
        // SET THE DIALOG TITLE
        setTitle(EDIT_PLAYER_TITLE);
        ImageView iv = new ImageView();
        ImageView iv2 = new ImageView();
        image = new Image("file:" + PATH_IMAGES+itemToEdit.getLastName()+itemToEdit.getFirstName()+".jpg");
        image2 = new Image("file:" + PATH_IMAGES+itemToEdit.getPlaceOfBirth()+".png");
        iv.setImage(image);
        iv2.setImage(image2);
        playerNameLabel = new Label(itemToEdit.getFirstName()+" "+itemToEdit.getLastName());
        playerNameLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        playerPosLabel = new Label(itemToEdit.getPossiblePositions());
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.getChildren().add(iv2);
        vbox.getChildren().add(playerNameLabel);
        vbox.getChildren().add(playerPosLabel);
        gridPane.add(iv, 0, 1);
        gridPane.add(vbox,1,1);
                
        
        // NOW LET'S ARRANGE THEM ALL AT ONCE
        gridPane.add(headingLabel, 0, 0, 2, 1);
        gridPane.add(ft_Label, 0, 3, 1, 1);
        gridPane.add(ft_ComboBox, 1, 3, 1, 1);
        gridPane.add(pos_Label, 0,4,1,1);
        gridPane.add(pos_ComboBox, 1,4,1,1);
        gridPane.add(contract_Label, 0,5,1,1);
        gridPane.add(contract_ComboBox, 1,5,1,1);
        gridPane.add(descriptionLabel, 0, 6, 1, 1);
        gridPane.add(descriptionTextField, 1, 6, 1, 1);
        gridPane.add(completeButton, 1, 7, 1, 1);
        gridPane.add(cancelButton, 2, 7, 1, 1);
                
        
        // RESET THE SCHEDULE ITEM OBJECT WITH DEFAULT VALUES
        playerItem = new Player();
        
        // LOAD THE UI STUFF
        descriptionTextField.setText(playerItem.getNotes());
        
        
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
